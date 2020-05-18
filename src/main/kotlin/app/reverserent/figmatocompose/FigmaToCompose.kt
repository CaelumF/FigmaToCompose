package app.reverserent.figmatocompose

import BaseNodeMixin
import DefaultFrameMixin
import FigmaFile
import GeometryMixin
import LayoutMixin
import RectangleNode
import SolidPaint
import TextNode
import com.beust.klaxon.Klaxon
import com.github.kittinunf.fuel.httpGet
import io.ktor.application.Application
import io.ktor.application.install
import io.ktor.features.CallLogging
import io.ktor.features.DefaultHeaders
import tokeyboi
import java.awt.Toolkit
import java.awt.datatransfer.Clipboard
import java.awt.datatransfer.StringSelection
import java.io.*

fun updateFile(fileUrl: String) {
    val freshFigmaFile = "https://api.figma.com/v1/files/$fileUrl"
        .httpGet()
        .header("X-Figma-Token", tokeyboi)
        .responseString()
//    Klaxon().parseJsonObject(Klaxon().toReader(StringBufferInputStream(freshFigmaFile.third.get())))
    val parsedFigmaFile = Klaxon().parse<FigmaFile>(StringBufferInputStream(freshFigmaFile.third.get()))!!
    val fos: FileOutputStream = FileOutputStream(File(fileUrl))
    val os = ObjectOutputStream(fos)
    os.writeObject(parsedFigmaFile)
    os.close()
    fos.close()
}

fun readFromFile(filePath: String) = ObjectInputStream(FileInputStream(File(filePath))).readObject() as FigmaFile

fun Application.main() {
    install(DefaultHeaders)
    install(CallLogging)

    routing {
        post("/") {
            val nodeJsonToConvert = call.receive<String>();
            try {
                val parsedFigmaFile = Klaxon().parse<BaseNodeMixin>(StringBufferInputStream(nodeJsonToConvert))!!
                val output = makeCompose(parsedFigmaFile).removeNoAffectPatterns()
                call.respondText(output, ContentType.Text.Plain)
                println(output)

                //Set clipboard to new output
                val selection = StringSelection(output)
                val clipboard: Clipboard = Toolkit.getDefaultToolkit().getSystemClipboard()
                clipboard.setContents(selection, selection)

            } catch (e: Exception) {
                println("We rockin' an axeception: $e")
                e.printStackTrace()
            }
        }
    }
}


fun RectangleNode.toString(): String {
    return ""
}

class Modifier(modifiersFromParent: (Modifier.() -> Unit)? = null) {
    var total: String = "modifier = app.reverserent.figmatocompose.Modifier"

    init {
        modifiersFromParent?.invoke(this)
    }

//    fun clear() {
//        total = ""
//    }

    fun preferredSize(widthDp: Number, heightDp: Number) {
        total += ".preferredSize($widthDp.dp, $heightDp.dp)"
    }

    fun tag(tag: String) {
        total += ".tag(\"$tag\")"
    }

    fun fillMaxSize() {
        total += ".fillMaxSize()"
    }

    fun fillMaxWidth() {
        total += ".fillMaxWidth()"
    }

    fun drawOpacity(amount: Float) {
        total += ".drawOpacity(${amount}f)"
    }

    fun preferredWidth(widthDp: Number) {
        total += ".preferredWidth($widthDp.dp)"
    }

    fun preferredHeight(heightDp: Number) {
        total += ".preferredHeight($heightDp.dp)"
    }

    fun fillMaxHeight() {
        total += ".fillMaxHeight()"
    }

    fun none() {
        total += ".none()"
    }

    enum class AlignmentOption() {
        Start,
        End,
        CenterHorizontally,
        CenterVertically
    }

    fun gravity(alignment: AlignmentOption) {
        total += ".gravity(Alignment.${alignment.name})"
    }

    fun drawBackground(color: RGBA) {
        total += ".drawBackground(${color.toComposeColor()})"
    }
}

fun RGBA.toComposeColor() = "Color(${this.r}f, ${this.g}f, ${this.b}f, ${this.a}f)"

private fun String.removeNoAffectPatterns(): String =
    //NaNf biases mean the child is the same width as the parent so the bias has no affect
    this.replace(Regex(".*verticalBias = NaNf"), "")
        .replace(Regex(".*horizontalBias = NaNf"), "")


fun Mods(extraModifiers: (Modifier.() -> Unit)? = null, mods: Modifier.() -> Unit = { none() }): String {
    val modifier = Modifier(extraModifiers)
    mods.invoke(modifier)
    return modifier.total
}

//fun Number.divideOrEqual(other: Number)
//fun replicate
//DONE: Special behaviour for HORIZONTAL layoutMode aka groups

fun makeCompose(node: BaseNodeMixin, extraModifiers: (Modifier.() -> Unit)? = null): String {
//    val parentLayout: LayoutMixin? = (if (node.parent is LayoutMixin) node.parent else null) as LayoutMixin?
    return when {
        node is DefaultFrameMixin && node.layoutMode != null && node.layoutMode != "NONE" -> autoLayoutToComposeRowColumn(
            node,
            extraModifiers
        )

        node is DefaultFrameMixin -> frameToComposeConstraintsLayout(
            node,
            extraModifiers
        )

        node is RectangleNode -> with(node) {
            """
               Box(${Mods(extraModifiers) {
                preferredSize(
                    width,
                    height
                )
            }} ${getStyleMods(this)} ){} 
            """.trimIndent()
        }
        node is TextNode -> with(node) {
            """
                ${node.characters?.let { text ->
                "Text".args("\"$text\"", Mods(extraModifiers) {
                    preferredWidth(node.width)
                    preferredHeight(node.height)
                },
                    "style = currentTextStyle().copy".args(
                        "color = " + when (this.fills?.get(0)?.type) {
                            "SOLID" -> with(this.fills?.get(0) as SolidPaint) {
                                this.color.toComposeColor()
                            }
                            else -> "Color.BLACK"
                        },
                        //TODO: RTL text support
                        "textAlign = " + when(this.textAlignHorizontal) {
                            "LEFT" -> "TextAlign.Left"
                            "RIGHT" -> "TextAlign.Right"
                            "CENTER" -> "TextAlign.Center"
                            "JUSTIFIED" -> "TextAlign.Justify"

                            else -> throw Exception("Horizontal text alignment type ${this.textAlignHorizontal} is new to me")
                        }
                    ),
                )
            }}
            """.trimIndent()
        }
        else -> ""
    }
}

fun getStyleMods(node: BaseNodeMixin): String {
    return when (node) {
        is GeometryMixin -> with(node) {
            Mods() {
                total = "+ Modifier"
                node.fills?.forEach { fill ->
                    when (fill) {
                        is SolidPaint -> drawBackground(fill.color)
                    }
                }
                //If this is pointless just do nothing
                if (total == "+ Modifier") total = ""
            }
        }
        else -> ""
    }
}

private fun Element(name: String, vararg parameters: String, body: () -> String) =
    Element(name, (parameters).joinToString(", "), body.invoke())

private fun Element(name: String, parameters: String, body: String) = """
    $name($parameters) {
       ${body.split("\n").joinToString("\n    ")}
    }
""".trimIndent()


//DONE: When parent is a Frame layout, and the constraints are not Top and Left
//DONE: Learn about equivelants to sConstraints in Compose
//Problem: Constraints in Figma change the x, y, width and height when changes are made to the parent element
// Convert dps into percentages if the Constraints are not top and left?
// Using constraint layouts can be an easy enough solution
fun BaseNodeMixin.localX(parent: BaseNodeMixin? = null as BaseNodeMixin): Double {

    if (this is LayoutMixin) {
        return this.x
    }

//    From when this used to use the api rather than the plugin interface
//    if (parent is LayoutMixin && this is LayoutMixin) {
//        val parentLayout = parent as LayoutMixin
//        val parentX = parentLayout.x.toDouble()
//        val thisX = this.x.toDouble()
//        return (Math.abs(parentX) - Math.abs(thisX)) * -parentX.compareTo(thisX)
//    } else if (this is LayoutMixin) {
//        return this.x
//    }
    throw Exception("Not a a layout")
}


fun BaseNodeMixin.localY(parent: BaseNodeMixin? = null): Double {
    if (this is LayoutMixin) {
        return this.y
    }
    throw Exception("Not a a layout")
}

package app.reverserent.figmatocompose

import BaseNodeMixin
import ConstraintMixin
import DefaultFrameMixin
import FigmaFile
import GeometryMixin
import LayoutMixin
import RGBA
import RectangleNode
import SolidPaint
import TextNode
import com.beust.klaxon.Klaxon
import com.github.kittinunf.fuel.httpGet
import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.application.install
import io.ktor.features.CallLogging
import io.ktor.features.DefaultHeaders
import io.ktor.http.ContentType
import io.ktor.request.receive
import io.ktor.request.receiveText
import io.ktor.response.respondText
import io.ktor.routing.get
import io.ktor.routing.post
import io.ktor.routing.put
import io.ktor.routing.routing
import io.ktor.server.engine.embeddedServer
import io.ktor.server.jetty.Jetty
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
        node is DefaultFrameMixin && node.layoutMode != null && node.layoutMode != "NONE" -> autoLayoutToString(
            node,
            extraModifiers
        )

        node is DefaultFrameMixin -> frameToString(
            node,
            extraModifiers
        )

        node is RectangleNode -> with(node) {
            """
               Box(${app.reverserent.figmatocompose.Mods {
                preferredSize(
                    width,
                    height
                )
            }} ${app.reverserent.figmatocompose.getStyleMods(this)} ){} 
            """.trimIndent()
        }
        node is TextNode -> with(node) {
            """
                ${node.characters?.let { text ->
                "Text".args("\"$text\"")
            }}
            """.trimIndent()
        }
        else -> ""
    }
}

fun getStyleMods(node: BaseNodeMixin): String {
    return when (node) {
        is GeometryMixin -> with(node) {
            app.reverserent.figmatocompose.Mods() {
                total = "+ app.reverserent.figmatocompose.Modifier"
                node.fills?.forEach { fill ->
                    when (fill) {
                        is SolidPaint -> drawBackground(fill.color)
                    }
                }
                //If this is pointless just do nothing
                if (total == "+ app.reverserent.figmatocompose.Modifier") total = ""
            }
        }
        else -> ""
    }
}

private fun String.args(vararg parameters: String) = "${this}(${parameters.joinToString(", ")})"
private fun String.body(body: String) = """
    $this {
        ${body.split("\n").joinToString("\n    ")}
    }
    """.trimIndent()

private fun Element(name: String, vararg parameters: String, body: () -> String) =
    Element(name, (parameters).joinToString(", "), body.invoke())

private fun Element(name: String, parameters: String, body: String) = """
    $name($parameters) {
       ${body.split("\n").joinToString("\n    ")}
    }
""".trimIndent()

//TODO When to Fill Max Size
private fun frameToString(node: DefaultFrameMixin, extraModifiers: (Modifier.() -> Unit)?): String {
    return with(node) {
        if (children != null) {
            //TODO: Refactor with knowledge that all ConstraintMixins are also LayoutMixins
            val childrenTagPairs = children!!
                .filter { it is ConstraintMixin }
                .map { Pair(it.name ?: it.id ?: throw Exception("No id!"), it) }


            "ConstraintLayout".args(
                "${app.reverserent.figmatocompose.Mods(extraModifiers) { drawOpacity(1.0f) }} ${app.reverserent.figmatocompose.getStyleMods(
                    this
                )}",
                "constraintSet = ${"ConstraintSet".body(
                    """
                    // Tags for each constrained
                    ${childrenTagPairs.mapIndexed() { index: Int, pair: Pair<String, BaseNodeMixin> -> "val child${index} = tag(\"${index}_${pair.first}\") " }
                        .joinToString("\n")}
                                           
                    // --
                                           
                    // Constraints
                    ${childrenTagPairs.mapIndexed { index: Int, child: Pair<String, BaseNodeMixin> ->
                        val childNode = child.second as BaseNodeMixin
                        val childLayout = child.second as LayoutMixin
                        """
                           ${"child${index}.apply".body(
                            """
                            ${app.reverserent.figmatocompose.horizontalConstraints(
                                index,
                                child,
                                childLayout,
                                node,
                                childNode
                            )}
                            ${app.reverserent.figmatocompose.verticalConstraints(
                                index,
                                child,
                                childLayout,
                                node,
                                childNode
                            )}
                            
                           """.trimIndent()
                        )} 
                        """.trimIndent()

                    }.joinToString("\n")}
                """.trimIndent()
                )}"
            ).body(
                """
               // Constraint layout app.reverserent.figmatocompose.body
                    ${children?.mapIndexed { index, child ->
                    app.reverserent.figmatocompose.makeCompose(child) {
                        tag("${index}_${child.name}")
                    }
                }?.joinToString("\n")}
                """.trimIndent()
            )
        } else "Box(){}"
    }
}

private fun horizontalConstraints(
    index: Int,
    child: Pair<String, BaseNodeMixin>,
    childLayout: LayoutMixin,
    node: DefaultFrameMixin,
    childNode: BaseNodeMixin
): String {
    return """
        ${when ((child.second as ConstraintMixin).constraints?.horizontal) {
        //Left constrained to left not necessary as this is default
        "MIN",
        "LEFT" -> """
                                left constrainTo parent.left
                                width = ${"valueFixed".args("${childLayout.width}.dp")}
                                left.margin = ${childNode.localX(node)}.dp
                            """.trimIndent()
        "MAX",
        "RIGHT" -> """
                                right constrainTo parent.right
                                width = ${"valueFixed".args("${childLayout.width}.dp")}
                                right.margin = ${node.width - (childLayout.width + childNode.localX(node))}.dp
                            """.trimIndent()
        // Percentages
        "SCALE" ->
            """
                        left constrainTo parent.left
                        right constrainTo parent.right
                        width = percent(${(childLayout.width.toDouble() / node.width.toDouble()) * 100}f)
                        horizontalBias = ${childNode.localX(node)
                .toDouble() / (node.width.toDouble() - childLayout.width.toDouble())}f
            """.trimIndent()
        //Margins
        "STRETCH",
        "LEFT_RIGHT" -> """
                            left constrainTo parent.left
                            left.margin = ${childNode.localX(node)}.dp
                            right constrainTo parent.right
                            right.margin = ${node.width - (childLayout.width + childNode.localX(node))}.dp
                            width = percent(${(childLayout.width.toDouble() / node.width.toDouble()) * 100}f)
                        """.trimIndent()
        "CENTER" -> """
                        left constrainTo parent.left
                        right constrainTo parent.right
                        horizontalBias = ${childNode.localX(node)
            .toDouble() / (node.width.toDouble() - childLayout.width.toDouble())}f
                    """.trimIndent()

        else -> throw Exception("nonexistant or unknown constraint type")
    }}
    """.trimIndent()
}

private fun verticalConstraints(
    index: Int,
    child: Pair<String, BaseNodeMixin>,
    childLayout: LayoutMixin,
    node: DefaultFrameMixin,
    childNode: BaseNodeMixin
): String {
    return """
        ${when ((child.second as ConstraintMixin).constraints?.vertical) {
        //Left constrained to left not necessary as this is default
        "MIN",
        "TOP" -> """
                                top constrainTo parent.top
                                height = ${"valueFixed".args("${childLayout.height}.dp")}
                                top.margin = ${childNode.localY(node)}.dp
                            """.trimIndent()
        "MAX",
        "BOTTOM" -> """
                                bottom constrainTo parent.bottom
                                height = ${"valueFixed".args("${childLayout.height}.dp")}
                                bottom.margin = ${node.height - (childLayout.height + childNode.localY(node))}.dp 
                            """.trimIndent()
        // Percentages
        "SCALE" ->
            """
                        top constrainTo parent.top
                        bottom constrainTo parent.bottom
                        height = percent(${(childLayout.height.toDouble() / node.height.toDouble()) * 100}f)
                        verticalBias = ${childNode.localY(node)
                .toDouble() / (node.height.toDouble() - childLayout.height.toDouble())}f
            """.trimIndent()
        //Margins
        "STRETCH",
        "TOP_BOTTOM" -> """
                            top constrainTo parent.top
                            bottom constrainTo parent.bottom
                            height = percent(${(childLayout.height.toDouble() / node.height.toDouble()) * 100}f)
                            bottom.margin = ${node.height - (childLayout.height + childNode.localY(node))}.dp
                            top.margin = ${childNode.localY(node)}.dp
                        """.trimIndent()
        "CENTER" -> """
                        top constrainTo parent.top
                        bottom constrainTo parent.bottom
                        verticalBias = ${childNode.localY(node)
            .toDouble() / (node.height.toDouble() - childLayout.height.toDouble())}f
                        
                    """.trimIndent()
        else -> throw Exception("nonexistant or unknown constraint type")
    }}
    """.trimIndent()
}

private fun autoLayoutToString(node: DefaultFrameMixin, extraModifiers: (Modifier.() -> Unit)?): String {
    return when (node.layoutMode!!) {
        "VERTICAL" -> """
            Column(${Mods(extraModifiers) {
            if (node.counterAxisSizingMode == "FIXED") preferredWidth(
                node.width
            )
        }} ${getStyleMods(
            node
        )}) {
            ${node.children?.joinToString("\n") { child ->
            makeCompose(child) {
                if (child is LayoutMixin) {
                    when (child.layoutAlign) {
                        "MIN" -> gravity(Modifier.AlignmentOption.Start)
                        "MAX" -> gravity(Modifier.AlignmentOption.End)
                        "CENTER" -> gravity(Modifier.AlignmentOption.CenterHorizontally)
                        "STRETCH" -> fillMaxWidth()
                        else -> throw Exception("unrecognized LayoutAlign ${child.layoutAlign}")
                    }
                }
            }
        }
        }
        }
            """.trimIndent()
        "HORIZONTAL" -> """
                Row(${Mods(extraModifiers) {
            if (node.counterAxisSizingMode == "FIXED") preferredHeight(
                node.height
            )
        }}) {
                    ${node.children?.joinToString("\n") { child ->
            makeCompose(child) {
                if (child is LayoutMixin) {
                    when (child.layoutAlign) {
                        "MIN" -> gravity(Modifier.AlignmentOption.Start)
                        "MAX" -> gravity(Modifier.AlignmentOption.End)
                        "CENTER" -> gravity(Modifier.AlignmentOption.CenterVertically)
                        "STRETCH" -> fillMaxHeight()
                        else -> throw Exception("unrecognized LayoutAlign ${child.layoutAlign}")
                    }
                }
            }
        }
        }
        }
            """.trimIndent()
        else -> throw Exception("${node.layoutMode}? must be one of those new features")
    }
}


//DONE: When parent is a Frame layout, and the constraints are not Top and Left
//DONE: Learn about equivelants to sConstraints in Compose
//Problem: Constraints in Figma change the x, y, width and height when changes are made to the parent element
// Convert dps into percentages if the Constraints are not top and left?
// Using constraint layouts can be an easy enough solution
fun BaseNodeMixin.localX(parent: BaseNodeMixin? = null as BaseNodeMixin): Double {

    if (parent is LayoutMixin && this is LayoutMixin) {
        val parentLayout = parent as LayoutMixin
        val parentX = parentLayout.x.toDouble()
        val thisX = this.x.toDouble()
        return (Math.abs(parentX) - Math.abs(thisX)) * -parentX.compareTo(thisX)
    } else if (this is LayoutMixin) {
        return this.x
    }
    throw Exception("Not layouts ! :(")
}


fun BaseNodeMixin.localY(parent: BaseNodeMixin? = null): Double {
    if (parent is LayoutMixin && this is LayoutMixin) {
        val parentLayout = parent as LayoutMixin
        val parentY = parentLayout.y.toDouble()
        val thisY = this.y.toDouble()
        return (Math.abs(parentY) - Math.abs(thisY)) * parentY.compareTo(thisY)
    } else if (this is LayoutMixin) {
        return this.x
    }
    throw Exception("Not layouts ! :(")
}

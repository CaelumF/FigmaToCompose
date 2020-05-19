package app.roomtorent.figmatocompose

import java.io.Serializable

fun String.args(vararg parameters: String) = "${this}(${parameters.joinToString(", ")})"
fun String.body(body: String) = """
    $this {
        ${body.split("\n").joinToString("\n    ")}
    }
    """.trimIndent()

//@Serializable
open class RGBA(
    val r: Double = 1.0,
    val g: Double = 1.0,
    val b: Double = 1.0,
    val a: Double = 1.0,

    ) : Serializable

fun RGBA.toComposeColor() = "Color(${this.r}f, ${this.g}f, ${this.b}f, ${this.a}f)"
public fun String.removeNoAffectPatterns(): String =
    //NaNf biases mean the child is the same width as the parent so the bias has no affect
    this.replace(Regex(".*verticalBias = NaNf"), "")
        .replace(Regex(".*horizontalBias = NaNf"), "")

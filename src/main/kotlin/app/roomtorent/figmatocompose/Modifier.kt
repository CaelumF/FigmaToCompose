package app.roomtorent.figmatocompose

import ColorStop

class Modifier(modifiersFromParent: (Modifier.() -> Unit)? = null) {
    var total: String = "modifier = Modifier"

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

    fun paintVectorPaint(drawableIntPath: String) {
        total += ".paint".args("VectorPainter".args("vectorResource".args(drawableIntPath)))
    }

    fun linearGradientBackground(
        stops: Array<ColorStop>,
        width: Float,
        gradientTransform: ArrayList<ArrayList<Double>>? = null
    ) {
        //TODO: Support specific 2d gradient end and start
        total += ".drawBackground".args(
            "HorizontalGradient".args(
                stops.joinToString { "${it.position}f to ${it.color?.toComposeColor()}" },
                "startX = Px.Zero",
                "endX = ${width}.dp.toPx()"
            )
        )
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

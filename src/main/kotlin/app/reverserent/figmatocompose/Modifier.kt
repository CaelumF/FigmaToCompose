package app.reverserent.figmatocompose

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

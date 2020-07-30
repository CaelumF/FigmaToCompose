package app.roomtorent.figmatocompose

/**
 * Utility for calling a Compose composable function
 *
 * Extensions of this class can make remembering the parameters of built-in composables foolproof.
 *
 * Additionally, when differences to the Jetpack Compose interface are made, implementations of this can be more easily changed
 * to accept the same parameters and have a different String output.
 */
abstract class Composable() {
    abstract val name: String

    override fun toString() = getAsString()

    private fun getAsString(content: String? = null): String {
        return if(content != null) name.args("")
        else name.args("").body(content.toString())
    }
}

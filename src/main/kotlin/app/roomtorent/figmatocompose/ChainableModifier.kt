package app.roomtorent.figmatocompose

import BaseNodeMixin
import BlendMixin
import ColorStop
import CornerMixin
import GeometryMixin
import GradientPaint
import LayoutMixin
import RectangleCornerMixin
import ShadowEffect
import SolidPaint

class Modifier(modifiersFromParent: (Modifier.() -> Unit)? = null) {
    val ownModifiers = arrayListOf<ChainableModifier>()
    val inheritedModifiers: ArrayList<ChainableModifier>

    fun getBuiltOptimized(): String {
        if (ownModifiers.isEmpty() && inheritedModifiers.isEmpty()) return ""
        var combined =  ownModifiers.apply { if (this.isNotEmpty() && inheritedModifiers.isNotEmpty()) add(CustomModSeparator()) } + inheritedModifiers
        if (Settings.Optimizations.omitExtraShadows) {
            val biggestShadow: DrawShadow? = combined
                .filterIsInstance<DrawShadow>()
                .maxBy { it.dp }
            if (biggestShadow != null) {
                val withOnlyBiggestShadow: List<ChainableModifier> = combined
                    .filter { it !is DrawShadow }
                    .apply { (this as ArrayList<ChainableModifier>).add(biggestShadow) }
                combined = withOnlyBiggestShadow
            }
        }
        val (clips, notClips) = combined.partition { it is CornerRadius || it is RectangleCornerRadius }
        val clipsFirst = clips + notClips
        return clipsFirst.fold("Modifier") { acc, chainableModifier: ChainableModifier ->
            chainableModifier.addToChain(
                acc
            )
        }
    }

//    fun getBuiltRaw(): String = inheritedModifiers.fold(initial = "modifier = Modifier") { acc, chainableModifier -> chainableModifier.addToChain(acc) }

    // Execute modifiers from parent to add them as operations
    init {
        // The type safer builders add modifiers to ownModifiers, so we construct a virtual parent modifier,
        // run the builder again and set our inheritedModifiers to the virtual parent's ownModifiers
        inheritedModifiers = when {
            modifiersFromParent != null -> {
                val virtualParentModifier = Modifier()
                modifiersFromParent.invoke(virtualParentModifier)
                virtualParentModifier.ownModifiers
            }
            else -> arrayListOf()
        }
    }

    abstract class ChainableModifier {
        abstract fun addToChain(acc: String): String
    }

    class Tag(var tag: String) : ChainableModifier() {
        override fun addToChain(acc: String) = "$acc.tag(\"$tag\")"
    }

    class FillMaxSize() : ChainableModifier() {
        override fun addToChain(acc: String) = "$acc.fillMaxSize()"
    }

    class FillMaxWidth() : ChainableModifier() {
        override fun addToChain(acc: String) = "$acc.fillMaxWidth()"
    }

    class DrawOpacity(var amount: Float) : ChainableModifier() {
        override fun addToChain(acc: String) = acc + ".drawOpacity(${amount}f)"
    }

    class PreferredSize(val widthDp: Number, val heightDp: Number) : ChainableModifier() {
        override fun addToChain(acc: String) = "$acc.preferredSize($widthDp.dp, $heightDp.dp)"
    }

    class PreferredWidth(var widthDp: Number) : ChainableModifier() {
        override fun addToChain(acc: String) = "$acc.preferredWidth($widthDp.dp)"
    }

    class PreferredHeight(var heightDp: Number) : ChainableModifier() {
        override fun addToChain(acc: String) = "$acc.preferredHeight($heightDp.dp)"
    }

    class FillMaxHeight() : ChainableModifier() {
        override fun addToChain(acc: String) = "$acc.fillMaxHeight()"
    }

    class PaintVectorPaint(var drawableIntPath: String) : ChainableModifier() {
        override fun addToChain(acc: String) =
            acc + ".paint".args("VectorPainter".args("vectorResource".args(drawableIntPath)))
    }

    class CustomModSeparator() : ChainableModifier() {
        override fun addToChain(acc: String): String {
//            return if(acc == "Modifier") "+ Modifier"
            return "$acc + Modifier"
        }
    }

    class CornerRadius(val radius: Float) : ChainableModifier() {
        override fun addToChain(acc: String): String = "$acc.clip".args("RoundedCornerShape".args("$radius.dp"))
    }

    fun cornerRadius(radius: Float) = if(radius != 0f) ownModifiers.add(CornerRadius(radius)) else false

    class RectangleCornerRadius(
        val topLeftRadius: Double,
        val topRightRadius: Double,
        val bottomRightRadius: Double,
        val bottomLeftRadius: Double
    ) : ChainableModifier() {
        override fun addToChain(acc: String): String =
            "$acc.clip".args("RoundedCornerShape".args("$topLeftRadius.dp, $topRightRadius.dp, $bottomRightRadius.dp, $bottomLeftRadius.dp"))
    }

    fun rectangleCornerRadius(
        topLeftRadius: Double,
        topRightRadius: Double,
        bottomLeftRadius: Double,
        bottomRightRadius: Double,
        simplifyToCornerRadiusIfEqual: Boolean = true,
        omitIfAllZero: Boolean = true,
    ) {
        if (topLeftRadius == topRightRadius && topRightRadius == bottomRightRadius && bottomRightRadius == bottomLeftRadius) {
            if (omitIfAllZero && topLeftRadius == 0.0) return
            if (simplifyToCornerRadiusIfEqual) {
                ownModifiers.add(CornerRadius(topLeftRadius.toFloat()))
                return
            }
        }
        ownModifiers.add(
            RectangleCornerRadius(
                topLeftRadius,
                topRightRadius,
                bottomLeftRadius,
                bottomRightRadius
            )
        )
    }

    class LinearGradientBackground(
        var stops: Array<ColorStop>,
        var width: Float,
        var gradientTransform: ArrayList<ArrayList<Double>>? = null
    ) : ChainableModifier() {
        override fun addToChain(acc: String) = acc + ".drawBackground".args(
            "HorizontalGradient".args(
                stops.joinToString { "${it.position}f to ${it.color?.toComposeColor()}" },
                "startX = 0f",
                "endX = ${width}.dp.value.toFloat()"
            )
        )
    }

    class Border() : ChainableModifier() {
        override fun addToChain(acc: String): String = "$acc."
    }

    class None() : ChainableModifier() {
        override fun addToChain(acc: String) = "$acc.none()"
    }

    class DrawShadow(var dp: Float) : ChainableModifier() {
        override fun addToChain(acc: String) = acc + ".drawShadow".args("${dp}.dp")
        /*TODO: Other parameter: shape: Shape = RectangleShape,
        clipToOutline: Boolean = elevation > 0.dp,
        @FloatRange(from = 0.0, to = 1.0) opacity: Float = 1f*/
    }


    class Gravity(var alignment: AlignmentOption) : ChainableModifier() {
        override fun addToChain(acc: String) = acc + ".gravity(Alignment.${alignment.name})"
    }

    class DrawBackground(var color: RGBA, var opacityOverride: Float? = null) : ChainableModifier() {
        override fun addToChain(acc: String) = acc + ".drawBackground(${color.toComposeColor(opacityOverride)})"
    }

    class WrapContentSize() : ChainableModifier() {

        override fun addToChain(acc: String): String = "$acc.wrapContentSize".args()
    }

    enum class Alignment{
        CenterVertically, Top, Bottom
    }
    class WrapContentHeight(val alignment: Alignment): ChainableModifier() {
        override fun addToChain(acc: String): String = "$acc.wrapContentHeight".args("Alignment.${alignment.name}")
    }

    fun wrapContentHeight(alignment: Alignment) = ownModifiers.add(WrapContentHeight(alignment))

    /**
     * For setting the modifier of the first composable inside one of our own composables to the modifier passed as a parameter called "modifier"
     */
    class ClassProperties() : ChainableModifier() {
        override fun addToChain(acc: String): String = "modifier"
    }

    fun tag(tag: String) = ownModifiers.add(Tag(tag))

    fun fillMaxSize() = ownModifiers.add(FillMaxSize())

    fun fillMaxWidth() = ownModifiers.add(FillMaxWidth())

    fun drawOpacity(amount: Float) = ownModifiers.add(DrawOpacity(amount))

    fun preferredSize(widthDp: Number, heightDp: Number) = ownModifiers.add(PreferredSize(widthDp, heightDp))

    fun preferredWidth(widthDp: Number) = ownModifiers.add(PreferredWidth(widthDp))

    fun preferredHeight(heightDp: Number) = ownModifiers.add(PreferredHeight(heightDp))

    fun fillMaxHeight() = ownModifiers.add(FillMaxHeight())

    fun paintVectorPaint(drawableIntPath: String) = ownModifiers.add(PaintVectorPaint(drawableIntPath))

    fun linearGradientBackground(
        stops: Array<ColorStop>,
        width: Float,
        gradientTransform: ArrayList<ArrayList<Double>>? = null
    ) = ownModifiers.add(LinearGradientBackground(stops, width, gradientTransform))

    fun none() = ownModifiers.add(None())

    fun drawShadow(dp: Float) = ownModifiers.add(DrawShadow(dp))


    fun gravity(alignment: AlignmentOption) = ownModifiers.add(Gravity(alignment))

    fun referredSize(widthDp: Number, heightDp: Number) = PreferredSize(widthDp, heightDp)

    fun drawBackground(color: RGBA, opacityOverride: Float? = null) =
        ownModifiers.add(DrawBackground(color, opacityOverride))

    fun customModSeparator() = ownModifiers.add(CustomModSeparator())
    fun addPassedProperties() = ownModifiers.add(ClassProperties())

    fun addStyleMods(node: BaseNodeMixin) {
        if (node is GeometryMixin) {
            node.fills
                ?.filter { it.visible }
                ?.forEach { fill ->
                    when {
                        //Different gradient types share the same Kotlin type, so for now look at fill.type
                        fill.type == "GRADIENT_LINEAR" -> with(fill as GradientPaint) {
                            linearGradientBackground(
                                this.gradientStops ?: arrayOf(), (node as LayoutMixin).width.toFloat()
                            )
                        }
                        fill is SolidPaint -> drawBackground(fill.color, fill.opacity.toFloat())
                    }
                }
        }
        if (node is BlendMixin) {
            node.effects?.forEach { effect ->
                when (effect) {
                    is ShadowEffect -> drawShadow(
                        effect.radius?.toFloat()
                            ?: throw java.lang.Exception("Has shadow effect but shadow effect has null radius")
                    )
                }
            }
        }
        if (node is RectangleCornerMixin) {
            rectangleCornerRadius(
                node.topLeftRadius,
                node.topRightRadius,
                node.bottomLeftRadius,
                node.bottomRightRadius
            )
        } else if (node is CornerMixin) {
            cornerRadius(node.cornerRadius.toFloat())
        }
    }


    enum class AlignmentOption() {
        Start,
        End,
        CenterHorizontally,
        CenterVertically
    }

}

package app.roomtorent.figmatocompose

import ConstraintMixin
import Constraints
import DefaultFrameMixin
import LayoutMixin
import TextNode
import kotlin.math.pow
import kotlin.math.roundToInt

enum class Constraint {
    //    Most X or Y / Bottom or Right
    MIN,

    //    Least X or Y / Top or Left
    MAX,

    //    Fixed percentages all around
    CENTER,

    //    Fixed Margins
    STRETCH,

    //    Unspecified with - position in center
    SCALE
}

class FigmaConstraintSet(val horizontal: Constraint, val vertical: Constraint) {
    constructor(constraints: Constraints) : this(
            horizontal = typedConstraint(constraints.horizontal),
            vertical = typedConstraint(constraints.vertical))
}

private fun typedConstraint(constraint: String): Constraint {
    return when (constraint) {
        "MIN" -> Constraint.MIN
        "MAX" -> Constraint.MAX
        "CENTER" -> Constraint.CENTER
        "STRETCH" -> Constraint.STRETCH
        "SCALE" -> Constraint.SCALE
        else -> throw Exception("Unknown constraint type $constraint")
    }
}

fun getComposeConstraintAndSizeCode(parent: LayoutMixin, child: ConstraintMixin, referenceName: String): String {
    val constraintSet = FigmaConstraintSet(child.constraints ?: throw Exception("Constraints shouldn't be null"))
    val childWidth = (child as LayoutMixin).width
    val childHeight = (child as LayoutMixin).height
    val matchesParentWidth = parent.width == childWidth
    val matchesParentHeight = parent.height == childHeight
    val matchesParentSize = matchesParentWidth && matchesParentHeight


    val conciseEquivalent: String? = when {
        //TODO: Consider replacing with fillMaxSize(), though this optimization is more the domain of android studio
        matchesParentSize -> {
            // Normally I wouldn't dare pollute a tool with Do What I Mean
            // and even though if constraints are not center, this can lead to resizing differently from the design
            // 99.9% of cases where a child is the same size as its parent in the design, it is meant to occupy all its space in all scenarios
            // for the 0.01%, it should be edited
            """
                centerTo(parent)
                width = Dimension.fillToConstraints
                height = Dimension.fillToConstraints
            """.replaceIndent("   ")
        }
        else -> null
    }

    return conciseEquivalent ?: {
        val (composeHorizontalConstraint: String, composeWidth: String) =
                getComposeConstraintAndSize(constraintSet.horizontal, childWidth, child.x, parent.width, "start", "end", "Horizontal")
        val (composeVerticalConstraint: String, composeHeight: String) =
                getComposeConstraintAndSize(constraintSet.vertical, childHeight, child.y, parent.height, "top", "bottom", "Vertical")
        """
            $composeHorizontalConstraint
            $composeVerticalConstraint
            width = $composeWidth
            height = $composeHeight
        """.trimIndent()
    }()
}

private fun getComposeConstraintAndSize(
        constraint: Constraint,
        childSizeInDimension: Double,
        childPositionOnDimension: Double,
        parentSizeInDimension: Double,
        minName: String,
        maxName: String,
        dimensionName: String
): Pair<String, String> {
    var composeDimensionSize: String = ""
    var composeConstraint: String = ""
    when (constraint) {
//          Most X or Y / Bottom or Right
        Constraint.MAX -> {
            composeDimensionSize = "Dimension.value".args(childSizeInDimension.roundedDp())
            composeConstraint = "${maxName}.linkTo".args("parent.${maxName}", (parentSizeInDimension - (childSizeInDimension + childPositionOnDimension)).roundedDp())
        }
//          Least X or Y / Top or Left
        Constraint.MIN -> {
            composeDimensionSize = "Dimension.value".args(childSizeInDimension.roundedDp())
            composeConstraint = "${minName}.linkTo".args("parent.${minName}", childPositionOnDimension.roundedDp())
        }
//          Fixed percentages all around
        Constraint.SCALE -> {
            var bias = (childPositionOnDimension / (parentSizeInDimension - childSizeInDimension))
            if (bias.isNaN()) bias = 0.5
            composeDimensionSize = "Dimension.percent".args("${(childSizeInDimension / parentSizeInDimension).roundedForHuman()}f")
            composeConstraint = "linkTo(parent.${minName}, parent.${maxName}, bias = ${bias.roundedForHuman()}f)"
        }
//          Fixed Margins
        Constraint.STRETCH -> {
            composeConstraint = """
              ${"${minName}.linkTo".args("parent.${minName}", childPositionOnDimension.roundedDp())}
              ${"${maxName}.linkTo".args("parent.${maxName}", (parentSizeInDimension - (childSizeInDimension + childPositionOnDimension)).roundedDp())}
          """.trimIndent()
            composeDimensionSize = "Dimension.percent".args("${(childSizeInDimension / parentSizeInDimension).roundedForHuman()}f")
        }
//          Unspecified with - position in center
        Constraint.CENTER -> {
            composeDimensionSize = "Dimension.fillToConstraints"
            composeConstraint = "center${dimensionName}lyTo(parent)"
        }
    }
    return Pair(composeConstraint, composeDimensionSize)
}


fun frameToComposeConstraintsLayout(node: DefaultFrameMixin, extraModifiers: (Modifier.() -> Unit)?): String {
    //Create references
    val constraintReferences = arrayListOf<String>()

    val constraintChildren: List<String> = node.children?.map { childNode ->
        val constraintReference = childNode.name!!.toKotlinIdentifier().also { constraintReferences.add(it) }
        makeCompose(childNode) {
            //Some children of a frame may not be
            if (childNode is ConstraintMixin && childNode is LayoutMixin) {
                constrainAs(constraintReference, getComposeConstraintAndSizeCode(node, childNode, constraintReference))
            } else {
                throw Exception("All children of a frame are expected to have constraints")
            }
        }
    } ?: listOf()
    val createComposeReferencesCode = ""
    return """
            ConstraintLayout(${Mods(extraModifiers) { addStyleMods(node) }}) {
                val (${constraintReferences.joinToString(separator = ", ")}) = createRefs()
                $createComposeReferencesCode
                
                 ${constraintChildren.joinToString(separator = "\n")}
            }
            """.trimIndent()
}

fun Double.roundTo(numFractionDigits: Int): Double {
    val factor = 10.0.pow(numFractionDigits.toDouble())
    return (this * factor).roundToInt() / factor
}

fun Double.roundedForHuman(): String = this.roundTo(Settings.Optimizations.dpDecimalPlaces).toString()
fun Double.roundedDp(): String = this.roundedForHuman() + ".dp"

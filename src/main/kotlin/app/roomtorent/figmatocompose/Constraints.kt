package app.roomtorent.figmatocompose

import BaseNodeMixin
import ConstraintMixin
import DefaultFrameMixin
import LayoutMixin

fun horizontalConstraints(
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
        // Percentages (heh not really "per cent" as of dev11)
        "SCALE" ->
            """
                        left constrainTo parent.left
                        right constrainTo parent.right
                        width = percent(${(childLayout.width / node.width) * 1/*00*/}f)
                        horizontalBias = ${childNode.localX(node) / (node.width - childLayout.width)}f
            """.trimIndent()
        //Margins
        "STRETCH",
        "LEFT_RIGHT" -> """
                            left constrainTo parent.left
                            left.margin = ${childNode.localX(node)}.dp
                            right constrainTo parent.right
                            right.margin = ${node.width - (childLayout.width + childNode.localX(node))}.dp
                            width = percent(${(childLayout.width / node.width) * 1/*00*/}f)
                        """.trimIndent()
        "CENTER" -> """
                        left constrainTo parent.left
                        right constrainTo parent.right
                        horizontalBias = ${childNode.localX(node) / (node.width - childLayout.width)}f
                    """.trimIndent()

        else -> throw Exception("nonexistant or unknown constraint type")
    }}
    """.trimIndent()
}

fun verticalConstraints(
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
                        height = percent(${(childLayout.height / node.height) * 1/*00*/}f)
                        verticalBias = ${childNode.localY(node) / (node.height - childLayout.height)}f
            """.trimIndent()
        //Margins
        "STRETCH",
        "TOP_BOTTOM" -> """
                            top constrainTo parent.top
                            bottom constrainTo parent.bottom
                            height = percent(${(childLayout.height / node.height) * 1/*00*/}f)
                            bottom.margin = ${node.height - (childLayout.height + childNode.localY(node))}.dp
                            top.margin = ${childNode.localY(node)}.dp
                        """.trimIndent()
        "CENTER" -> """
                        top constrainTo parent.top
                        bottom constrainTo parent.bottom
                        verticalBias = ${childNode.localY(node)
                .toDouble() / (node.height - childLayout.height)}f
                        
                    """.trimIndent()
        else -> throw Exception("nonexistant or unknown constraint type")
    }}
    """.trimIndent()
}

//TODO When to Fill Max Size
fun frameToComposeConstraintsLayout(node: DefaultFrameMixin, extraModifiers: (Modifier.() -> Unit)?): String {
    return with(node) {
        if (children != null) {
            //TODO: Refactor with knowledge that all ConstraintMixins are also LayoutMixins
            val childrenTagPairs = children!!
                    .filter { it is ConstraintMixin }
                    .map { Pair(it.name ?: it.id ?: throw Exception("No id!"), it) }


            "ConstraintLayout".args(
                    "modifier = ${Mods(extraModifiers) { addStyleMods(node) }}",
                    "constraintSet = ${"ConstraintSet".body(
                            when {
//                                Special scenarios where more short constraints are possible
                                else -> """
                    ${childrenTagPairs.mapIndexed() { index: Int,
                                                      nameNodePair: Pair<String, BaseNodeMixin> ->
                                    "val ${nameNodePair.first.toKotlinIdentifier()}_${index} = tag(\"${index}_${nameNodePair.first}\") "
                                }.joinToString("\n")}
                        
                    ${childrenTagPairs.mapIndexed { index: Int, nameNodePair: Pair<String, BaseNodeMixin> -> // Constraints
                                    val childNode = nameNodePair.second as BaseNodeMixin
                                    val childLayout = nameNodePair.second as LayoutMixin
                                    """
                           ${"${nameNodePair.first.toKotlinIdentifier()}_${index}.apply".body(
                                            """
                            ${horizontalConstraints(
                                                    index,
                                                    nameNodePair,
                                                    childLayout,
                                                    node,
                                                    childNode
                                            )}
                            ${verticalConstraints(
                                                    index,
                                                    nameNodePair,
                                                    childLayout,
                                                    node,
                                                    childNode
                                            )}
                            
                           """.trimIndent()
                                    )} 
                        """.trimIndent()

                                }.joinToString("\n")}
                """.trimIndent()
                            }
                    )}"
            ).body(
                    """
               // Constraint layout body
                    ${children?.mapIndexed { index, child ->
                        makeCompose(child) {
                            tag("${index}_${child.name}")
                        }
                    }?.joinToString("\n")}
                """.trimIndent()
            )
        } else "Box(){}"
    }
}

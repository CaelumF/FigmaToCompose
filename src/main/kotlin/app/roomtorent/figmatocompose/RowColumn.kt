package app.roomtorent.figmatocompose

import DefaultFrameMixin
import LayoutMixin

fun autoLayoutToComposeRowColumn(node: DefaultFrameMixin, extraModifiers: (ModifierChain.() -> Unit)?): String {
    return when (node.layoutMode!!) {
        "VERTICAL" -> """
            Column(${Mods(extraModifiers) {
            if (node.counterAxisSizingMode == "FIXED") preferredWidth(
                node.width
            )
        }}, verticalArrangement = ${"Arrangement.spacedBy".args("${node.itemSpacing}.dp")}, horizontalAlignment = ${
            when(node.counterAxisAlignItems) {
                "MIN" -> "Alignment.Start"
                "MAX" -> "Alignment.End"
                "CENTER" -> "Alignment.CenterHorizontally"
                else -> throw Exception("Unrecognized counterLayoutAlign ${node.counterAxisAlignItems}")
            }
        }) {
            ${if(node.verticalPadding?.equals(0.0) == false) "Spacer(modifier = Modifier.height(${node.verticalPadding?.roundedDp()}))" else ""}
            ${node.children?.joinToString("\n") { child ->
                makeCompose(child) {
                    if (child is LayoutMixin) {
                        size(child.width, child.height)
                        when (child.layoutAlign) {
                            "STRETCH" -> fillMaxWidth()
                            "MIN" -> gravity(ModifierChain.AlignmentOption.Start) // Deprecated in figma but still used in designs for now
                            "MAX" -> gravity(ModifierChain.AlignmentOption.End) // Deprecated in figma but still used in designs for now
                            "CENTER" -> gravity(ModifierChain.AlignmentOption.CenterHorizontally) // Deprecated in figma but still used in designs for now
                            "INHERIT" -> {}
                            else -> throw Exception("unrecognized LayoutAlign ${child.layoutAlign}")
                        }
                    }
                }
            }
           }
        ${if(node.verticalPadding?.equals(0.0) == false) "Spacer(modifier = Modifier.height(${node.verticalPadding?.roundedDp()}))" else ""}
        }
            """.trimIndent()
        "HORIZONTAL" -> """
                Row(${Mods(extraModifiers) {
            if (node.counterAxisSizingMode == "FIXED") preferredHeight(
                node.height
            )
            addStyleMods(node)
        }}, horizontalArrangement = ${"Arrangement.spacedBy".args("${node.itemSpacing}.dp")}, verticalAlignment = ${
            when(node.counterAxisAlignItems) {
                "MIN" -> "Alignment.Bottom"
                "MAX" -> "Alignment.Top"
                "CENTER" -> "Alignment.CenterVertically"
                else -> throw Exception("Unrecognized counterLayoutAlign ${node.counterAxisAlignItems}")
            }}) {
            ${if(node.horizontalPadding?.equals(0.0) == false) "Spacer(modifier = Modifier.width(${node.horizontalPadding?.roundedDp()}))" else ""}
            ${node.children?.joinToString("\n") { child ->
            makeCompose(child) {
                // Child's own properties for whether to stretch
                if (child is LayoutMixin) {
                    size(child.width, child.height)
                    when (child.layoutAlign) {
                        "STRETCH" -> fillMaxHeight()
                        "MIN" -> gravity(ModifierChain.AlignmentOption.Start) // Deprecated in figma but still used in designs for now
                        "MAX" -> gravity(ModifierChain.AlignmentOption.End) // Deprecated in figma but still used in designs for now
                        "CENTER" -> gravity(ModifierChain.AlignmentOption.CenterVertically) // Deprecated in figma but still used in designs for now
                        "INHERIT" -> {}
                        else -> throw Exception("unrecognized LayoutAlign ${child.layoutAlign}")
                    }
                }

            }
        }
        }
        ${if(node.horizontalPadding?.equals(0.0) == false) "Spacer(modifier = Modifier.width(${node.horizontalPadding?.roundedDp()}))" else ""}
        }
            """.trimIndent()
        else -> throw Exception("${node.layoutMode}? must be one of those new features")
    }
}

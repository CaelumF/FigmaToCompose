package app.roomtorent.figmatocompose

import DefaultFrameMixin
import LayoutMixin

fun autoLayoutToComposeRowColumn(node: DefaultFrameMixin, extraModifiers: (Modifier.() -> Unit)?): String {
    return when (node.layoutMode!!) {
        "VERTICAL" -> """
            Column(${Mods(extraModifiers) {
            if (node.counterAxisSizingMode == "FIXED") preferredWidth(
                node.width
            )
        }}, verticalArrangement = ${"vSpacingArrangement".args("${node.itemSpacing}.dp.toIntInPx()")}) {
            ${node.children?.joinToString("\n") { child ->
            makeCompose(child) {
                if (child is LayoutMixin) {
                    preferredSize(child.width, child.height)
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
            addStyleMods(node)
        }}, horizontalArrangement = ${"hSpacingArrangement".args("${node.itemSpacing}.dp.toIntInPx()")}) {
                    ${node.children?.joinToString("\n") { child ->
            makeCompose(child) {
                if (child is LayoutMixin) {
                    preferredSize(child.width, child.height)
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

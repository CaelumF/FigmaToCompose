@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS", "EXTERNAL_DELEGATION")

import kotlin.js.*

external var figma: PluginAPI

external var __html__: String
//val definedExternally: Nothing = def
//    get() {
//        throw Throwable("")
//    }

external interface PluginAPI {
    var apiVersion: String /* "1.0.0" */
    var command: String
    var viewport: ViewportAPI


    var ui: UIAPI
    var clientStorage: ClientStorageAPI


    var root: DocumentNode
    var currentPage: PageNode



    var mixed: Any
























    var hasMissingFont: Boolean






























































































}

external interface ClientStorageAPI {


}

external interface NotificationHandler {
    var cancel: () -> Unit
}

external interface ShowUIOptions {
    var visible: Boolean?


    var width: Number?


    var height: Number?


}

external interface UIPostMessageOptions {
    var origin: String?


}

external interface OnMessageProperties {
    var origin: String
}

external interface UIAPI {







}

external interface ViewportAPI {
    var center: Vector
    var zoom: Number

    var bounds: Rect
}

external interface Vector {
    var x: Number
    var y: Number
}

external interface Rect {
    var x: Number
    var y: Number
    var width: Number
    var height: Number
}

external interface RGB {
    var r: Number
    var g: Number
    var b: Number
}

external interface RGBA {
    var r: Number
    var g: Number
    var b: Number
    var a: Number
}

external interface FontName {
    var family: String
    var style: String
}

external interface ArcData {
    var startingAngle: Number
    var endingAngle: Number
    var innerRadius: Number
}

external interface ShadowEffect {
    var type: String /* "DROP_SHADOW" | "INNER_SHADOW" */
    var color: RGBA
    var offset: Vector
    var radius: Number
    var visible: Boolean
    var blendMode: String /* "PASS_THROUGH" | "NORMAL" | "DARKEN" | "MULTIPLY" | "LINEAR_BURN" | "COLOR_BURN" | "LIGHTEN" | "SCREEN" | "LINEAR_DODGE" | "COLOR_DODGE" | "OVERLAY" | "SOFT_LIGHT" | "HARD_LIGHT" | "DIFFERENCE" | "EXCLUSION" | "HUE" | "SATURATION" | "COLOR" | "LUMINOSITY" */
}

external interface BlurEffect {
    var type: String /* "LAYER_BLUR" | "BACKGROUND_BLUR" */
    var radius: Number
    var visible: Boolean
}

external interface Constraints {
    var horizontal: String /* "MIN" | "CENTER" | "MAX" | "STRETCH" | "SCALE" */
    var vertical: String /* "MIN" | "CENTER" | "MAX" | "STRETCH" | "SCALE" */
}

external interface ColorStop {
    var position: Number
    var color: RGBA
}

external interface ImageFilters {
    var exposure: Number?


    var contrast: Number?


    var saturation: Number?


    var temperature: Number?


    var tint: Number?


    var highlights: Number?


    var shadows: Number?


}

external interface SolidPaint {
    var type: String /* "SOLID" */
    var color: RGB
    var visible: Boolean?


    var opacity: Number?


    var blendMode: String /* "PASS_THROUGH" | "NORMAL" | "DARKEN" | "MULTIPLY" | "LINEAR_BURN" | "COLOR_BURN" | "LIGHTEN" | "SCREEN" | "LINEAR_DODGE" | "COLOR_DODGE" | "OVERLAY" | "SOFT_LIGHT" | "HARD_LIGHT" | "DIFFERENCE" | "EXCLUSION" | "HUE" | "SATURATION" | "COLOR" | "LUMINOSITY" */
}

external interface GradientPaint {
    var type: String /* "GRADIENT_LINEAR" | "GRADIENT_RADIAL" | "GRADIENT_ANGULAR" | "GRADIENT_DIAMOND" */
    var gradientTransform: dynamic /* JsTuple<dynamic, dynamic> */


    var gradientStops: Array<ColorStop>
    var visible: Boolean?


    var opacity: Number?


    var blendMode: String /* "PASS_THROUGH" | "NORMAL" | "DARKEN" | "MULTIPLY" | "LINEAR_BURN" | "COLOR_BURN" | "LIGHTEN" | "SCREEN" | "LINEAR_DODGE" | "COLOR_DODGE" | "OVERLAY" | "SOFT_LIGHT" | "HARD_LIGHT" | "DIFFERENCE" | "EXCLUSION" | "HUE" | "SATURATION" | "COLOR" | "LUMINOSITY" */
}

external interface ImagePaint {
    var type: String /* "IMAGE" */
    var scaleMode: String /* "FILL" | "FIT" | "CROP" | "TILE" */
    var imageHash: String?


    var imageTransform: dynamic /* JsTuple<dynamic, dynamic> */


    var scalingFactor: Number?


    var filters: ImageFilters?


    var visible: Boolean?


    var opacity: Number?


    var blendMode: String /* "PASS_THROUGH" | "NORMAL" | "DARKEN" | "MULTIPLY" | "LINEAR_BURN" | "COLOR_BURN" | "LIGHTEN" | "SCREEN" | "LINEAR_DODGE" | "COLOR_DODGE" | "OVERLAY" | "SOFT_LIGHT" | "HARD_LIGHT" | "DIFFERENCE" | "EXCLUSION" | "HUE" | "SATURATION" | "COLOR" | "LUMINOSITY" */
}

external interface Guide {
    var axis: String /* "X" | "Y" */
    var offset: Number
}

external interface RowsColsLayoutGrid {
    var pattern: String /* "ROWS" | "COLUMNS" */
    var alignment: String /* "MIN" | "MAX" | "STRETCH" | "CENTER" */
    var gutterSize: Number
    var count: Number
    var sectionSize: Number?


    var offset: Number?


    var visible: Boolean?


    var color: RGBA?


}

external interface GridLayoutGrid {
    var pattern: String /* "GRID" */
    var sectionSize: Number
    var visible: Boolean?


    var color: RGBA?


}

external interface ExportSettingsConstraints {
    var type: String /* "SCALE" | "WIDTH" | "HEIGHT" */
    var value: Number
}

external interface ExportSettingsImage {
    var format: String /* "JPG" | "PNG" */
    var contentsOnly: Boolean?


    var suffix: String?


    var constraint: ExportSettingsConstraints?


}

external interface ExportSettingsSVG {
    var format: String /* "SVG" */
    var contentsOnly: Boolean?


    var suffix: String?


    var svgOutlineText: Boolean?


    var svgIdAttribute: Boolean?


    var svgSimplifyStroke: Boolean?


}

external interface ExportSettingsPDF {
    var format: String /* "PDF" */
    var contentsOnly: Boolean?


    var suffix: String?


}

external interface VectorVertex {
    var x: Number
    var y: Number
    var strokeCap: String /* "NONE" | "ROUND" | "SQUARE" | "ARROW_LINES" | "ARROW_EQUILATERAL" */
    var strokeJoin: String /* "MITER" | "BEVEL" | "ROUND" */
    var cornerRadius: Number?


    var handleMirroring: String /* "NONE" | "ANGLE" | "ANGLE_AND_LENGTH" */
}

external interface VectorSegment {
    var start: Number
    var end: Number
    var tangentStart: Vector?


    var tangentEnd: Vector?


}

external interface VectorRegion {
    var windingRule: String /* "NONZERO" | "EVENODD" */
    var loops: Array<Array<Number>>
}

external interface VectorNetwork {
    var vertices: Array<VectorVertex>
    var segments: Array<VectorSegment>
    var regions: Array<VectorRegion>?


}

external interface VectorPath {
    var windingRule: String /* "NONZERO" | "EVENODD" | "NONE" */
    var data: String
}

external interface LetterSpacing {
    var value: Number
    var unit: String /* "PIXELS" | "PERCENT" */
}

external interface `T$2` {
    var value: Number
    var unit: String /* "PIXELS" | "PERCENT" */
}

external interface `T$3` {
    var unit: String /* "AUTO" */
}

external interface Font {
    var fontName: FontName
}

external interface Reaction {
    var action: dynamic /* `T$4` | `T$5` | `T$6` */


    var trigger: dynamic /* `T$7` | `T$8` | `T$9` */


}

external interface `T$4` {
    var type: String /* "BACK" | "CLOSE" */
}

external interface `T$5` {
    var type: String /* "URL" */
    var url: String
}

external interface `T$6` {
    var type: String /* "NODE" */
    var destinationId: String?


    var navigation: String /* "NAVIGATE" | "SWAP" | "OVERLAY" */
    var transition: dynamic /* SimpleTransition | DirectionalTransition */


    var preserveScrollPosition: Boolean
    var overlayRelativePosition: Vector?


}

external interface SimpleTransition {
    var type: String /* "DISSOLVE" | "SMART_ANIMATE" */
    var easing: Easing
    var duration: Number
}

external interface DirectionalTransition {
    var type: String /* "MOVE_IN" | "MOVE_OUT" | "PUSH" | "SLIDE_IN" | "SLIDE_OUT" */
    var direction: String /* "LEFT" | "RIGHT" | "TOP" | "BOTTOM" */
    var matchLayers: Boolean
    var easing: Easing
    var duration: Number
}

external interface `T$7` {
    var type: String /* "ON_CLICK" | "ON_HOVER" | "ON_PRESS" | "ON_DRAG" */
}

external interface `T$8` {
    var type: String /* "AFTER_TIMEOUT" */
    var timeout: Number
}

external interface `T$9` {
    var type: String /* "MOUSE_ENTER" | "MOUSE_LEAVE" | "MOUSE_UP" | "MOUSE_DOWN" */
    var delay: Number
}

external interface Easing {
    var type: String /* "EASE_IN" | "EASE_OUT" | "EASE_IN_AND_OUT" | "LINEAR" */
}

external interface `T$10` {
    var type: String /* "NONE" */
}

external interface `T$11` {
    var type: String /* "SOLID_COLOR" */
    var color: RGBA
}

external interface `T$0` {


}

external interface BaseNodeMixin {
    var id: String
    var parent: dynamic /* DocumentNode | PageNode | SliceNode | FrameNode | GroupNode | ComponentNode | InstanceNode | BooleanOperationNode | VectorNode | StarNode | LineNode | EllipseNode | PolygonNode | RectangleNode | TextNode */


    var name: String
    var removed: Boolean







}

external interface SceneNodeMixin {
    var visible: Boolean
    var locked: Boolean
}

external interface ChildrenMixin {
    var children: Array<dynamic /* SliceNode | FrameNode | GroupNode | ComponentNode | InstanceNode | BooleanOperationNode | VectorNode | StarNode | LineNode | EllipseNode | PolygonNode | RectangleNode | TextNode */>






























}

external interface ConstraintMixin {
    var constraints: Constraints
}

external interface LayoutMixin {
    var absoluteTransform: dynamic /* JsTuple<dynamic, dynamic> */


    var relativeTransform: dynamic /* JsTuple<dynamic, dynamic> */


    var x: Number
    var y: Number
    var rotation: Number
    var width: Number
    var height: Number
    var constrainProportions: Boolean
    var layoutAlign: String /* "MIN" | "CENTER" | "MAX" | "STRETCH" */


}

external interface BlendMixin {
    var opacity: Number
    var blendMode: String /* "PASS_THROUGH" | "NORMAL" | "DARKEN" | "MULTIPLY" | "LINEAR_BURN" | "COLOR_BURN" | "LIGHTEN" | "SCREEN" | "LINEAR_DODGE" | "COLOR_DODGE" | "OVERLAY" | "SOFT_LIGHT" | "HARD_LIGHT" | "DIFFERENCE" | "EXCLUSION" | "HUE" | "SATURATION" | "COLOR" | "LUMINOSITY" */
    var isMask: Boolean
    var effects: Array<dynamic /* ShadowEffect | BlurEffect */>
    var effectStyleId: String
}

external interface ContainerMixin {
    var expanded: Boolean
    var backgrounds: Array<dynamic /* SolidPaint | GradientPaint | ImagePaint */>
    var backgroundStyleId: String
}

external interface GeometryMixin {
    var fills: dynamic /* ReadonlyArray<dynamic /* SolidPaint | GradientPaint | ImagePaint */> | Any */


    var strokes: Array<dynamic /* SolidPaint | GradientPaint | ImagePaint */>
    var strokeWeight: Number
    var strokeMiterLimit: Number
    var strokeAlign: String /* "CENTER" | "INSIDE" | "OUTSIDE" */
    var strokeCap: dynamic /* "NONE" | "ROUND" | "SQUARE" | "ARROW_LINES" | "ARROW_EQUILATERAL" | Any */


    var strokeJoin: dynamic /* "MITER" | "BEVEL" | "ROUND" | Any */


    var dashPattern: Array<Number>
    var fillStyleId: dynamic /* String | Any */


    var strokeStyleId: String

}

external interface CornerMixin {
    var cornerRadius: dynamic /* Number | Any */


    var cornerSmoothing: Number
}

external interface RectangleCornerMixin {
    var topLeftRadius: Number
    var topRightRadius: Number
    var bottomLeftRadius: Number
    var bottomRightRadius: Number
}

external interface ExportMixin {
    var exportSettings: Array<dynamic /* ExportSettingsImage | ExportSettingsSVG | ExportSettingsPDF */>




}

external interface ReactionMixin {
    var reactions: Array<Reaction>
}

external interface DefaultShapeMixin : BaseNodeMixin, SceneNodeMixin, ReactionMixin, BlendMixin, GeometryMixin, LayoutMixin, ExportMixin

external interface DefaultFrameMixin : BaseNodeMixin, SceneNodeMixin, ReactionMixin, ChildrenMixin, ContainerMixin, GeometryMixin, CornerMixin, RectangleCornerMixin, BlendMixin, ConstraintMixin, LayoutMixin, ExportMixin {
    var layoutMode: String /* "NONE" | "HORIZONTAL" | "VERTICAL" */
    var counterAxisSizingMode: String /* "FIXED" | "AUTO" */
    var horizontalPadding: Number
    var verticalPadding: Number
    var itemSpacing: Number
    var layoutGrids: Array<dynamic /* RowsColsLayoutGrid | GridLayoutGrid */>
    var gridStyleId: String
    var clipsContent: Boolean
    var guides: Array<Guide>
    var overflowDirection: String /* "NONE" | "HORIZONTAL" | "VERTICAL" | "BOTH" */
    var numberOfFixedChildren: Number
    var overlayPositionType: String /* "CENTER" | "TOP_LEFT" | "TOP_CENTER" | "TOP_RIGHT" | "BOTTOM_LEFT" | "BOTTOM_CENTER" | "BOTTOM_RIGHT" | "MANUAL" */
    var overlayBackground: dynamic /* `T$10` | `T$11` */


    var overlayBackgroundInteraction: String /* "NONE" | "CLOSE_ON_CLICK_OUTSIDE" */
}

external interface DocumentNode : BaseNodeMixin {
    var type: String /* "DOCUMENT" */
    var children: Array<PageNode>






}

external interface `T$1` {
    var node: TextNode
    var start: Number
    var end: Number
}

external interface PageNode : BaseNodeMixin, ChildrenMixin, ExportMixin {
    var type: String /* "PAGE" */

    var guides: Array<Guide>
    var selection: Array<dynamic /* SliceNode | FrameNode | GroupNode | ComponentNode | InstanceNode | BooleanOperationNode | VectorNode | StarNode | LineNode | EllipseNode | PolygonNode | RectangleNode | TextNode */>
    var selectedTextRange: dynamic /* `T$1` | Nothing? */


    var backgrounds: Array<dynamic /* SolidPaint | GradientPaint | ImagePaint */>
    var prototypeStartNode: dynamic /* FrameNode | GroupNode | ComponentNode | InstanceNode | Nothing? */


}

external interface FrameNode : DefaultFrameMixin {
    var type: String /* "FRAME" */

}

external interface GroupNode : BaseNodeMixin, SceneNodeMixin, ReactionMixin, ChildrenMixin, ContainerMixin, BlendMixin, LayoutMixin, ExportMixin {
    var type: String /* "GROUP" */

}

external interface SliceNode : BaseNodeMixin, SceneNodeMixin, LayoutMixin, ExportMixin {
    var type: String /* "SLICE" */

}

external interface RectangleNode : DefaultShapeMixin, ConstraintMixin, CornerMixin, RectangleCornerMixin {
    var type: String /* "RECTANGLE" */

}

external interface LineNode : DefaultShapeMixin, ConstraintMixin {
    var type: String /* "LINE" */

}

external interface EllipseNode : DefaultShapeMixin, ConstraintMixin, CornerMixin {
    var type: String /* "ELLIPSE" */

    var arcData: ArcData
}

external interface PolygonNode : DefaultShapeMixin, ConstraintMixin, CornerMixin {
    var type: String /* "POLYGON" */

    var pointCount: Number
}

external interface StarNode : DefaultShapeMixin, ConstraintMixin, CornerMixin {
    var type: String /* "STAR" */

    var pointCount: Number
    var innerRadius: Number
}

external interface VectorNode : DefaultShapeMixin, ConstraintMixin, CornerMixin {
    var type: String /* "VECTOR" */

    var vectorNetwork: VectorNetwork
    var vectorPaths: VectorPaths
    var handleMirroring: dynamic /* "NONE" | "ANGLE" | "ANGLE_AND_LENGTH" | Any */


}

external interface TextNode : DefaultShapeMixin, ConstraintMixin {
    var type: String /* "TEXT" */

    var hasMissingFont: Boolean
    var textAlignHorizontal: String /* "LEFT" | "CENTER" | "RIGHT" | "JUSTIFIED" */
    var textAlignVertical: String /* "TOP" | "CENTER" | "BOTTOM" */
    var textAutoResize: String /* "NONE" | "WIDTH_AND_HEIGHT" | "HEIGHT" */
    var paragraphIndent: Number
    var paragraphSpacing: Number
    var autoRename: Boolean
    var textStyleId: dynamic /* String | Any */


    var fontSize: dynamic /* Number | Any */


    var fontName: dynamic /* FontName | Any */


    var textCase: dynamic /* "ORIGINAL" | "UPPER" | "LOWER" | "TITLE" | Any */


    var textDecoration: dynamic /* "NONE" | "UNDERLINE" | "STRIKETHROUGH" | Any */


    var letterSpacing: dynamic /* LetterSpacing | Any */


    var lineHeight: dynamic /* `T$2` | `T$3` | Any */


    var characters: String






















}

external interface ComponentNode : DefaultFrameMixin {
    var type: String /* "COMPONENT" */


    var description: String
    var remote: Boolean
    var key: String
}

external interface InstanceNode : DefaultFrameMixin {
    var type: String /* "INSTANCE" */

    var masterComponent: ComponentNode
    var scaleFactor: Number
}

external interface BooleanOperationNode : DefaultShapeMixin, ChildrenMixin, CornerMixin {
    var type: String /* "BOOLEAN_OPERATION" */

    var booleanOperation: String /* "UNION" | "INTERSECT" | "SUBTRACT" | "EXCLUDE" */
    var expanded: Boolean
}

external interface BaseStyle {
    var id: String
    var type: String /* "PAINT" | "TEXT" | "EFFECT" | "GRID" */
    var name: String
    var description: String
    var remote: Boolean
    var key: String

}

external interface PaintStyle : BaseStyle {
    var type: String /* "PAINT" */
    var paints: Array<dynamic /* SolidPaint | GradientPaint | ImagePaint */>
}

external interface TextStyle : BaseStyle {
    var type: String /* "TEXT" */
    var fontSize: Number
    var textDecoration: String /* "NONE" | "UNDERLINE" | "STRIKETHROUGH" */
    var fontName: FontName
    var letterSpacing: LetterSpacing
    var lineHeight: dynamic /* `T$2` | `T$3` */


    var paragraphIndent: Number
    var paragraphSpacing: Number
    var textCase: String /* "ORIGINAL" | "UPPER" | "LOWER" | "TITLE" */
}

external interface EffectStyle : BaseStyle {
    override var type: String /* "EFFECT" */
    var effects: Array<dynamic /* ShadowEffect | BlurEffect */>
}

external interface GridStyle : BaseStyle {
    override var type: String /* "GRID" */
    var layoutGrids: Array<dynamic /* RowsColsLayoutGrid | GridLayoutGrid */>
}

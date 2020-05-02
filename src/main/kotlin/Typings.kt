//@file:Suppress(
//    "INTERFACE_WITH_SUPERCLASS",
//    "OVERRIDING_FINAL_MEMBER",
//    "RETURN_TYPE_MISMATCH_ON_OVERRIDE",
//    "CONFLICTING_OVERLOADS",
//    "EXTERNAL_DELEGATION"
//)

import com.beust.klaxon.TypeAdapter
import com.beust.klaxon.TypeFor
import java.io.Serializable
import kotlin.js.*
import kotlin.reflect.KClass

//val figma: PluginAPI? = null,

//val __html__: String? = null,
//val definedExternally: Nothing = def
//    get() {
//        throw Throwable("")
//    }

open class PluginAPI(
    val apiVersion: String /* "1.0.0" */,
    val command: String? = null,
    val viewport: ViewportAPI? = null,


    val ui: UIAPI? = null,
    val clientStorage: ClientStorageAPI? = null,


    val root: DocumentNode? = null,
    val currentPage: PageNode? = null,


//    val mixed: Any? = null,


    val hasMissingFont: Boolean? = null,


    ) : Serializable

//@Serializable
open class ClientStorageAPI(


) : Serializable

//@Serializable
open class NotificationHandler(
    val cancel: () -> Unit,

    ) : Serializable

//@Serializable
open class ShowUIOptions(
    val visible: Boolean? = null,


    val width: Double? = null,


    val height: Double? = null,


    )

//@Serializable
open class UIPostMessageOptions(
    val origin: String? = null,


    )

//@Serializable
open class OnMessageProperties(
    val origin: String? = null,

    ) : Serializable

//@Serializable
open class UIAPI(


) : Serializable

//@Serializable
open class ViewportAPI(
    val center: Vector? = null,
    val zoom: Double? = null,

    val bounds: Rect? = null,

    ) : Serializable

//val d: Array<Array<>>
//external val d: Triple<Triple<Double, Double, Double>,
//       Triple<Double, Double, Double>,
//       Triple<Double, Double, Double> >
//println(d[0][2])
//@Serializable
open class Vector(
    val x: Double,
    val y: Double,

    ) : Serializable

//@Serializable
open class NullableRect(
    val x: Double?,
    val y: Double?,
    val width: Double?,
    val height: Double?,
) : Serializable

//@Serializable
open class Rect(
    // Defaults will be used in some Groups, where the 0.0 is important to allow relative positioning calculations not to be affected
    var x: Double = 0.0,
    var y: Double = 0.0,
    var width: Double = 0.0,
    var height: Double = 0.0,

    ) : Serializable {
    constructor (x: Double?, y: Double?, width: Double?, height: Double?) : this(
        x ?: 0.0,
        y ?: 0.0,
        width ?: 0.0,
        height ?: 0.0
    )

}

//@Serializable
open class RGB(
    val r: Double = 1.0,
    val g: Double = 1.0,
    val b: Double = 1.0,

    ) : Serializable

//@Serializable
open class RGBA(
    val r: Double = 1.0,
    val g: Double = 1.0,
    val b: Double = 1.0,
    val a: Double = 1.0,

    ) : Serializable

//@Serializable
open class FontName(
    val family: String? = null,
    val style: String? = null,

    ) : Serializable

//@Serializable
open class ArcData(
    val startingAngle: Double? = null,
    val endingAngle: Double? = null,
    val innerRadius: Double? = null,

    ) : Serializable

//@Serializable
open class ShadowEffect(
    val type: String /* "DROP_SHADOW" | "INNER_SHADOW" */,
    val color: RGBA? = null,
    val offset: Vector? = null,
    val radius: Double? = null,
    val visible: Boolean? = null,
    val blendMode: String /* "PASS_THROUGH" | "NORMAL" | "DARKEN" | "MULTIPLY" | "LINEAR_BURN" | "COLOR_BURN" | "LIGHTEN" | "SCREEN" | "LINEAR_DODGE" | "COLOR_DODGE" | "OVERLAY" | "SOFT_LIGHT" | "HARD_LIGHT" | "DIFFERENCE" | "EXCLUSION" | "HUE" | "SATURATION" | "COLOR" | "LUMINOSITY" */,

    ) : Serializable

//@Serializable
open class BlurEffect(
    val type: String /* "LAYER_BLUR" | "BACKGROUND_BLUR" */,
    val radius: Double? = null,
    val visible: Boolean? = null,

    ) : Serializable

//@Serializable
open class Constraints(
    val horizontal: String /* "MIN" | "CENTER" | "MAX" | "STRETCH" | "SCALE" */,
    val vertical: String /* "MIN" | "CENTER" | "MAX" | "STRETCH" | "SCALE" */,

    ) : Serializable

//@Serializable
open class ColorStop(
    val position: Double? = null,
    val color: RGBA? = null,

    ) : Serializable

//@Serializable
open class ImageFilters(
    val exposure: Double? = null,


    val contrast: Double? = null,


    val saturation: Double? = null,


    val temperature: Double? = null,


    val tint: Double? = null,


    val highlights: Double? = null,


    val shadows: Double? = null,


    ) : Serializable

//@Serializable
open class SolidPaint(
    val color: RGBA,
    val visible: Boolean? = null,


    val opacity: Double = 1.0,


    val blendMode: String /* "PASS_THROUGH" | "NORMAL" | "DARKEN" | "MULTIPLY" | "LINEAR_BURN" | "COLOR_BURN" | "LIGHTEN" | "SCREEN" | "LINEAR_DODGE" | "COLOR_DODGE" | "OVERLAY" | "SOFT_LIGHT" | "HARD_LIGHT" | "DIFFERENCE" | "EXCLUSION" | "HUE" | "SATURATION" | "COLOR" | "LUMINOSITY" */,
    override val type: String,

    ) : Serializable, Paint

//@Serializable
open class GradientPaint(
    override val type: String /* "GRADIENT_LINEAR" | "GRADIENT_RADIAL" | "GRADIENT_ANGULAR" | "GRADIENT_DIAMOND" */,
//    val gradientTransform: Any? = null /* JsTuple<Any, Any> */,
    val gradientStops: Array<ColorStop>? = null,
    val visible: Boolean? = null,
    val opacity: Double = 1.0,
    val blendMode: String? = null /* "PASS_THROUGH" | "NORMAL" | "DARKEN" | "MULTIPLY" | "LINEAR_BURN" | "COLOR_BURN" | "LIGHTEN" | "SCREEN" | "LINEAR_DODGE" | "COLOR_DODGE" | "OVERLAY" | "SOFT_LIGHT" | "HARD_LIGHT" | "DIFFERENCE" | "EXCLUSION" | "HUE" | "SATURATION" | "COLOR" | "LUMINOSITY" */,

    ) : Serializable, Paint

//@Serializable
open class ImagePaint(
    val scaleMode: String? = null /* "FILL" | "FIT" | "CROP" | "TILE" */,
    val imageHash: String? = null,


//    val imageTransform: Any? = null /* JsTuple<Any, Any> */,


    val scalingFactor: Double? = null,


    val filters: ImageFilters? = null,


    val visible: Boolean? = null,


    val opacity: Double = 1.0,


    val blendMode: String? = null /* "PASS_THROUGH" | "NORMAL" | "DARKEN" | "MULTIPLY" | "LINEAR_BURN" | "COLOR_BURN" | "LIGHTEN" | "SCREEN" | "LINEAR_DODGE" | "COLOR_DODGE" | "OVERLAY" | "SOFT_LIGHT" | "HARD_LIGHT" | "DIFFERENCE" | "EXCLUSION" | "HUE" | "SATURATION" | "COLOR" | "LUMINOSITY" */,
    override val type: String,

    ) : Serializable, Paint

//@Serializable
open class Guide(
    val axis: String /* "X" | "Y" */,
    val offset: Double? = null,

    ) : Serializable

//@Serializable
open class RowsColsLayoutGrid(
    val pattern: String /* "ROWS" | "COLUMNS" */,
    val alignment: String /* "MIN" | "MAX" | "STRETCH" | "CENTER" */,
    val gutterSize: Double? = null,
    val count: Double? = null,
    val sectionSize: Double? = null,


    val offset: Double? = null,


    val visible: Boolean? = null,


    val color: RGBA? = null,


    ) : Serializable

//@Serializable
open class GridLayoutGrid(
    val pattern: String /* "GRID" */,
    val sectionSize: Double? = null,
    val visible: Boolean? = null,


    val color: RGBA? = null,


    ) : Serializable

//@Serializable
open class ExportSettingsConstraints(
    val type: String /* "SCALE" | "WIDTH" | "HEIGHT" */,
    val value: Double? = null,

    ) : Serializable

//@Serializable
open class ExportSettingsImage(
    val format: String /* "JPG" | "PNG" */,
    val contentsOnly: Boolean? = null,


    val suffix: String? = null,


    val constraint: ExportSettingsConstraints? = null,


    ) : Serializable

//@Serializable
open class ExportSettingsSVG(
    val format: String /* "SVG" */,
    val contentsOnly: Boolean? = null,


    val suffix: String? = null,


    val svgOutlineText: Boolean? = null,


    val svgIdAttribute: Boolean? = null,


    val svgSimplifyStroke: Boolean? = null,


    ) : Serializable

//@Serializable
open class ExportSettingsPDF(
    val format: String /* "PDF" */,
    val contentsOnly: Boolean? = null,


    val suffix: String? = null,


    ) : Serializable

//@Serializable
open class VectorVertex(
    val x: Double? = null,
    val y: Double? = null,
    val strokeCap: String /* "NONE" | "ROUND" | "SQUARE" | "ARROW_LINES" | "ARROW_EQUILATERAL" */,
    val strokeJoin: String /* "MITER" | "BEVEL" | "ROUND" */,
    val cornerRadius: Double? = null,


    val handleMirroring: String /* "NONE" | "ANGLE" | "ANGLE_AND_LENGTH" */,

    ) : Serializable

//@Serializable
open class VectorSegment(
    val start: Double? = null,
    val end: Double? = null,
    val tangentStart: Vector? = null,


    val tangentEnd: Vector? = null,


    ) : Serializable

//@Serializable
open class VectorRegion(
    val windingRule: String /* "NONZERO" | "EVENODD" */,
    val loops: List<List<Integer>>,

    ) : Serializable

//@Serializable
open class VectorNetwork(
    val vertices: Array<VectorVertex>,
    val segments: Array<VectorSegment>,
    val regions: Array<VectorRegion>? = null,


    ) : Serializable

//@Serializable
open class VectorPath(
    val windingRule: String /* "NONZERO" | "EVENODD" | "NONE" */,
    val data: String? = null,

    ) : Serializable

//@Serializable
open class LetterSpacing(
    val value: Double? = null,
    val unit: String /* "PIXELS" | "PERCENT" */,

    ) : Serializable

//@Serializable
open class `T$2`(
    val value: Double? = null,
    val unit: String /* "PIXELS" | "PERCENT" */,

    ) : Serializable

//@Serializable
open class `T$3`(
    val unit: String /* "AUTO" */,

    ) : Serializable

//@Serializable
open class Font(
    val fontName: FontName? = null,

    ) : Serializable

//@Serializable
open class Reaction(
////    val action: Any /* `T$4` | `T$5` | `T$6` */,


////    val trigger: Any /* `T$7` | `T$8` | `T$9` */,


) : Serializable

//@Serializable
open class `T$4`(
    val type: String /* "BACK" | "CLOSE" */,

    ) : Serializable

//@Serializable
open class `T$5`(
    val type: String /* "URL" */,
    val url: String? = null,

    ) : Serializable

//@Serializable
open class `T$6`(
    val type: String /* "NODE" */,
    val destinationId: String? = null,


    val navigation: String /* "NAVIGATE" | "SWAP" | "OVERLAY" */,
////    val transition: Any /* SimpleTransition | DirectionalTransition */,


    val preserveScrollPosition: Boolean? = null,
    val overlayRelativePosition: Vector? = null,


    ) : Serializable

//@Serializable
open class SimpleTransition(
    val type: String /* "DISSOLVE" | "SMART_ANIMATE" */,
    val easing: Easing? = null,
    val duration: Double? = null,

    ) : Serializable

//@Serializable
open class DirectionalTransition(
    val type: String /* "MOVE_IN" | "MOVE_OUT" | "PUSH" | "SLIDE_IN" | "SLIDE_OUT" */,
    val direction: String /* "LEFT" | "RIGHT" | "TOP" | "BOTTOM" */,
    val matchLayers: Boolean? = null,
    val easing: Easing? = null,
    val duration: Double? = null,

    ) : Serializable

//@Serializable
open class `T$7`(
    val type: String /* "ON_CLICK" | "ON_HOVER" | "ON_PRESS" | "ON_DRAG" */,

    ) : Serializable

//@Serializable
open class `T$8`(
    val type: String /* "AFTER_TIMEOUT" */,
    val timeout: Double? = null,

    ) : Serializable

//@Serializable
open class `T$9`(
    val type: String /* "MOUSE_ENTER" | "MOUSE_LEAVE" | "MOUSE_UP" | "MOUSE_DOWN" */,
    val delay: Double? = null,

    ) : Serializable

//@Serializable
open class Easing(
    val type: String /* "EASE_IN" | "EASE_OUT" | "EASE_IN_AND_OUT" | "LINEAR" */,

    ) : Serializable

//@Serializable
open class `T$10`(
    val type: String /* "NONE" */,

    ) : Serializable

//@Serializable
open class `T$11`(
    val type: String /* "SOLID_COLOR" */,
    val color: RGBA? = null,

    ) : Serializable

//@Serializable
open class `T$0`(


) : Serializable

//@Serializable
class BaseNodeMixinImpl(
//    Important that these are val
    override val id: String? = null,
//    override val parent: BaseNodeMixin? = null,
    override val name: String? = null,
    override val removed: Boolean? = false,
    override val type: String = "UNSET"
) : Serializable, BaseNodeMixin {

}

interface knownNodeType {}

@TypeFor(field = "type", adapter = NodeTypeAdapter::class)
interface BaseNodeMixin {
    val type: String
    val id: String?

    //    val parent: Any? /* DocumentNode | PageNode | SliceNode | FrameNode | GroupNode | ComponentNode | InstanceNode | BooleanOperationNode | VectorNode | StarNode | LineNode | EllipseNode | PolygonNode | RectangleNode | TextNode */
    val name: String?
    val removed: Boolean?
}

interface SceneNodeMixin {
    val visible: Boolean?
    val locked: Boolean?

}

//@Serializable
class GroupNodeImpl(
    override val type: String = "GROUP",
    override val id: String? = null,
////    override val parent: Any? = null,
    override val name: String? = null,
    override val removed: Boolean? = null,
    override val visible: Boolean? = null,
    override val locked: Boolean? = null,
    override val children: Array<BaseNodeMixin>? = null,
////    override val absoluteTransform: Any? = null,
//    override val relativeTransform: Triple<Triple<Double, Double, Double>,
//       Triple<Double, Double, Double>,
//       Triple<Double, Double, Double> >? = null,
    val absoluteBoundingBox: Rect? = null,
    override val constrainProportions: Boolean? = null,
    override val layoutAlign: String? = null,
    override val opacity: Double = 1.0,
    override val blendMode: String? = null,
    override val isMask: Boolean? = null,
//    override val effects: Array<Any>? = null,
    override val effectStyleId: String? = null,
    override val expanded: Boolean? = null,
//    override val backgrounds: Array<Any>? = null,
    override val backgroundStyleId: String? = null,
//    override val exportSettings: Array<Any>? = null,
    override val reactions: Array<Reaction>? = null,
    x: Double? = null,
    y: Double? = null,
    rotation: Double? = null,
    width: Double? = null,
    height: Double? = null,
    val realx: Double? = x,
    val realy: Double? = y,
    val realrotation: Double? = rotation,
    val realwidth: Double? = width,
    val realheight: Double? = height,
) : Serializable, GroupNode {

    override val x: Double
        get() = realx ?: absoluteBoundingBox?.x ?: throw kotlin.Exception("Can't derive from anything")
    override val y: Double
        get() = realy ?: absoluteBoundingBox?.y ?: throw kotlin.Exception("Can't derive from anything")
    override val rotation: Double = 0.0
    override val width: Double
        get() = realwidth ?: absoluteBoundingBox?.width ?: throw kotlin.Exception("Can't derive from anything")
    override val height: Double
        get() = realheight ?: absoluteBoundingBox?.height ?: throw kotlin.Exception("Can't derive from anything")
}


interface GroupNode :
    BaseNodeMixin, SceneNodeMixin, ReactionMixin,
    ChildrenMixin, ContainerMixin, BlendMixin,
    LayoutMixin, ExportMixin {

}

interface ChildrenMixin {
    val children: Array<BaseNodeMixin>?
}

interface ConstraintMixin {
    val constraints: Constraints?
}

interface NullableLayoutMixin {
    //    val absoluteTransform: Any? /* JsTuple<Any, Any> */
//    val relativeTransform: Triple<Triple<Double, Double, Double>,
//       Triple<Double, Double, Double>,
//       Triple<Double, Double, Double> >? /* JsTuple<Any, Any> */
    val x: Double?
    val y: Double?
    val rotation: Double?
    val width: Double?
    val height: Double?
    val constrainProportions: Boolean?
    val layoutAlign: String? /* "MIN" | "CENTER" | "MAX" | "STRETCH" */
}

interface LayoutMixin {
    //    val absoluteTransform: Any? /* JsTuple<Any, Any> */
//    val relativeTransform: Triple<Triple<Double, Double, Double>,
//       Triple<Double, Double, Double>,
//       Triple<Double, Double, Double> >? /* JsTuple<Any, Any> */
    val x: Double
    val y: Double
    val rotation: Double
    val width: Double
    val height: Double
    val constrainProportions: Boolean?
    val layoutAlign: String? /* "MIN" | "CENTER" | "MAX" | "STRETCH" */
}

interface BlendMixin {
    val opacity: Double
    val blendMode: String /* "PASS_THROUGH" | "NORMAL" | "DARKEN" | "MULTIPLY" | "LINEAR_BURN" | "COLOR_BURN" | "LIGHTEN" | "SCREEN" | "LINEAR_DODGE" | "COLOR_DODGE" | "OVERLAY" | "SOFT_LIGHT" | "HARD_LIGHT" | "DIFFERENCE" | "EXCLUSION" | "HUE" | "SATURATION" | "COLOR" | "LUMINOSITY" */?
    val isMask: Boolean?

    //    val effects: Array<Any /* ShadowEffect | BlurEffect */>?
    val effectStyleId: String?

}

interface ContainerMixin {
    val expanded: Boolean?

    //    val backgrounds: Array<Any /* SolidPaint | GradientPaint | ImagePaint */>?
    val backgroundStyleId: String?
}

@TypeFor(field = "type", adapter = FillTypeAdapter::class)
interface Paint {
    val type: String
}

////@Serializable
//class SolidPaint () {
//
//}
////@Serializable
//class GradientPaint() {
//
//}
////@Serializable
//class ImagePaint() {
//
//}
interface GeometryMixin {
    val fills: Array<Paint>? /* ReadonlyArray<Any /* SolidPaint | GradientPaint | ImagePaint */> | Any */

    //    val strokes: Array<Any /* SolidPaint | GradientPaint | ImagePaint */>?
    val strokeWeight: Double?
    val strokeMiterLimit: Double?
    val strokeAlign: String? /* "CENTER" | "INSIDE" | "OUTSIDE" */

    //    val strokeCap: Any? /* "NONE" | "ROUND" | "SQUARE" | "ARROW_LINES" | "ARROW_EQUILATERAL" | Any */
//    val strokeJoin: Any? /* "MITER" | "BEVEL" | "ROUND" | Any */
    val dashPattern: Array<Double>?

    //    val fillStyleId: Any? /* String | Any */
    val strokeStyleId: String?
}

interface CornerMixin {
    val cornerRadius: Double?
    val cornerSmoothing: Double?
}

interface RectangleCornerMixin {
    val topLeftRadius: Double?
    val topRightRadius: Double?
    val bottomLeftRadius: Double?
    val bottomRightRadius: Double?
}

interface ExportMixin {
//    val exportSettings: Array<Any /* ExportSettingsImage | ExportSettingsSVG | ExportSettingsPDF */>?
}

interface ReactionMixin {
    val reactions: Array<Reaction>?
}

interface DefaultShapeMixin : Serializable, BaseNodeMixin, SceneNodeMixin, ReactionMixin, BlendMixin, GeometryMixin,
    LayoutMixin,
    ExportMixin

interface DefaultFrameMixin : Serializable, BaseNodeMixin, SceneNodeMixin, ReactionMixin, ChildrenMixin, ContainerMixin,
    GeometryMixin, CornerMixin, RectangleCornerMixin, BlendMixin, ConstraintMixin, LayoutMixin, ExportMixin {
    val layoutMode: String? /* "NONE" | "HORIZONTAL" | "VERTICAL" */
    val counterAxisSizingMode: String /* "FIXED" | "AUTO" */?
    val horizontalPadding: Double?
    val verticalPadding: Double?
    val itemSpacing: Double?

    //    val layoutGrids: Array<Any /* RowsColsLayoutGrid | GridLayoutGrid */>?
    val gridStyleId: String?
    val clipsContent: Boolean?
    val guides: Array<Guide>?
    val overflowDirection: String /* "NONE" | "HORIZONTAL" | "VERTICAL" | "BOTH" */?
    val DoubleOfFixedChildren: Double?
    val overlayPositionType: String /* "CENTER" | "TOP_LEFT" | "TOP_CENTER" | "TOP_RIGHT" | "BOTTOM_LEFT" | "BOTTOM_CENTER" | "BOTTOM_RIGHT" | "MANUAL" */?

    //    val overlayBackground: Any /* `T$10` | `T$11` */?
    val overlayBackgroundInteraction: String /* "NONE" | "CLOSE_ON_CLICK_OUTSIDE" */?
}

//@Serializable
open class FigmaFile(
    val document: DocumentNode? = null,
////        val components: JsonArray<Any>,
    val schemaVersion: Int? = null,
    val styles: HashMap<String, BaseStyleImpl>,
    val name: String,
    val lastModified: String? = null,
    val thumbnailUrl: String? = null,
    val version: String? = null,
    val role: String?
) : Serializable

//@Serializable
open class DocumentNode(
    override val name: String? = null,
    override val id: String? = null,
    val children: Array<Canvas>,
//    override val parent: Any? = null,
    override val removed: Boolean? = false,
    override val type: String = "DOCUMENT",
) : Serializable, BaseNodeMixin

//@Serializable
open class `T$1`(
    val node: TextNode? = null,
    val start: Double? = null,
    val end: Double? = null,

    )

//@Serializable
open class Canvas(
    override val id: String? = "0.0",
    override val name: String? = null,
//    override val parent: BaseNodeMixin? = null,
    override val type: String = "CANVAS",
    override val removed: Boolean? = false,
    override val children: Array<BaseNodeMixin>?
) : Serializable, BaseNodeMixin, ChildrenMixin {
}

//@Serializable
open class PageNode(
    override val type: String = "PAGE" /* "PAGE" */,

    val guides: Array<Guide>,
    val selection: Array<SceneNodeMixin /* SliceNode | FrameNode | GroupNode | ComponentNode | InstanceNode | BooleanOperationNode | VectorNode | StarNode | LineNode | EllipseNode | PolygonNode | RectangleNode | TextNode */>,
//    val selectedTextRange: Any? /* `T$1` | Nothing? */,


//    val backgrounds: Array<Any /* SolidPaint | GradientPaint | ImagePaint */>,
//    val prototypeStartNode: Any /* FrameNode | GroupNode | ComponentNode | InstanceNode | Nothing? */,
    override val id: String? = null,
//    override val parent: Any? = null,
    override val name: String? = null,
    override val removed: Boolean? = null,
    override val children: Array<BaseNodeMixin>?,
//    override val exportSettings: Array<Any>? = null,
) : Serializable, BaseNodeMixin, ChildrenMixin, ExportMixin

//@Serializable
open class FrameNode(
    override val type: String = "FRAME" /* "FRAME" */,
    override val id: String? = null,
//    override val parent: Any? = null,
    override val name: String? = null,
    override val removed: Boolean? = null,
    override val visible: Boolean? = null,
    override val locked: Boolean? = null,
    override val children: Array<BaseNodeMixin>?,
    override val constraints: Constraints? = null,
//    override val absoluteTransform: Any? = null,
//    override val relativeTransform: Triple<Triple<Double, Double, Double>,
//       Triple<Double, Double, Double>,
//       Triple<Double, Double, Double> >? = null,

    val absoluteBoundingBox: Rect? = null,


    override val constrainProportions: Boolean? = null,
    override val layoutAlign: String? = null,
    override val opacity: Double = 1.0,
    override val blendMode: String? = null,
    override val isMask: Boolean? = null,
//    override val effects: Array<Any>? = null,
    override val effectStyleId: String? = null,
    override val expanded: Boolean? = null,
//    override val backgrounds: Array<Any>? = null,
    override val backgroundStyleId: String? = null,
    override val fills: Array<Paint>? = null,
//    override val strokes: Array<Any>? = null,
    override val strokeWeight: Double? = null,
    override val strokeMiterLimit: Double? = null,
    override val strokeAlign: String? = null,
//    override val strokeCap: Any? = null,
//    override val strokeJoin: Any? = null,
    override val dashPattern: Array<Double>? = null,
//    override val fillStyleId: Any? = null,
    override val strokeStyleId: String? = null,
//    override val cornerRadius: Any? = null,
    override val cornerSmoothing: Double? = null,
    override val topLeftRadius: Double? = null,
    override val topRightRadius: Double? = null,
    override val bottomLeftRadius: Double? = null,
    override val bottomRightRadius: Double? = null,
//    override val exportSettings: Array<Any>? = null,
    override val reactions: Array<Reaction>? = null,
    override val layoutMode: String? = null,
    override val counterAxisSizingMode: String? = null,
    override val horizontalPadding: Double? = null,
    override val verticalPadding: Double? = null,
    override val itemSpacing: Double? = null,
//    override val layoutGrids: Array<Any>? = null,
    override val gridStyleId: String? = null,
    override val clipsContent: Boolean? = null,
    override val guides: Array<Guide>? = null,
    override val overflowDirection: String? = null,
    override val DoubleOfFixedChildren: Double? = null,
    override val overlayPositionType: String? = null,
//    override val overlayBackground: Any? = null,
    override val overlayBackgroundInteraction: String? = null, override val cornerRadius: Double? = 0.0,
    x: Double? = null,
    y: Double? = null,
    rotation: Double? = null,
    width: Double? = null,
    height: Double? = null,
    val realx: Double? = x,
    val realy: Double? = y,
    val realrotation: Double? = rotation,
    val realwidth: Double? = width,
    val realheight: Double? = height,

    ) : Serializable, DefaultFrameMixin {

    override val x: Double
        get() = realx ?: absoluteBoundingBox?.x ?: throw kotlin.Exception("Can't derive from anything")
    override val y: Double
        get() = realy ?: absoluteBoundingBox?.y ?: throw kotlin.Exception("Can't derive from anything")
    override val rotation: Double = 0.0
    override val width: Double
        get() = realwidth ?: absoluteBoundingBox?.width ?: throw kotlin.Exception("Can't derive from anything")
    override val height: Double
        get() = realheight ?: absoluteBoundingBox?.height ?: throw kotlin.Exception("Can't derive from anything")
}
//
////@Serializable
//open class GroupNode : _root_ide_package_.java.io.Serializable, BaseNodeMixin? = null, SceneNodeMixin, ReactionMixin, ChildrenMixin, ContainerMixin, BlendMixin, LayoutMixin, ExportMixin(
//        val type: String /* "GROUP" */,
//
//
//)

//@Serializable
open class SliceNode(
    override val type: String = "SLICE"/* "SLICE" */,
    override val id: String? = null,
//    override val parent: Any? = null,
    override val name: String? = null,
    override val removed: Boolean? = null,
    override val visible: Boolean? = null,
    override val locked: Boolean? = null,
//    override val absoluteTransform: Any? = null,
//  override val relativeTransform: Triple<Triple<Double, Double, Double>,
//       Triple<Double, Double, Double>,
//       Triple<Double, Double, Double> >? = null,

    val absoluteBoundingBox: Rect? = null,

    override val constrainProportions: Boolean? = null,
    override val layoutAlign: String? = null,
    x: Double? = null,
    y: Double? = null,
    rotation: Double? = null,
    width: Double? = null,
    height: Double? = null,
    val realx: Double? = x,
    val realy: Double? = y,
    val realrotation: Double? = rotation,
    val realwidth: Double? = width,
    val realheight: Double? = height,
//    override val exportSettings: Array<Any>? = null,
) : Serializable, BaseNodeMixin, SceneNodeMixin, LayoutMixin, ExportMixin {

    override val x: Double
        get() = realx ?: absoluteBoundingBox?.x ?: throw kotlin.Exception("Can't derive from anything")
    override val y: Double
        get() = realy ?: absoluteBoundingBox?.y ?: throw kotlin.Exception("Can't derive from anything")
    override val rotation: Double = 0.0
    override val width: Double
        get() = realwidth ?: absoluteBoundingBox?.width ?: throw kotlin.Exception("Can't derive from anything")
    override val height: Double
        get() = realheight ?: absoluteBoundingBox?.height ?: throw kotlin.Exception("Can't derive from anything")
}

//@Serializable
open class RectangleNode(
    override val type: String = "RECTANGLE" /* "RECTANGLE" */,
    override val id: String? = null,
//    override val parent: Any? = null,
    override val name: String? = null,
    override val removed: Boolean? = null,
    override val visible: Boolean? = null,
    override val locked: Boolean? = null,
    override val constraints: Constraints? = null,
//    override val absoluteTransform: Any? = null,
//    override val relativeTransform: Triple<Triple<Double, Double, Double>,
//       Triple<Double, Double, Double>,
//       Triple<Double, Double, Double> >? = null,

    val absoluteBoundingBox: Rect? = null,

    override val constrainProportions: Boolean? = null,
    override val layoutAlign: String? = null,
    override val opacity: Double = 0.0,
    override val blendMode: String? = null,
    override val isMask: Boolean? = null,
//    override val effects: Array<Any>? = null,
    override val effectStyleId: String? = null,
    override val fills: Array<Paint>? = null,
//    override val strokes: Array<Any>? = null,
    override val strokeWeight: Double? = null,
    override val strokeMiterLimit: Double? = null,
    override val strokeAlign: String? = null,
//    override val strokeCap: Any? = null,
//    override val strokeJoin: Any? = null,
    override val dashPattern: Array<Double>? = null,
//    override val fillStyleId: Any? = null,
    override val strokeStyleId: String? = null,
//    override val cornerRadius: Any? = null,
    override val cornerSmoothing: Double? = null,
    override val topLeftRadius: Double? = null,
    override val topRightRadius: Double? = null,
    override val bottomLeftRadius: Double? = null,
    override val bottomRightRadius: Double? = null,
//    override val exportSettings: Array<Any>? = null,
    override val reactions: Array<Reaction>? = null, override val cornerRadius: Double? = 0.0,
    x: Double? = null,
    y: Double? = null,
    rotation: Double? = null,
    width: Double? = null,
    height: Double? = null,
    val realx: Double? = x,
    val realy: Double? = y,
    val realrotation: Double? = rotation,
    val realwidth: Double? = width,
    val realheight: Double? = height,
) : Serializable, DefaultShapeMixin, ConstraintMixin, CornerMixin, RectangleCornerMixin {

    override val x: Double
        get() = realx ?: absoluteBoundingBox?.x ?: throw kotlin.Exception("Can't derive from anything")
    override val y: Double
        get() = realy ?: absoluteBoundingBox?.y ?: throw kotlin.Exception("Can't derive from anything")
    override val rotation: Double = 0.0
    override val width: Double
        get() = realwidth ?: absoluteBoundingBox?.width ?: throw kotlin.Exception("Can't derive from anything")
    override val height: Double
        get() = realheight ?: absoluteBoundingBox?.height ?: throw kotlin.Exception("Can't derive from anything")
}

//@Serializable
open class LineNode(
    override val type: String = "LINE" /* "LINE" */,
    override val id: String? = null,
//    override val parent: Any? = null,
    override val name: String? = null,
    override val removed: Boolean? = null,
    override val visible: Boolean? = null,
    override val locked: Boolean? = null,
    override val constraints: Constraints? = null,
//    override val absoluteTransform: Any? = null,
//  override val relativeTransform: Triple<Triple<Double, Double, Double>,
//       Triple<Double, Double, Double>,
//       Triple<Double, Double, Double> >? = null,

    val absoluteBoundingBox: Rect? = null,

    override val constrainProportions: Boolean? = null,
    override val layoutAlign: String? = null,
    override val opacity: Double = 1.0,
    override val blendMode: String? = null,
    override val isMask: Boolean? = null,
//    override val effects: Array<Any>? = null,
    override val effectStyleId: String? = null,
    override val fills: Array<Paint>? = null,
//    override val strokes: Array<Any>? = null,
    override val strokeWeight: Double? = null,
    override val strokeMiterLimit: Double? = null,
    override val strokeAlign: String? = null,
//    override val strokeCap: Any? = null,
//    override val strokeJoin: Any? = null,
    override val dashPattern: Array<Double>? = null,
//    override val fillStyleId: Any? = null,
    override val strokeStyleId: String? = null,
//    override val exportSettings: Array<Any>? = null,
    override val reactions: Array<Reaction>? = null,
    x: Double? = null,
    y: Double? = null,
    rotation: Double? = null,
    width: Double? = null,
    height: Double? = null,
    val realx: Double? = x,
    val realy: Double? = y,
    val realrotation: Double? = rotation,
    val realwidth: Double? = width,
    val realheight: Double? = height,
) : Serializable, DefaultShapeMixin, ConstraintMixin {

    override val x: Double
        get() = realx ?: absoluteBoundingBox?.x ?: throw kotlin.Exception("Can't derive from anything")
    override val y: Double
        get() = realy ?: absoluteBoundingBox?.y ?: throw kotlin.Exception("Can't derive from anything")
    override val rotation: Double = 0.0
    override val width: Double
        get() = realwidth ?: absoluteBoundingBox?.width ?: throw kotlin.Exception("Can't derive from anything")
    override val height: Double
        get() = realheight ?: absoluteBoundingBox?.height ?: throw kotlin.Exception("Can't derive from anything")
}

//@Serializable
open class EllipseNode(
    override val type: String = "ELLIPSE" /* "ELLIPSE" */,

    val arcData: ArcData? = null,
    override val id: String? = null,
//    override val parent: Any? = null,
    override val name: String? = null,
    override val removed: Boolean? = null,
    override val visible: Boolean? = null,
    override val locked: Boolean? = null,
    override val constraints: Constraints? = null,
//    override val absoluteTransform: Any? = null,
//  override val relativeTransform: Triple<Triple<Double, Double, Double>,
//       Triple<Double, Double, Double>,
//       Triple<Double, Double, Double> >? = null,

    val absoluteBoundingBox: Rect? = null,

    override val constrainProportions: Boolean? = null,
    override val layoutAlign: String? = null,
    override val opacity: Double = 0.0,
    override val blendMode: String? = null,
    override val isMask: Boolean? = null,
//    override val effects: Array<Any>? = null,
    override val effectStyleId: String? = null,
    override val fills: Array<Paint>? = null,
//    override val strokes: Array<Any>? = null,
    override val strokeWeight: Double? = null,
    override val strokeMiterLimit: Double? = null,
    override val strokeAlign: String? = null,
//    override val strokeCap: Any? = null,
//    override val strokeJoin: Any? = null,
    override val dashPattern: Array<Double>? = null,
//    override val fillStyleId: Any? = null,
    override val strokeStyleId: String? = null,
//    override val cornerRadius: Any? = null,
    override val cornerSmoothing: Double? = null,
//    override val exportSettings: Array<Any>? = null,
    override val reactions: Array<Reaction>? = null, override val cornerRadius: Double? = 0.0,
    x: Double? = null,
    y: Double? = null,
    rotation: Double? = null,
    width: Double? = null,
    height: Double? = null,
    val realx: Double? = x,
    val realy: Double? = y,
    val realrotation: Double? = rotation,
    val realwidth: Double? = width,
    val realheight: Double? = height,

    ) : Serializable, DefaultShapeMixin, ConstraintMixin, CornerMixin {

    override val x: Double
        get() = realx ?: absoluteBoundingBox?.x ?: throw kotlin.Exception("Can't derive from anything")
    override val y: Double
        get() = realy ?: absoluteBoundingBox?.y ?: throw kotlin.Exception("Can't derive from anything")
    override val rotation: Double = 0.0
    override val width: Double
        get() = realwidth ?: absoluteBoundingBox?.width ?: throw kotlin.Exception("Can't derive from anything")
    override val height: Double
        get() = realheight ?: absoluteBoundingBox?.height ?: throw kotlin.Exception("Can't derive from anything")
}

//@Serializable
open class PolygonNode(
    override val type: String = "POLYGON" /* "POLYGON" */,

    val pointCount: Double? = null,
    override val id: String? = null,
//    override val parent: Any? = null,
    override val name: String? = null,
    override val removed: Boolean? = null,
    override val visible: Boolean? = null,
    override val locked: Boolean? = null,
    override val constraints: Constraints? = null,
//    override val absoluteTransform: Any? = null,
//  override val relativeTransform: Triple<Triple<Double, Double, Double>,
//       Triple<Double, Double, Double>,
//       Triple<Double, Double, Double> >? = null,

    val absoluteBoundingBox: Rect? = null,

    override val constrainProportions: Boolean? = null,
    override val layoutAlign: String? = null,
    override val opacity: Double = 0.0,
    override val blendMode: String? = null,
    override val isMask: Boolean? = null,
//    override val effects: Array<Any>? = null,
    override val effectStyleId: String? = null,
    override val fills: Array<Paint>? = null,
//    override val strokes: Array<Any>? = null,
    override val strokeWeight: Double? = null,
    override val strokeMiterLimit: Double? = null,
    override val strokeAlign: String? = null,
//    override val strokeCap: Any? = null,
//    override val strokeJoin: Any? = null,
    override val dashPattern: Array<Double>? = null,
//    override val fillStyleId: Any? = null,
    override val strokeStyleId: String? = null,
//    override val cornerRadius: Any? = null,
    override val cornerSmoothing: Double? = null,
//    override val exportSettings: Array<Any>? = null,
    override val reactions: Array<Reaction>? = null, override val cornerRadius: Double? = 0.0,
    x: Double? = null,
    y: Double? = null,
    rotation: Double? = null,
    width: Double? = null,
    height: Double? = null,
    val realx: Double? = x,
    val realy: Double? = y,
    val realrotation: Double? = rotation,
    val realwidth: Double? = width,
    val realheight: Double? = height,

    ) : Serializable, DefaultShapeMixin, ConstraintMixin, CornerMixin {

    override val x: Double
        get() = realx ?: absoluteBoundingBox?.x ?: throw kotlin.Exception("Can't derive from anything")
    override val y: Double
        get() = realy ?: absoluteBoundingBox?.y ?: throw kotlin.Exception("Can't derive from anything")
    override val rotation: Double = 0.0
    override val width: Double
        get() = realwidth ?: absoluteBoundingBox?.width ?: throw kotlin.Exception("Can't derive from anything")
    override val height: Double
        get() = realheight ?: absoluteBoundingBox?.height ?: throw kotlin.Exception("Can't derive from anything")
}

//@Serializable
open class StarNode(
    override val type: String = "STAR" /* "STAR" */,

    val pointCount: Double? = null,
    val innerRadius: Double? = null,
    override val id: String? = null,
//    override val parent: Any? = null,
    override val name: String? = null,
    override val removed: Boolean? = null,
    override val visible: Boolean? = null,
    override val locked: Boolean? = null,
    override val constraints: Constraints? = null,
//    override val absoluteTransform: Any? = null,
//  override val relativeTransform: Triple<Triple<Double, Double, Double>,
//       Triple<Double, Double, Double>,
//       Triple<Double, Double, Double> >? = null,

    val absoluteBoundingBox: Rect? = null,

    override val constrainProportions: Boolean? = null,
    override val layoutAlign: String? = null,
    override val opacity: Double = 1.0,
    override val blendMode: String? = null,
    override val isMask: Boolean? = null,
//    override val effects: Array<Any>? = null,
    override val effectStyleId: String? = null,
    override val fills: Array<Paint>? = null,
//    override val strokes: Array<Any>? = null,
    override val strokeWeight: Double? = null,
    override val strokeMiterLimit: Double? = null,
    override val strokeAlign: String? = null,
//    override val strokeCap: Any? = null,
//    override val strokeJoin: Any? = null,
    override val dashPattern: Array<Double>? = null,
//    override val fillStyleId: Any? = null,
    override val strokeStyleId: String? = null,
//    override val cornerRadius: Any? = null,
    override val cornerSmoothing: Double? = null,
//    override val exportSettings: Array<Any>? = null,
    override val reactions: Array<Reaction>? = null, override val cornerRadius: Double? = 0.0,
    x: Double? = null,
    y: Double? = null,
    rotation: Double? = null,
    width: Double? = null,
    height: Double? = null,
    val realx: Double? = x,
    val realy: Double? = y,
    val realrotation: Double? = rotation,
    val realwidth: Double? = width,
    val realheight: Double? = height,

    ) : Serializable, DefaultShapeMixin, ConstraintMixin, CornerMixin {

    override val x: Double
        get() = realx ?: absoluteBoundingBox?.x ?: throw kotlin.Exception("Can't derive from anything")
    override val y: Double
        get() = realy ?: absoluteBoundingBox?.y ?: throw kotlin.Exception("Can't derive from anything")
    override val rotation: Double = 0.0
    override val width: Double
        get() = realwidth ?: absoluteBoundingBox?.width ?: throw kotlin.Exception("Can't derive from anything")
    override val height: Double
        get() = realheight ?: absoluteBoundingBox?.height ?: throw kotlin.Exception("Can't derive from anything")
}

//@Serializable
open class VectorNode(
    override val type: String = "VECTOR"/* "VECTOR" */,

    override val constraints: Constraints? = null,
    val absoluteBoundingBox: Rect? = null,
    val vectorNetwork: VectorNetwork? = null,
    val vectorPaths: Array<VectorPath>? = null,
//    val handleMirroring: Any = "NONE" /* "NONE" | "ANGLE" | "ANGLE_AND_LENGTH" | Any */,
    override val id: String? = null,
//    override val parent: Any? = null,
    override val name: String? = null,
    override val removed: Boolean? = null,
    override val visible: Boolean? = null,
    override val locked: Boolean? = null,
//    override val absoluteTransform: Any? = null,
//    override val relativeTransform: Triple<Triple<Double, Double, Double>,
//       Triple<Double, Double, Double>,
//       Triple<Double, Double, Double> >? = null,
    override val constrainProportions: Boolean? = null,
    override val layoutAlign: String? = null,
    override val opacity: Double = 1.0,
    override val blendMode: String? = null,
    override val isMask: Boolean? = null,
//    override val effects: Array<Any>? = null,
    override val effectStyleId: String? = null,
    override val fills: Array<Paint>? = null,
//    override val strokes: Array<Any>? = null,
    override val strokeWeight: Double? = null,
    override val strokeMiterLimit: Double? = null,
    override val strokeAlign: String? = null,
//    override val strokeCap: Any? = null,
//    override val strokeJoin: Any? = null,
    override val dashPattern: Array<Double>? = null,
//    override val fillStyleId: Any? = null,
    override val strokeStyleId: String? = null,
//    override val cornerRadius: Any? = null,
    override val cornerSmoothing: Double? = null,
//    override val exportSettings: Array<Any>? = null,
    override val reactions: Array<Reaction>? = null, override val cornerRadius: Double? = 0.0,
    x: Double? = null,
    y: Double? = null,
    rotation: Double? = null,
    width: Double? = null,
    height: Double? = null,
    val realx: Double? = x,
    val realy: Double? = y,
    val realrotation: Double? = rotation,
    val realwidth: Double? = width,
    val realheight: Double? = height,
) : Serializable, DefaultShapeMixin, ConstraintMixin, CornerMixin {
//    override val x: Double
//        get() = absoluteBoundingBox.x
//    override val y: Double
//        get() = absoluteBoundingBox.y
//    override val rotation: Double = 0.0
//    override val width: Double
//        get() = absoluteBoundingBox.width
//    override val height: Double
//        get() = absoluteBoundingBox.height
//    constructor()

    override val x: Double
        get() = realx ?: absoluteBoundingBox?.x ?: throw kotlin.Exception("Can't derive from anything")
    override val y: Double
        get() = realy ?: absoluteBoundingBox?.y ?: throw kotlin.Exception("Can't derive from anything")
    override val rotation: Double = 0.0
    override val width: Double
        get() = realwidth ?: absoluteBoundingBox?.width ?: throw kotlin.Exception("Can't derive from anything")
    override val height: Double
        get() = realheight ?: absoluteBoundingBox?.height ?: throw kotlin.Exception("Can't derive from anything")
}

//@Serializable
open class TextNode(
    override val type: String = "TEXT" /* "TEXT" */,

    val hasMissingFont: Boolean? = null,
    val textAlignHorizontal: String? = null /* "LEFT" | "CENTER" | "RIGHT" | "JUSTIFIED" */,
    val textAlignVertical: String? = null /* "TOP" | "CENTER" | "BOTTOM" */,
    val textAutoResize: String? = null /* "NONE" | "WIDTH_AND_HEIGHT" | "HEIGHT" */,
    val paragraphIndent: Double? = null,
    val paragraphSpacing: Double? = null,
    val autoRename: Boolean? = null,
    val textStyleId: String? = null /* String | Any */,


//    val fontSize: Any? = null /* Double | Any */,


//    val fontName: Any? = null /* FontName | Any */,


//    val textCase: Any? = null /* "ORIGINAL" | "UPPER" | "LOWER" | "TITLE" | Any */,


//    val textDecoration: Any? = null /* "NONE" | "UNDERLINE" | "STRIKETHROUGH" | Any */,


//    val letterSpacing: Any? = null /* LetterSpacing | Any */,


//    val lineHeight: Any? = null /* `T$2` | `T$3` | Any */,


    val characters: String? = null,
    override val id: String? = null,
//    override val parent: Any? = null,
    override val name: String? = null,
    override val removed: Boolean? = null,
    override val visible: Boolean? = null,
    override val locked: Boolean? = null,
    override val constraints: Constraints? = null,
//    override val absoluteTransform: Any? = null,
//  override val relativeTransform: Triple<Triple<Double, Double, Double>,
//       Triple<Double, Double, Double>,
//       Triple<Double, Double, Double> >? = null,

//    val absoluteBoundingBox: Rect? = null,

    override val constrainProportions: Boolean? = null,
    override val layoutAlign: String? = null,
    override val opacity: Double = 1.0,
    override val blendMode: String? = null,
    override val isMask: Boolean? = null,
//    override val effects: Array<Any>? = null,
    override val effectStyleId: String? = null,
    override val fills: Array<Paint>? = null,
//    override val strokes: Array<Any>? = null,
    override val strokeWeight: Double? = null,
    override val strokeMiterLimit: Double? = null,
    override val strokeAlign: String? = null,
//    override val strokeCap: Any? = null,
//    override val strokeJoin: Any? = null,
    override val dashPattern: Array<Double>? = null,
    val fillStyleId: Any? = null,
    override val strokeStyleId: String? = null,
//    override val exportSettings: Array<Any>? = null,
    override val reactions: Array<Reaction>? = null,
    override val x: Double,
    override val y: Double,
    override val rotation: Double,
    override val width: Double,
    override val height: Double,


    ) : Serializable, DefaultShapeMixin, ConstraintMixin {
//    override val x: Double
//        get() = absoluteBoundingBox.x
//    override val y: Double
//        get() = absoluteBoundingBox.y
//    override val rotation: Double = 0.0
//    override val width: Double
//        get() = absoluteBoundingBox.width
//    override val height: Double
//        get() = absoluteBoundingBox.height
}

//@Serializable
open class ComponentNode(
    override val type: String = "COMPONENT" /* "COMPONENT" */,


    val description: String? = null,
    val remote: Boolean? = null,
    val key: String? = null,
    override val id: String? = null,
//    override val parent: Any? = null,
    override val name: String? = null,
    override val removed: Boolean? = null,
    override val visible: Boolean? = null,
    override val locked: Boolean? = null,
    override val children: Array<BaseNodeMixin>? = null,
    override val constraints: Constraints? = null,
//    override val absoluteTransform: Any? = null,
//  override val relativeTransform: Triple<Triple<Double, Double, Double>,
//       Triple<Double, Double, Double>,
//       Triple<Double, Double, Double> >? = null,

    val absoluteBoundingBox: Rect? = null,

    override val constrainProportions: Boolean? = null,
    override val layoutAlign: String? = null,
    override val opacity: Double = 1.0,
    override val blendMode: String? = null,
    override val isMask: Boolean? = null,
//    override val effects: Array<Any>? = null,
    override val effectStyleId: String? = null,
    override val expanded: Boolean? = null,
//    override val backgrounds: Array<Any>? = null,
    override val backgroundStyleId: String? = null,
    override val fills: Array<Paint>? = null,
//    override val strokes: Array<Any>? = null,
    override val strokeWeight: Double? = null,
    override val strokeMiterLimit: Double? = null,
    override val strokeAlign: String? = null,
//    override val strokeCap: Any? = null,
//    override val strokeJoin: Any? = null,
    override val dashPattern: Array<Double>? = null,
//    override val fillStyleId: Any? = null,
    override val strokeStyleId: String? = null,
//    override val cornerRadius: Any? = null,
    override val cornerSmoothing: Double? = null,
    override val topLeftRadius: Double? = null,
    override val topRightRadius: Double? = null,
    override val bottomLeftRadius: Double? = null,
    override val bottomRightRadius: Double? = null,
//    override val exportSettings: Array<Any>? = null,
    override val reactions: Array<Reaction>? = null,
    override val layoutMode: String? = null,
    override val counterAxisSizingMode: String? = null,
    override val horizontalPadding: Double? = null,
    override val verticalPadding: Double? = null,
    override val itemSpacing: Double? = null,
//    override val layoutGrids: Array<Any>? = null,
    override val gridStyleId: String? = null,
    override val clipsContent: Boolean? = null,
    override val guides: Array<Guide>? = null,
    override val overflowDirection: String? = null,
    override val DoubleOfFixedChildren: Double? = null,
    override val overlayPositionType: String? = null,
//    override val overlayBackground: Any? = null,
    override val overlayBackgroundInteraction: String? = null,
    override val cornerRadius: Double? = 0.0,
    x: Double? = null,
    y: Double? = null,
    rotation: Double? = null,
    width: Double? = null,
    height: Double? = null,
    val realx: Double? = x,
    val realy: Double? = y,
    val realrotation: Double? = rotation,
    val realwidth: Double? = width,
    val realheight: Double? = height,
) : Serializable, DefaultFrameMixin{

    override val x: Double
        get() = realx ?: absoluteBoundingBox?.x ?: throw kotlin.Exception("Can't derive from anything")
    override val y: Double
        get() = realy ?: absoluteBoundingBox?.y ?: throw kotlin.Exception("Can't derive from anything")
    override val rotation: Double = 0.0
    override val width: Double
        get() = realwidth ?: absoluteBoundingBox?.width ?: throw kotlin.Exception("Can't derive from anything")
    override val height: Double
        get() = realheight ?: absoluteBoundingBox?.height ?: throw kotlin.Exception("Can't derive from anything")
}

//@Serializable
open class InstanceNode(
    override val type: String = "INSTANCE" /* "INSTANCE" */,

    val masterComponent: ComponentNode? = null,
    val scaleFactor: Double? = null,
    override val id: String? = null,
//    override val parent: Any? = null,
    override val name: String? = null,
    override val removed: Boolean? = null,
    override val visible: Boolean? = null,
    override val locked: Boolean? = null,
    override val children: Array<BaseNodeMixin>?,
    override val constraints: Constraints? = null,
//    override val absoluteTransform: Any? = null,
//    override val relativeTransform: Triple<Triple<Double, Double, Double>,
//       Triple<Double, Double, Double>,
//       Triple<Double, Double, Double> >? = null,
    val absoluteBoundingBox: Rect? = null,

    override val constrainProportions: Boolean? = null,
    override val layoutAlign: String? = null,
    override val opacity: Double = 1.0,
    override val blendMode: String? = null,
    override val isMask: Boolean? = null,
//    override val effects: Array<Any>? = null,
    override val effectStyleId: String? = null,
    override val expanded: Boolean? = null,
//    override val backgrounds: Array<Any>? = null,
    override val backgroundStyleId: String? = null,
    override val fills: Array<Paint>? = null,
//    override val strokes: Array<Any>? = null,
    override val strokeWeight: Double? = null,
    override val strokeMiterLimit: Double? = null,
    override val strokeAlign: String? = null,
//    override val strokeCap: Any? = null,
//    override val strokeJoin: Any? = null,
    override val dashPattern: Array<Double>? = null,
//    override val fillStyleId: Any? = null,
    override val strokeStyleId: String? = null,
//    override val cornerRadius: Any? = null,
    override val cornerSmoothing: Double? = null,
    override val topLeftRadius: Double? = null,
    override val topRightRadius: Double? = null,
    override val bottomLeftRadius: Double? = null,
    override val bottomRightRadius: Double? = null,
//    override val exportSettings: Array<Any>? = null,
    override val reactions: Array<Reaction>? = null,
    override val layoutMode: String? = null,
    override val counterAxisSizingMode: String? = null,
    override val horizontalPadding: Double? = null,
    override val verticalPadding: Double? = null,
    override val itemSpacing: Double? = null,
//    override val layoutGrids: Array<Any>? = null,
    override val gridStyleId: String? = null,
    override val clipsContent: Boolean? = null,
    override val guides: Array<Guide>? = null,
    override val overflowDirection: String? = null,
    override val DoubleOfFixedChildren: Double? = null,
    override val overlayPositionType: String? = null,
//    override val overlayBackground: Any? = null,
    override val overlayBackgroundInteraction: String? = null,
    override val cornerRadius: Double? = 0.0,

    x: Double? = null,
    y: Double? = null,
    rotation: Double? = null,
    width: Double? = null,
    height: Double? = null,
    val realx: Double? = x,
    val realy: Double? = y,
    val realrotation: Double? = rotation,
    val realwidth: Double? = width,
    val realheight: Double? = height,

    ) : Serializable, DefaultFrameMixin {

    override val x: Double
        get() = realx ?: absoluteBoundingBox?.x ?: throw kotlin.Exception("Can't derive from anything")
    override val y: Double
        get() = realy ?: absoluteBoundingBox?.y ?: throw kotlin.Exception("Can't derive from anything")
    override val rotation: Double = 0.0
    override val width: Double
        get() = realwidth ?: absoluteBoundingBox?.width ?: throw kotlin.Exception("Can't derive from anything")
    override val height: Double
        get() = realheight ?: absoluteBoundingBox?.height ?: throw kotlin.Exception("Can't derive from anything")
}

//@Serializable
open class BooleanOperationNode(
    override val type: String = "BOOLEAN_OPERATION"/* "BOOLEAN_OPERATION" */,

    val booleanOperation: String /* "UNION" | "INTERSECT" | "SUBTRACT" | "EXCLUDE" */,
    val expanded: Boolean? = null,
    override val id: String? = null,
//    override val parent: Any? = null,
    override val name: String? = null,
    override val removed: Boolean? = null,
    override val visible: Boolean? = null,
    override val locked: Boolean? = null,
    override val children: Array<BaseNodeMixin>?,
//    override val absoluteTransform: Any? = null,
//  override val relativeTransform: Triple<Triple<Double, Double, Double>,
//       Triple<Double, Double, Double>,
//       Triple<Double, Double, Double> >? = null,

    val absoluteBoundingBox: Rect? = null,

    override val constrainProportions: Boolean? = null,
    override val layoutAlign: String? = null,
    override val opacity: Double = 1.0,
    override val blendMode: String? = null,
    override val isMask: Boolean? = null,
//    override val effects: Array<Any>? = null,
    override val effectStyleId: String? = null,
    override val fills: Array<Paint>? = null,
//    override val strokes: Array<Any>? = null,
    override val strokeWeight: Double? = null,
    override val strokeMiterLimit: Double? = null,
    override val strokeAlign: String? = null,
//    override val strokeCap: Any? = null,
//    override val strokeJoin: Any? = null,
    override val dashPattern: Array<Double>? = null,
//    override val fillStyleId: Any? = null,
    override val strokeStyleId: String? = null,
//    override val cornerRadius: Any? = null,
    override val cornerSmoothing: Double? = null,
//    override val exportSettings: Array<Any>? = null,
    override val reactions: Array<Reaction>? = null, override val cornerRadius: Double? = 0.0,
    x: Double? = null,
    y: Double? = null,
    rotation: Double? = null,
    width: Double? = null,
    height: Double? = null,
    val realx: Double? = x,
    val realy: Double? = y,
    val realrotation: Double? = rotation,
    val realwidth: Double? = width,
    val realheight: Double? = height,

    ) : Serializable, DefaultShapeMixin, ChildrenMixin, CornerMixin {

    override val x: Double
        get() = realx ?: absoluteBoundingBox?.x ?: throw kotlin.Exception("Can't derive from anything")
    override val y: Double
        get() = realy ?: absoluteBoundingBox?.y ?: throw kotlin.Exception("Can't derive from anything")
    override val rotation: Double = 0.0
    override val width: Double
        get() = realwidth ?: absoluteBoundingBox?.width ?: throw kotlin.Exception("Can't derive from anything")
    override val height: Double
        get() = realheight ?: absoluteBoundingBox?.height ?: throw kotlin.Exception("Can't derive from anything")
}

//@Serializable
class BaseStyleImpl(
    override val id: String? = null,
    override val type: String? = null,
    override val name: String? = null,
    override val description: String? = null,
    override val remote: Boolean? = null,
    override val key: String?
) : Serializable, BaseStyle {

    // Alternative constructor to match what api seems to be returning currently
    constructor(
        styleType: String = "not set!",
        name: String? = null,
        description: String? = "",
        key: String? = name
    ) : this(key, styleType, name, description, false, key)

}

interface BaseStyle {
    val id: String?
    val type: String? /* "PAINT" | "TEXT" | "EFFECT" | "GRID" */
    val name: String?
    val description: String?
    val remote: Boolean?
    val key: String?
}

//@Serializable
open class PaintStyle(
    override val type: String? /* "PAINT" */,
//    val paints: Array<Any /* SolidPaint | GradientPaint | ImagePaint */>,
    override val id: String? = null,
    override val name: String? = null,
    override val description: String? = null,
    override val remote: Boolean? = null,
    override val key: String? = null,
) : Serializable, BaseStyle

//@Serializable
open class TextStyle(
    override val type: String? /* "TEXT" */,
    val fontSize: Double? = null,
    val textDecoration: String? /* "NONE" | "UNDERLINE" | "STRIKETHROUGH" */,
    val fontName: FontName? = null,
    val letterSpacing: LetterSpacing? = null,
//    val lineHeight: Any /* `T$2` | `T$3` */,


    val paragraphIndent: Double? = null,
    val paragraphSpacing: Double? = null,
    val textCase: String /* "ORIGINAL" | "UPPER" | "LOWER" | "TITLE" */,
    override val id: String? = null,
    override val name: String? = null,
    override val description: String? = null,
    override val remote: Boolean? = null,
    override val key: String? = null,

    ) : Serializable, BaseStyle

//@Serializable
open class EffectStyle(
    override val type: String? /* "EFFECT" */,
//    val effects: Array<Any /* ShadowEffect | BlurEffect */>,
    override val id: String? = null,
    override val name: String? = null,
    override val description: String? = null,
    override val remote: Boolean? = null,
    override val key: String? = null,

    ) : Serializable, BaseStyle

//@Serializable
open class GridStyle(
    override val type: String? /* "GRID" */,
//    val layoutGrids: Array<Any /* RowsColsLayoutGrid | GridLayoutGrid */>,
    override val id: String? = null,
    override val name: String? = null,
    override val description: String? = null,
    override val remote: Boolean? = null,
    override val key: String? = null,

    ) : Serializable, BaseStyle

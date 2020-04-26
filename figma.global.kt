@file:JsQualifier("global")
@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS", "EXTERNAL_DELEGATION")
package global

import kotlin.js.*
import kotlin.js.Json
import org.khronos.webgl.*
import org.w3c.dom.*
import org.w3c.dom.events.*
import org.w3c.dom.parsing.*
import org.w3c.dom.svg.*
import org.w3c.dom.url.*
import org.w3c.fetch.*
import org.w3c.files.*
import org.w3c.notifications.*
import org.w3c.performance.*
import org.w3c.workers.*
import org.w3c.xhr.*

external var figma: PluginAPI

external var __html__: String

external interface PluginAPI {
    var apiVersion: String /* "1.0.0" */
    var command: String
    var viewport: ViewportAPI
    fun closePlugin(message: String = definedExternally)
    fun notify(message: String, options: NotificationOptions = definedExternally): NotificationHandler
    fun showUI(html: String, options: ShowUIOptions = definedExternally)
    var ui: UIAPI
    var clientStorage: ClientStorageAPI
    fun getNodeById(id: String): dynamic /* DocumentNode | PageNode | SliceNode | FrameNode | GroupNode | ComponentNode | InstanceNode | BooleanOperationNode | VectorNode | StarNode | LineNode | EllipseNode | PolygonNode | RectangleNode | TextNode */
    fun getStyleById(id: String): BaseStyle?
    var root: DocumentNode
    var currentPage: PageNode
    fun on(type: String, callback: () -> Unit)
    fun once(type: String, callback: () -> Unit)
    fun off(type: String, callback: () -> Unit)
    var mixed: Any
    fun createRectangle(): RectangleNode
    fun createLine(): LineNode
    fun createEllipse(): EllipseNode
    fun createPolygon(): PolygonNode
    fun createStar(): StarNode
    fun createVector(): VectorNode
    fun createText(): TextNode
    fun createFrame(): FrameNode
    fun createComponent(): ComponentNode
    fun createPage(): PageNode
    fun createSlice(): SliceNode
    fun createBooleanOperation(): BooleanOperationNode
    fun createPaintStyle(): PaintStyle
    fun createTextStyle(): TextStyle
    fun createEffectStyle(): EffectStyle
    fun createGridStyle(): GridStyle
    fun getLocalPaintStyles(): Array<PaintStyle>
    fun getLocalTextStyles(): Array<TextStyle>
    fun getLocalEffectStyles(): Array<EffectStyle>
    fun getLocalGridStyles(): Array<GridStyle>
    fun importComponentByKeyAsync(key: String): Promise<ComponentNode>
    fun importStyleByKeyAsync(key: String): Promise<BaseStyle>
    fun listAvailableFontsAsync(): Promise<Array<Font>>
    fun loadFontAsync(fontName: FontName): Promise<Unit>
    var hasMissingFont: Boolean
    fun createNodeFromSvg(svg: String): FrameNode
    fun createImage(data: Uint8Array): Image
    fun getImageByHash(hash: String): Image
    fun group(nodes: Array<dynamic /* DocumentNode | PageNode | SliceNode | FrameNode | GroupNode | ComponentNode | InstanceNode | BooleanOperationNode | VectorNode | StarNode | LineNode | EllipseNode | PolygonNode | RectangleNode | TextNode */>, parent: DocumentNode, index: Number = definedExternally): GroupNode
    fun group(nodes: Array<dynamic /* DocumentNode | PageNode | SliceNode | FrameNode | GroupNode | ComponentNode | InstanceNode | BooleanOperationNode | VectorNode | StarNode | LineNode | EllipseNode | PolygonNode | RectangleNode | TextNode */>, parent: PageNode, index: Number = definedExternally): GroupNode
    fun group(nodes: Array<dynamic /* DocumentNode | PageNode | SliceNode | FrameNode | GroupNode | ComponentNode | InstanceNode | BooleanOperationNode | VectorNode | StarNode | LineNode | EllipseNode | PolygonNode | RectangleNode | TextNode */>, parent: SliceNode, index: Number = definedExternally): GroupNode
    fun group(nodes: Array<dynamic /* DocumentNode | PageNode | SliceNode | FrameNode | GroupNode | ComponentNode | InstanceNode | BooleanOperationNode | VectorNode | StarNode | LineNode | EllipseNode | PolygonNode | RectangleNode | TextNode */>, parent: FrameNode, index: Number = definedExternally): GroupNode
    fun group(nodes: Array<dynamic /* DocumentNode | PageNode | SliceNode | FrameNode | GroupNode | ComponentNode | InstanceNode | BooleanOperationNode | VectorNode | StarNode | LineNode | EllipseNode | PolygonNode | RectangleNode | TextNode */>, parent: GroupNode, index: Number = definedExternally): GroupNode
    fun group(nodes: Array<dynamic /* DocumentNode | PageNode | SliceNode | FrameNode | GroupNode | ComponentNode | InstanceNode | BooleanOperationNode | VectorNode | StarNode | LineNode | EllipseNode | PolygonNode | RectangleNode | TextNode */>, parent: ComponentNode, index: Number = definedExternally): GroupNode
    fun group(nodes: Array<dynamic /* DocumentNode | PageNode | SliceNode | FrameNode | GroupNode | ComponentNode | InstanceNode | BooleanOperationNode | VectorNode | StarNode | LineNode | EllipseNode | PolygonNode | RectangleNode | TextNode */>, parent: InstanceNode, index: Number = definedExternally): GroupNode
    fun group(nodes: Array<dynamic /* DocumentNode | PageNode | SliceNode | FrameNode | GroupNode | ComponentNode | InstanceNode | BooleanOperationNode | VectorNode | StarNode | LineNode | EllipseNode | PolygonNode | RectangleNode | TextNode */>, parent: BooleanOperationNode, index: Number = definedExternally): GroupNode
    fun group(nodes: Array<dynamic /* DocumentNode | PageNode | SliceNode | FrameNode | GroupNode | ComponentNode | InstanceNode | BooleanOperationNode | VectorNode | StarNode | LineNode | EllipseNode | PolygonNode | RectangleNode | TextNode */>, parent: VectorNode, index: Number = definedExternally): GroupNode
    fun group(nodes: Array<dynamic /* DocumentNode | PageNode | SliceNode | FrameNode | GroupNode | ComponentNode | InstanceNode | BooleanOperationNode | VectorNode | StarNode | LineNode | EllipseNode | PolygonNode | RectangleNode | TextNode */>, parent: StarNode, index: Number = definedExternally): GroupNode
    fun group(nodes: Array<dynamic /* DocumentNode | PageNode | SliceNode | FrameNode | GroupNode | ComponentNode | InstanceNode | BooleanOperationNode | VectorNode | StarNode | LineNode | EllipseNode | PolygonNode | RectangleNode | TextNode */>, parent: LineNode, index: Number = definedExternally): GroupNode
    fun group(nodes: Array<dynamic /* DocumentNode | PageNode | SliceNode | FrameNode | GroupNode | ComponentNode | InstanceNode | BooleanOperationNode | VectorNode | StarNode | LineNode | EllipseNode | PolygonNode | RectangleNode | TextNode */>, parent: EllipseNode, index: Number = definedExternally): GroupNode
    fun group(nodes: Array<dynamic /* DocumentNode | PageNode | SliceNode | FrameNode | GroupNode | ComponentNode | InstanceNode | BooleanOperationNode | VectorNode | StarNode | LineNode | EllipseNode | PolygonNode | RectangleNode | TextNode */>, parent: PolygonNode, index: Number = definedExternally): GroupNode
    fun group(nodes: Array<dynamic /* DocumentNode | PageNode | SliceNode | FrameNode | GroupNode | ComponentNode | InstanceNode | BooleanOperationNode | VectorNode | StarNode | LineNode | EllipseNode | PolygonNode | RectangleNode | TextNode */>, parent: RectangleNode, index: Number = definedExternally): GroupNode
    fun group(nodes: Array<dynamic /* DocumentNode | PageNode | SliceNode | FrameNode | GroupNode | ComponentNode | InstanceNode | BooleanOperationNode | VectorNode | StarNode | LineNode | EllipseNode | PolygonNode | RectangleNode | TextNode */>, parent: TextNode, index: Number = definedExternally): GroupNode
    fun flatten(nodes: Array<dynamic /* DocumentNode | PageNode | SliceNode | FrameNode | GroupNode | ComponentNode | InstanceNode | BooleanOperationNode | VectorNode | StarNode | LineNode | EllipseNode | PolygonNode | RectangleNode | TextNode */>, parent: DocumentNode = definedExternally, index: Number = definedExternally): VectorNode
    fun flatten(nodes: Array<dynamic /* DocumentNode | PageNode | SliceNode | FrameNode | GroupNode | ComponentNode | InstanceNode | BooleanOperationNode | VectorNode | StarNode | LineNode | EllipseNode | PolygonNode | RectangleNode | TextNode */>, parent: PageNode = definedExternally, index: Number = definedExternally): VectorNode
    fun flatten(nodes: Array<dynamic /* DocumentNode | PageNode | SliceNode | FrameNode | GroupNode | ComponentNode | InstanceNode | BooleanOperationNode | VectorNode | StarNode | LineNode | EllipseNode | PolygonNode | RectangleNode | TextNode */>, parent: SliceNode = definedExternally, index: Number = definedExternally): VectorNode
    fun flatten(nodes: Array<dynamic /* DocumentNode | PageNode | SliceNode | FrameNode | GroupNode | ComponentNode | InstanceNode | BooleanOperationNode | VectorNode | StarNode | LineNode | EllipseNode | PolygonNode | RectangleNode | TextNode */>, parent: FrameNode = definedExternally, index: Number = definedExternally): VectorNode
    fun flatten(nodes: Array<dynamic /* DocumentNode | PageNode | SliceNode | FrameNode | GroupNode | ComponentNode | InstanceNode | BooleanOperationNode | VectorNode | StarNode | LineNode | EllipseNode | PolygonNode | RectangleNode | TextNode */>, parent: GroupNode = definedExternally, index: Number = definedExternally): VectorNode
    fun flatten(nodes: Array<dynamic /* DocumentNode | PageNode | SliceNode | FrameNode | GroupNode | ComponentNode | InstanceNode | BooleanOperationNode | VectorNode | StarNode | LineNode | EllipseNode | PolygonNode | RectangleNode | TextNode */>, parent: ComponentNode = definedExternally, index: Number = definedExternally): VectorNode
    fun flatten(nodes: Array<dynamic /* DocumentNode | PageNode | SliceNode | FrameNode | GroupNode | ComponentNode | InstanceNode | BooleanOperationNode | VectorNode | StarNode | LineNode | EllipseNode | PolygonNode | RectangleNode | TextNode */>, parent: InstanceNode = definedExternally, index: Number = definedExternally): VectorNode
    fun flatten(nodes: Array<dynamic /* DocumentNode | PageNode | SliceNode | FrameNode | GroupNode | ComponentNode | InstanceNode | BooleanOperationNode | VectorNode | StarNode | LineNode | EllipseNode | PolygonNode | RectangleNode | TextNode */>, parent: BooleanOperationNode = definedExternally, index: Number = definedExternally): VectorNode
    fun flatten(nodes: Array<dynamic /* DocumentNode | PageNode | SliceNode | FrameNode | GroupNode | ComponentNode | InstanceNode | BooleanOperationNode | VectorNode | StarNode | LineNode | EllipseNode | PolygonNode | RectangleNode | TextNode */>, parent: VectorNode = definedExternally, index: Number = definedExternally): VectorNode
    fun flatten(nodes: Array<dynamic /* DocumentNode | PageNode | SliceNode | FrameNode | GroupNode | ComponentNode | InstanceNode | BooleanOperationNode | VectorNode | StarNode | LineNode | EllipseNode | PolygonNode | RectangleNode | TextNode */>, parent: StarNode = definedExternally, index: Number = definedExternally): VectorNode
    fun flatten(nodes: Array<dynamic /* DocumentNode | PageNode | SliceNode | FrameNode | GroupNode | ComponentNode | InstanceNode | BooleanOperationNode | VectorNode | StarNode | LineNode | EllipseNode | PolygonNode | RectangleNode | TextNode */>, parent: LineNode = definedExternally, index: Number = definedExternally): VectorNode
    fun flatten(nodes: Array<dynamic /* DocumentNode | PageNode | SliceNode | FrameNode | GroupNode | ComponentNode | InstanceNode | BooleanOperationNode | VectorNode | StarNode | LineNode | EllipseNode | PolygonNode | RectangleNode | TextNode */>, parent: EllipseNode = definedExternally, index: Number = definedExternally): VectorNode
    fun flatten(nodes: Array<dynamic /* DocumentNode | PageNode | SliceNode | FrameNode | GroupNode | ComponentNode | InstanceNode | BooleanOperationNode | VectorNode | StarNode | LineNode | EllipseNode | PolygonNode | RectangleNode | TextNode */>, parent: PolygonNode = definedExternally, index: Number = definedExternally): VectorNode
    fun flatten(nodes: Array<dynamic /* DocumentNode | PageNode | SliceNode | FrameNode | GroupNode | ComponentNode | InstanceNode | BooleanOperationNode | VectorNode | StarNode | LineNode | EllipseNode | PolygonNode | RectangleNode | TextNode */>, parent: RectangleNode = definedExternally, index: Number = definedExternally): VectorNode
    fun flatten(nodes: Array<dynamic /* DocumentNode | PageNode | SliceNode | FrameNode | GroupNode | ComponentNode | InstanceNode | BooleanOperationNode | VectorNode | StarNode | LineNode | EllipseNode | PolygonNode | RectangleNode | TextNode */>, parent: TextNode = definedExternally, index: Number = definedExternally): VectorNode
    fun union(nodes: Array<dynamic /* DocumentNode | PageNode | SliceNode | FrameNode | GroupNode | ComponentNode | InstanceNode | BooleanOperationNode | VectorNode | StarNode | LineNode | EllipseNode | PolygonNode | RectangleNode | TextNode */>, parent: DocumentNode, index: Number = definedExternally): BooleanOperationNode
    fun union(nodes: Array<dynamic /* DocumentNode | PageNode | SliceNode | FrameNode | GroupNode | ComponentNode | InstanceNode | BooleanOperationNode | VectorNode | StarNode | LineNode | EllipseNode | PolygonNode | RectangleNode | TextNode */>, parent: PageNode, index: Number = definedExternally): BooleanOperationNode
    fun union(nodes: Array<dynamic /* DocumentNode | PageNode | SliceNode | FrameNode | GroupNode | ComponentNode | InstanceNode | BooleanOperationNode | VectorNode | StarNode | LineNode | EllipseNode | PolygonNode | RectangleNode | TextNode */>, parent: SliceNode, index: Number = definedExternally): BooleanOperationNode
    fun union(nodes: Array<dynamic /* DocumentNode | PageNode | SliceNode | FrameNode | GroupNode | ComponentNode | InstanceNode | BooleanOperationNode | VectorNode | StarNode | LineNode | EllipseNode | PolygonNode | RectangleNode | TextNode */>, parent: FrameNode, index: Number = definedExternally): BooleanOperationNode
    fun union(nodes: Array<dynamic /* DocumentNode | PageNode | SliceNode | FrameNode | GroupNode | ComponentNode | InstanceNode | BooleanOperationNode | VectorNode | StarNode | LineNode | EllipseNode | PolygonNode | RectangleNode | TextNode */>, parent: GroupNode, index: Number = definedExternally): BooleanOperationNode
    fun union(nodes: Array<dynamic /* DocumentNode | PageNode | SliceNode | FrameNode | GroupNode | ComponentNode | InstanceNode | BooleanOperationNode | VectorNode | StarNode | LineNode | EllipseNode | PolygonNode | RectangleNode | TextNode */>, parent: ComponentNode, index: Number = definedExternally): BooleanOperationNode
    fun union(nodes: Array<dynamic /* DocumentNode | PageNode | SliceNode | FrameNode | GroupNode | ComponentNode | InstanceNode | BooleanOperationNode | VectorNode | StarNode | LineNode | EllipseNode | PolygonNode | RectangleNode | TextNode */>, parent: InstanceNode, index: Number = definedExternally): BooleanOperationNode
    fun union(nodes: Array<dynamic /* DocumentNode | PageNode | SliceNode | FrameNode | GroupNode | ComponentNode | InstanceNode | BooleanOperationNode | VectorNode | StarNode | LineNode | EllipseNode | PolygonNode | RectangleNode | TextNode */>, parent: BooleanOperationNode, index: Number = definedExternally): BooleanOperationNode
    fun union(nodes: Array<dynamic /* DocumentNode | PageNode | SliceNode | FrameNode | GroupNode | ComponentNode | InstanceNode | BooleanOperationNode | VectorNode | StarNode | LineNode | EllipseNode | PolygonNode | RectangleNode | TextNode */>, parent: VectorNode, index: Number = definedExternally): BooleanOperationNode
    fun union(nodes: Array<dynamic /* DocumentNode | PageNode | SliceNode | FrameNode | GroupNode | ComponentNode | InstanceNode | BooleanOperationNode | VectorNode | StarNode | LineNode | EllipseNode | PolygonNode | RectangleNode | TextNode */>, parent: StarNode, index: Number = definedExternally): BooleanOperationNode
    fun union(nodes: Array<dynamic /* DocumentNode | PageNode | SliceNode | FrameNode | GroupNode | ComponentNode | InstanceNode | BooleanOperationNode | VectorNode | StarNode | LineNode | EllipseNode | PolygonNode | RectangleNode | TextNode */>, parent: LineNode, index: Number = definedExternally): BooleanOperationNode
    fun union(nodes: Array<dynamic /* DocumentNode | PageNode | SliceNode | FrameNode | GroupNode | ComponentNode | InstanceNode | BooleanOperationNode | VectorNode | StarNode | LineNode | EllipseNode | PolygonNode | RectangleNode | TextNode */>, parent: EllipseNode, index: Number = definedExternally): BooleanOperationNode
    fun union(nodes: Array<dynamic /* DocumentNode | PageNode | SliceNode | FrameNode | GroupNode | ComponentNode | InstanceNode | BooleanOperationNode | VectorNode | StarNode | LineNode | EllipseNode | PolygonNode | RectangleNode | TextNode */>, parent: PolygonNode, index: Number = definedExternally): BooleanOperationNode
    fun union(nodes: Array<dynamic /* DocumentNode | PageNode | SliceNode | FrameNode | GroupNode | ComponentNode | InstanceNode | BooleanOperationNode | VectorNode | StarNode | LineNode | EllipseNode | PolygonNode | RectangleNode | TextNode */>, parent: RectangleNode, index: Number = definedExternally): BooleanOperationNode
    fun union(nodes: Array<dynamic /* DocumentNode | PageNode | SliceNode | FrameNode | GroupNode | ComponentNode | InstanceNode | BooleanOperationNode | VectorNode | StarNode | LineNode | EllipseNode | PolygonNode | RectangleNode | TextNode */>, parent: TextNode, index: Number = definedExternally): BooleanOperationNode
    fun subtract(nodes: Array<dynamic /* DocumentNode | PageNode | SliceNode | FrameNode | GroupNode | ComponentNode | InstanceNode | BooleanOperationNode | VectorNode | StarNode | LineNode | EllipseNode | PolygonNode | RectangleNode | TextNode */>, parent: DocumentNode, index: Number = definedExternally): BooleanOperationNode
    fun subtract(nodes: Array<dynamic /* DocumentNode | PageNode | SliceNode | FrameNode | GroupNode | ComponentNode | InstanceNode | BooleanOperationNode | VectorNode | StarNode | LineNode | EllipseNode | PolygonNode | RectangleNode | TextNode */>, parent: PageNode, index: Number = definedExternally): BooleanOperationNode
    fun subtract(nodes: Array<dynamic /* DocumentNode | PageNode | SliceNode | FrameNode | GroupNode | ComponentNode | InstanceNode | BooleanOperationNode | VectorNode | StarNode | LineNode | EllipseNode | PolygonNode | RectangleNode | TextNode */>, parent: SliceNode, index: Number = definedExternally): BooleanOperationNode
    fun subtract(nodes: Array<dynamic /* DocumentNode | PageNode | SliceNode | FrameNode | GroupNode | ComponentNode | InstanceNode | BooleanOperationNode | VectorNode | StarNode | LineNode | EllipseNode | PolygonNode | RectangleNode | TextNode */>, parent: FrameNode, index: Number = definedExternally): BooleanOperationNode
    fun subtract(nodes: Array<dynamic /* DocumentNode | PageNode | SliceNode | FrameNode | GroupNode | ComponentNode | InstanceNode | BooleanOperationNode | VectorNode | StarNode | LineNode | EllipseNode | PolygonNode | RectangleNode | TextNode */>, parent: GroupNode, index: Number = definedExternally): BooleanOperationNode
    fun subtract(nodes: Array<dynamic /* DocumentNode | PageNode | SliceNode | FrameNode | GroupNode | ComponentNode | InstanceNode | BooleanOperationNode | VectorNode | StarNode | LineNode | EllipseNode | PolygonNode | RectangleNode | TextNode */>, parent: ComponentNode, index: Number = definedExternally): BooleanOperationNode
    fun subtract(nodes: Array<dynamic /* DocumentNode | PageNode | SliceNode | FrameNode | GroupNode | ComponentNode | InstanceNode | BooleanOperationNode | VectorNode | StarNode | LineNode | EllipseNode | PolygonNode | RectangleNode | TextNode */>, parent: InstanceNode, index: Number = definedExternally): BooleanOperationNode
    fun subtract(nodes: Array<dynamic /* DocumentNode | PageNode | SliceNode | FrameNode | GroupNode | ComponentNode | InstanceNode | BooleanOperationNode | VectorNode | StarNode | LineNode | EllipseNode | PolygonNode | RectangleNode | TextNode */>, parent: BooleanOperationNode, index: Number = definedExternally): BooleanOperationNode
    fun subtract(nodes: Array<dynamic /* DocumentNode | PageNode | SliceNode | FrameNode | GroupNode | ComponentNode | InstanceNode | BooleanOperationNode | VectorNode | StarNode | LineNode | EllipseNode | PolygonNode | RectangleNode | TextNode */>, parent: VectorNode, index: Number = definedExternally): BooleanOperationNode
    fun subtract(nodes: Array<dynamic /* DocumentNode | PageNode | SliceNode | FrameNode | GroupNode | ComponentNode | InstanceNode | BooleanOperationNode | VectorNode | StarNode | LineNode | EllipseNode | PolygonNode | RectangleNode | TextNode */>, parent: StarNode, index: Number = definedExternally): BooleanOperationNode
    fun subtract(nodes: Array<dynamic /* DocumentNode | PageNode | SliceNode | FrameNode | GroupNode | ComponentNode | InstanceNode | BooleanOperationNode | VectorNode | StarNode | LineNode | EllipseNode | PolygonNode | RectangleNode | TextNode */>, parent: LineNode, index: Number = definedExternally): BooleanOperationNode
    fun subtract(nodes: Array<dynamic /* DocumentNode | PageNode | SliceNode | FrameNode | GroupNode | ComponentNode | InstanceNode | BooleanOperationNode | VectorNode | StarNode | LineNode | EllipseNode | PolygonNode | RectangleNode | TextNode */>, parent: EllipseNode, index: Number = definedExternally): BooleanOperationNode
    fun subtract(nodes: Array<dynamic /* DocumentNode | PageNode | SliceNode | FrameNode | GroupNode | ComponentNode | InstanceNode | BooleanOperationNode | VectorNode | StarNode | LineNode | EllipseNode | PolygonNode | RectangleNode | TextNode */>, parent: PolygonNode, index: Number = definedExternally): BooleanOperationNode
    fun subtract(nodes: Array<dynamic /* DocumentNode | PageNode | SliceNode | FrameNode | GroupNode | ComponentNode | InstanceNode | BooleanOperationNode | VectorNode | StarNode | LineNode | EllipseNode | PolygonNode | RectangleNode | TextNode */>, parent: RectangleNode, index: Number = definedExternally): BooleanOperationNode
    fun subtract(nodes: Array<dynamic /* DocumentNode | PageNode | SliceNode | FrameNode | GroupNode | ComponentNode | InstanceNode | BooleanOperationNode | VectorNode | StarNode | LineNode | EllipseNode | PolygonNode | RectangleNode | TextNode */>, parent: TextNode, index: Number = definedExternally): BooleanOperationNode
    fun intersect(nodes: Array<dynamic /* DocumentNode | PageNode | SliceNode | FrameNode | GroupNode | ComponentNode | InstanceNode | BooleanOperationNode | VectorNode | StarNode | LineNode | EllipseNode | PolygonNode | RectangleNode | TextNode */>, parent: DocumentNode, index: Number = definedExternally): BooleanOperationNode
    fun intersect(nodes: Array<dynamic /* DocumentNode | PageNode | SliceNode | FrameNode | GroupNode | ComponentNode | InstanceNode | BooleanOperationNode | VectorNode | StarNode | LineNode | EllipseNode | PolygonNode | RectangleNode | TextNode */>, parent: PageNode, index: Number = definedExternally): BooleanOperationNode
    fun intersect(nodes: Array<dynamic /* DocumentNode | PageNode | SliceNode | FrameNode | GroupNode | ComponentNode | InstanceNode | BooleanOperationNode | VectorNode | StarNode | LineNode | EllipseNode | PolygonNode | RectangleNode | TextNode */>, parent: SliceNode, index: Number = definedExternally): BooleanOperationNode
    fun intersect(nodes: Array<dynamic /* DocumentNode | PageNode | SliceNode | FrameNode | GroupNode | ComponentNode | InstanceNode | BooleanOperationNode | VectorNode | StarNode | LineNode | EllipseNode | PolygonNode | RectangleNode | TextNode */>, parent: FrameNode, index: Number = definedExternally): BooleanOperationNode
    fun intersect(nodes: Array<dynamic /* DocumentNode | PageNode | SliceNode | FrameNode | GroupNode | ComponentNode | InstanceNode | BooleanOperationNode | VectorNode | StarNode | LineNode | EllipseNode | PolygonNode | RectangleNode | TextNode */>, parent: GroupNode, index: Number = definedExternally): BooleanOperationNode
    fun intersect(nodes: Array<dynamic /* DocumentNode | PageNode | SliceNode | FrameNode | GroupNode | ComponentNode | InstanceNode | BooleanOperationNode | VectorNode | StarNode | LineNode | EllipseNode | PolygonNode | RectangleNode | TextNode */>, parent: ComponentNode, index: Number = definedExternally): BooleanOperationNode
    fun intersect(nodes: Array<dynamic /* DocumentNode | PageNode | SliceNode | FrameNode | GroupNode | ComponentNode | InstanceNode | BooleanOperationNode | VectorNode | StarNode | LineNode | EllipseNode | PolygonNode | RectangleNode | TextNode */>, parent: InstanceNode, index: Number = definedExternally): BooleanOperationNode
    fun intersect(nodes: Array<dynamic /* DocumentNode | PageNode | SliceNode | FrameNode | GroupNode | ComponentNode | InstanceNode | BooleanOperationNode | VectorNode | StarNode | LineNode | EllipseNode | PolygonNode | RectangleNode | TextNode */>, parent: BooleanOperationNode, index: Number = definedExternally): BooleanOperationNode
    fun intersect(nodes: Array<dynamic /* DocumentNode | PageNode | SliceNode | FrameNode | GroupNode | ComponentNode | InstanceNode | BooleanOperationNode | VectorNode | StarNode | LineNode | EllipseNode | PolygonNode | RectangleNode | TextNode */>, parent: VectorNode, index: Number = definedExternally): BooleanOperationNode
    fun intersect(nodes: Array<dynamic /* DocumentNode | PageNode | SliceNode | FrameNode | GroupNode | ComponentNode | InstanceNode | BooleanOperationNode | VectorNode | StarNode | LineNode | EllipseNode | PolygonNode | RectangleNode | TextNode */>, parent: StarNode, index: Number = definedExternally): BooleanOperationNode
    fun intersect(nodes: Array<dynamic /* DocumentNode | PageNode | SliceNode | FrameNode | GroupNode | ComponentNode | InstanceNode | BooleanOperationNode | VectorNode | StarNode | LineNode | EllipseNode | PolygonNode | RectangleNode | TextNode */>, parent: LineNode, index: Number = definedExternally): BooleanOperationNode
    fun intersect(nodes: Array<dynamic /* DocumentNode | PageNode | SliceNode | FrameNode | GroupNode | ComponentNode | InstanceNode | BooleanOperationNode | VectorNode | StarNode | LineNode | EllipseNode | PolygonNode | RectangleNode | TextNode */>, parent: EllipseNode, index: Number = definedExternally): BooleanOperationNode
    fun intersect(nodes: Array<dynamic /* DocumentNode | PageNode | SliceNode | FrameNode | GroupNode | ComponentNode | InstanceNode | BooleanOperationNode | VectorNode | StarNode | LineNode | EllipseNode | PolygonNode | RectangleNode | TextNode */>, parent: PolygonNode, index: Number = definedExternally): BooleanOperationNode
    fun intersect(nodes: Array<dynamic /* DocumentNode | PageNode | SliceNode | FrameNode | GroupNode | ComponentNode | InstanceNode | BooleanOperationNode | VectorNode | StarNode | LineNode | EllipseNode | PolygonNode | RectangleNode | TextNode */>, parent: RectangleNode, index: Number = definedExternally): BooleanOperationNode
    fun intersect(nodes: Array<dynamic /* DocumentNode | PageNode | SliceNode | FrameNode | GroupNode | ComponentNode | InstanceNode | BooleanOperationNode | VectorNode | StarNode | LineNode | EllipseNode | PolygonNode | RectangleNode | TextNode */>, parent: TextNode, index: Number = definedExternally): BooleanOperationNode
    fun exclude(nodes: Array<dynamic /* DocumentNode | PageNode | SliceNode | FrameNode | GroupNode | ComponentNode | InstanceNode | BooleanOperationNode | VectorNode | StarNode | LineNode | EllipseNode | PolygonNode | RectangleNode | TextNode */>, parent: DocumentNode, index: Number = definedExternally): BooleanOperationNode
    fun exclude(nodes: Array<dynamic /* DocumentNode | PageNode | SliceNode | FrameNode | GroupNode | ComponentNode | InstanceNode | BooleanOperationNode | VectorNode | StarNode | LineNode | EllipseNode | PolygonNode | RectangleNode | TextNode */>, parent: PageNode, index: Number = definedExternally): BooleanOperationNode
    fun exclude(nodes: Array<dynamic /* DocumentNode | PageNode | SliceNode | FrameNode | GroupNode | ComponentNode | InstanceNode | BooleanOperationNode | VectorNode | StarNode | LineNode | EllipseNode | PolygonNode | RectangleNode | TextNode */>, parent: SliceNode, index: Number = definedExternally): BooleanOperationNode
    fun exclude(nodes: Array<dynamic /* DocumentNode | PageNode | SliceNode | FrameNode | GroupNode | ComponentNode | InstanceNode | BooleanOperationNode | VectorNode | StarNode | LineNode | EllipseNode | PolygonNode | RectangleNode | TextNode */>, parent: FrameNode, index: Number = definedExternally): BooleanOperationNode
    fun exclude(nodes: Array<dynamic /* DocumentNode | PageNode | SliceNode | FrameNode | GroupNode | ComponentNode | InstanceNode | BooleanOperationNode | VectorNode | StarNode | LineNode | EllipseNode | PolygonNode | RectangleNode | TextNode */>, parent: GroupNode, index: Number = definedExternally): BooleanOperationNode
    fun exclude(nodes: Array<dynamic /* DocumentNode | PageNode | SliceNode | FrameNode | GroupNode | ComponentNode | InstanceNode | BooleanOperationNode | VectorNode | StarNode | LineNode | EllipseNode | PolygonNode | RectangleNode | TextNode */>, parent: ComponentNode, index: Number = definedExternally): BooleanOperationNode
    fun exclude(nodes: Array<dynamic /* DocumentNode | PageNode | SliceNode | FrameNode | GroupNode | ComponentNode | InstanceNode | BooleanOperationNode | VectorNode | StarNode | LineNode | EllipseNode | PolygonNode | RectangleNode | TextNode */>, parent: InstanceNode, index: Number = definedExternally): BooleanOperationNode
    fun exclude(nodes: Array<dynamic /* DocumentNode | PageNode | SliceNode | FrameNode | GroupNode | ComponentNode | InstanceNode | BooleanOperationNode | VectorNode | StarNode | LineNode | EllipseNode | PolygonNode | RectangleNode | TextNode */>, parent: BooleanOperationNode, index: Number = definedExternally): BooleanOperationNode
    fun exclude(nodes: Array<dynamic /* DocumentNode | PageNode | SliceNode | FrameNode | GroupNode | ComponentNode | InstanceNode | BooleanOperationNode | VectorNode | StarNode | LineNode | EllipseNode | PolygonNode | RectangleNode | TextNode */>, parent: VectorNode, index: Number = definedExternally): BooleanOperationNode
    fun exclude(nodes: Array<dynamic /* DocumentNode | PageNode | SliceNode | FrameNode | GroupNode | ComponentNode | InstanceNode | BooleanOperationNode | VectorNode | StarNode | LineNode | EllipseNode | PolygonNode | RectangleNode | TextNode */>, parent: StarNode, index: Number = definedExternally): BooleanOperationNode
    fun exclude(nodes: Array<dynamic /* DocumentNode | PageNode | SliceNode | FrameNode | GroupNode | ComponentNode | InstanceNode | BooleanOperationNode | VectorNode | StarNode | LineNode | EllipseNode | PolygonNode | RectangleNode | TextNode */>, parent: LineNode, index: Number = definedExternally): BooleanOperationNode
    fun exclude(nodes: Array<dynamic /* DocumentNode | PageNode | SliceNode | FrameNode | GroupNode | ComponentNode | InstanceNode | BooleanOperationNode | VectorNode | StarNode | LineNode | EllipseNode | PolygonNode | RectangleNode | TextNode */>, parent: EllipseNode, index: Number = definedExternally): BooleanOperationNode
    fun exclude(nodes: Array<dynamic /* DocumentNode | PageNode | SliceNode | FrameNode | GroupNode | ComponentNode | InstanceNode | BooleanOperationNode | VectorNode | StarNode | LineNode | EllipseNode | PolygonNode | RectangleNode | TextNode */>, parent: PolygonNode, index: Number = definedExternally): BooleanOperationNode
    fun exclude(nodes: Array<dynamic /* DocumentNode | PageNode | SliceNode | FrameNode | GroupNode | ComponentNode | InstanceNode | BooleanOperationNode | VectorNode | StarNode | LineNode | EllipseNode | PolygonNode | RectangleNode | TextNode */>, parent: RectangleNode, index: Number = definedExternally): BooleanOperationNode
    fun exclude(nodes: Array<dynamic /* DocumentNode | PageNode | SliceNode | FrameNode | GroupNode | ComponentNode | InstanceNode | BooleanOperationNode | VectorNode | StarNode | LineNode | EllipseNode | PolygonNode | RectangleNode | TextNode */>, parent: TextNode, index: Number = definedExternally): BooleanOperationNode
    fun flatten(nodes: Array<dynamic /* DocumentNode | PageNode | SliceNode | FrameNode | GroupNode | ComponentNode | InstanceNode | BooleanOperationNode | VectorNode | StarNode | LineNode | EllipseNode | PolygonNode | RectangleNode | TextNode */>): VectorNode
}

external interface ClientStorageAPI {
    fun getAsync(key: String): Promise<Any?>
    fun setAsync(key: String, value: Any): Promise<Unit>
}

external interface NotificationHandler {
    var cancel: () -> Unit
}

external interface ShowUIOptions {
    var visible: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var width: Number?
        get() = definedExternally
        set(value) = definedExternally
    var height: Number?
        get() = definedExternally
        set(value) = definedExternally
}

external interface UIPostMessageOptions {
    var origin: String?
        get() = definedExternally
        set(value) = definedExternally
}

external interface OnMessageProperties {
    var origin: String
}

external interface UIAPI {
    fun show()
    fun hide()
    fun resize(width: Number, height: Number)
    fun close()
    fun postMessage(pluginMessage: Any, options: UIPostMessageOptions = definedExternally)
    var onmessage: MessageEventHandler?
        get() = definedExternally
        set(value) = definedExternally
    fun on(type: String /* "message" */, callback: MessageEventHandler)
    fun once(type: String /* "message" */, callback: MessageEventHandler)
    fun off(type: String /* "message" */, callback: MessageEventHandler)
}

external interface ViewportAPI {
    var center: Vector
    var zoom: Number
    fun scrollAndZoomIntoView(nodes: Array<dynamic /* DocumentNode | PageNode | SliceNode | FrameNode | GroupNode | ComponentNode | InstanceNode | BooleanOperationNode | VectorNode | StarNode | LineNode | EllipseNode | PolygonNode | RectangleNode | TextNode */>)
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
        get() = definedExternally
        set(value) = definedExternally
    var contrast: Number?
        get() = definedExternally
        set(value) = definedExternally
    var saturation: Number?
        get() = definedExternally
        set(value) = definedExternally
    var temperature: Number?
        get() = definedExternally
        set(value) = definedExternally
    var tint: Number?
        get() = definedExternally
        set(value) = definedExternally
    var highlights: Number?
        get() = definedExternally
        set(value) = definedExternally
    var shadows: Number?
        get() = definedExternally
        set(value) = definedExternally
}

external interface SolidPaint {
    var type: String /* "SOLID" */
    var color: RGB
    var visible: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var opacity: Number?
        get() = definedExternally
        set(value) = definedExternally
    var blendMode: String /* "PASS_THROUGH" | "NORMAL" | "DARKEN" | "MULTIPLY" | "LINEAR_BURN" | "COLOR_BURN" | "LIGHTEN" | "SCREEN" | "LINEAR_DODGE" | "COLOR_DODGE" | "OVERLAY" | "SOFT_LIGHT" | "HARD_LIGHT" | "DIFFERENCE" | "EXCLUSION" | "HUE" | "SATURATION" | "COLOR" | "LUMINOSITY" */
}

external interface GradientPaint {
    var type: String /* "GRADIENT_LINEAR" | "GRADIENT_RADIAL" | "GRADIENT_ANGULAR" | "GRADIENT_DIAMOND" */
    var gradientTransform: dynamic /* JsTuple<dynamic, dynamic> */
        get() = definedExternally
        set(value) = definedExternally
    var gradientStops: Array<ColorStop>
    var visible: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var opacity: Number?
        get() = definedExternally
        set(value) = definedExternally
    var blendMode: String /* "PASS_THROUGH" | "NORMAL" | "DARKEN" | "MULTIPLY" | "LINEAR_BURN" | "COLOR_BURN" | "LIGHTEN" | "SCREEN" | "LINEAR_DODGE" | "COLOR_DODGE" | "OVERLAY" | "SOFT_LIGHT" | "HARD_LIGHT" | "DIFFERENCE" | "EXCLUSION" | "HUE" | "SATURATION" | "COLOR" | "LUMINOSITY" */
}

external interface ImagePaint {
    var type: String /* "IMAGE" */
    var scaleMode: String /* "FILL" | "FIT" | "CROP" | "TILE" */
    var imageHash: String?
        get() = definedExternally
        set(value) = definedExternally
    var imageTransform: dynamic /* JsTuple<dynamic, dynamic> */
        get() = definedExternally
        set(value) = definedExternally
    var scalingFactor: Number?
        get() = definedExternally
        set(value) = definedExternally
    var filters: ImageFilters?
        get() = definedExternally
        set(value) = definedExternally
    var visible: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var opacity: Number?
        get() = definedExternally
        set(value) = definedExternally
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
        get() = definedExternally
        set(value) = definedExternally
    var offset: Number?
        get() = definedExternally
        set(value) = definedExternally
    var visible: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var color: RGBA?
        get() = definedExternally
        set(value) = definedExternally
}

external interface GridLayoutGrid {
    var pattern: String /* "GRID" */
    var sectionSize: Number
    var visible: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var color: RGBA?
        get() = definedExternally
        set(value) = definedExternally
}

external interface ExportSettingsConstraints {
    var type: String /* "SCALE" | "WIDTH" | "HEIGHT" */
    var value: Number
}

external interface ExportSettingsImage {
    var format: String /* "JPG" | "PNG" */
    var contentsOnly: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var suffix: String?
        get() = definedExternally
        set(value) = definedExternally
    var constraint: ExportSettingsConstraints?
        get() = definedExternally
        set(value) = definedExternally
}

external interface ExportSettingsSVG {
    var format: String /* "SVG" */
    var contentsOnly: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var suffix: String?
        get() = definedExternally
        set(value) = definedExternally
    var svgOutlineText: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var svgIdAttribute: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var svgSimplifyStroke: Boolean?
        get() = definedExternally
        set(value) = definedExternally
}

external interface ExportSettingsPDF {
    var format: String /* "PDF" */
    var contentsOnly: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var suffix: String?
        get() = definedExternally
        set(value) = definedExternally
}

external interface VectorVertex {
    var x: Number
    var y: Number
    var strokeCap: String /* "NONE" | "ROUND" | "SQUARE" | "ARROW_LINES" | "ARROW_EQUILATERAL" */
    var strokeJoin: String /* "MITER" | "BEVEL" | "ROUND" */
    var cornerRadius: Number?
        get() = definedExternally
        set(value) = definedExternally
    var handleMirroring: String /* "NONE" | "ANGLE" | "ANGLE_AND_LENGTH" */
}

external interface VectorSegment {
    var start: Number
    var end: Number
    var tangentStart: Vector?
        get() = definedExternally
        set(value) = definedExternally
    var tangentEnd: Vector?
        get() = definedExternally
        set(value) = definedExternally
}

external interface VectorRegion {
    var windingRule: String /* "NONZERO" | "EVENODD" */
    var loops: Array<Array<Number>>
}

external interface VectorNetwork {
    var vertices: Array<VectorVertex>
    var segments: Array<VectorSegment>
    var regions: Array<VectorRegion>?
        get() = definedExternally
        set(value) = definedExternally
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
        get() = definedExternally
        set(value) = definedExternally
    var trigger: dynamic /* `T$7` | `T$8` | `T$9` */
        get() = definedExternally
        set(value) = definedExternally
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
        get() = definedExternally
        set(value) = definedExternally
    var navigation: String /* "NAVIGATE" | "SWAP" | "OVERLAY" */
    var transition: dynamic /* SimpleTransition | DirectionalTransition */
        get() = definedExternally
        set(value) = definedExternally
    var preserveScrollPosition: Boolean
    var overlayRelativePosition: Vector?
        get() = definedExternally
        set(value) = definedExternally
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
    @nativeGetter
    operator fun get(command: String): String?
    @nativeSetter
    operator fun set(command: String, value: String)
}

external interface BaseNodeMixin {
    var id: String
    var parent: dynamic /* DocumentNode | PageNode | SliceNode | FrameNode | GroupNode | ComponentNode | InstanceNode | BooleanOperationNode | VectorNode | StarNode | LineNode | EllipseNode | PolygonNode | RectangleNode | TextNode */
        get() = definedExternally
        set(value) = definedExternally
    var name: String
    var removed: Boolean
    override fun toString(): String
    fun remove()
    fun getPluginData(key: String): String
    fun setPluginData(key: String, value: String)
    fun getSharedPluginData(namespace: String, key: String): String
    fun setSharedPluginData(namespace: String, key: String, value: String)
    fun setRelaunchData(data: `T$0`)
}

external interface SceneNodeMixin {
    var visible: Boolean
    var locked: Boolean
}

external interface ChildrenMixin {
    var children: Array<dynamic /* SliceNode | FrameNode | GroupNode | ComponentNode | InstanceNode | BooleanOperationNode | VectorNode | StarNode | LineNode | EllipseNode | PolygonNode | RectangleNode | TextNode */>
    fun appendChild(child: SliceNode)
    fun appendChild(child: FrameNode)
    fun appendChild(child: GroupNode)
    fun appendChild(child: ComponentNode)
    fun appendChild(child: InstanceNode)
    fun appendChild(child: BooleanOperationNode)
    fun appendChild(child: VectorNode)
    fun appendChild(child: StarNode)
    fun appendChild(child: LineNode)
    fun appendChild(child: EllipseNode)
    fun appendChild(child: PolygonNode)
    fun appendChild(child: RectangleNode)
    fun appendChild(child: TextNode)
    fun insertChild(index: Number, child: SliceNode)
    fun insertChild(index: Number, child: FrameNode)
    fun insertChild(index: Number, child: GroupNode)
    fun insertChild(index: Number, child: ComponentNode)
    fun insertChild(index: Number, child: InstanceNode)
    fun insertChild(index: Number, child: BooleanOperationNode)
    fun insertChild(index: Number, child: VectorNode)
    fun insertChild(index: Number, child: StarNode)
    fun insertChild(index: Number, child: LineNode)
    fun insertChild(index: Number, child: EllipseNode)
    fun insertChild(index: Number, child: PolygonNode)
    fun insertChild(index: Number, child: RectangleNode)
    fun insertChild(index: Number, child: TextNode)
    fun findChildren(callback: (node: dynamic /* SliceNode | FrameNode | GroupNode | ComponentNode | InstanceNode | BooleanOperationNode | VectorNode | StarNode | LineNode | EllipseNode | PolygonNode | RectangleNode | TextNode */) -> Boolean = definedExternally): Array<dynamic /* SliceNode | FrameNode | GroupNode | ComponentNode | InstanceNode | BooleanOperationNode | VectorNode | StarNode | LineNode | EllipseNode | PolygonNode | RectangleNode | TextNode */>
    fun findChild(callback: (node: dynamic /* SliceNode | FrameNode | GroupNode | ComponentNode | InstanceNode | BooleanOperationNode | VectorNode | StarNode | LineNode | EllipseNode | PolygonNode | RectangleNode | TextNode */) -> Boolean): dynamic /* SliceNode | FrameNode | GroupNode | ComponentNode | InstanceNode | BooleanOperationNode | VectorNode | StarNode | LineNode | EllipseNode | PolygonNode | RectangleNode | TextNode */
    fun findAll(callback: (node: dynamic /* SliceNode | FrameNode | GroupNode | ComponentNode | InstanceNode | BooleanOperationNode | VectorNode | StarNode | LineNode | EllipseNode | PolygonNode | RectangleNode | TextNode */) -> Boolean = definedExternally): Array<dynamic /* SliceNode | FrameNode | GroupNode | ComponentNode | InstanceNode | BooleanOperationNode | VectorNode | StarNode | LineNode | EllipseNode | PolygonNode | RectangleNode | TextNode */>
    fun findOne(callback: (node: dynamic /* SliceNode | FrameNode | GroupNode | ComponentNode | InstanceNode | BooleanOperationNode | VectorNode | StarNode | LineNode | EllipseNode | PolygonNode | RectangleNode | TextNode */) -> Boolean): dynamic /* SliceNode | FrameNode | GroupNode | ComponentNode | InstanceNode | BooleanOperationNode | VectorNode | StarNode | LineNode | EllipseNode | PolygonNode | RectangleNode | TextNode */
}

external interface ConstraintMixin {
    var constraints: Constraints
}

external interface LayoutMixin {
    var absoluteTransform: dynamic /* JsTuple<dynamic, dynamic> */
        get() = definedExternally
        set(value) = definedExternally
    var relativeTransform: dynamic /* JsTuple<dynamic, dynamic> */
        get() = definedExternally
        set(value) = definedExternally
    var x: Number
    var y: Number
    var rotation: Number
    var width: Number
    var height: Number
    var constrainProportions: Boolean
    var layoutAlign: String /* "MIN" | "CENTER" | "MAX" | "STRETCH" */
    fun resize(width: Number, height: Number)
    fun resizeWithoutConstraints(width: Number, height: Number)
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
        get() = definedExternally
        set(value) = definedExternally
    var strokes: Array<dynamic /* SolidPaint | GradientPaint | ImagePaint */>
    var strokeWeight: Number
    var strokeMiterLimit: Number
    var strokeAlign: String /* "CENTER" | "INSIDE" | "OUTSIDE" */
    var strokeCap: dynamic /* "NONE" | "ROUND" | "SQUARE" | "ARROW_LINES" | "ARROW_EQUILATERAL" | Any */
        get() = definedExternally
        set(value) = definedExternally
    var strokeJoin: dynamic /* "MITER" | "BEVEL" | "ROUND" | Any */
        get() = definedExternally
        set(value) = definedExternally
    var dashPattern: Array<Number>
    var fillStyleId: dynamic /* String | Any */
        get() = definedExternally
        set(value) = definedExternally
    var strokeStyleId: String
    fun outlineStroke(): VectorNode?
}

external interface CornerMixin {
    var cornerRadius: dynamic /* Number | Any */
        get() = definedExternally
        set(value) = definedExternally
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
    fun exportAsync(settings: ExportSettingsImage = definedExternally): Promise<Uint8Array>
    fun exportAsync(settings: ExportSettingsSVG = definedExternally): Promise<Uint8Array>
    fun exportAsync(settings: ExportSettingsPDF = definedExternally): Promise<Uint8Array>
    fun exportAsync(): Promise<Uint8Array>
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
        get() = definedExternally
        set(value) = definedExternally
    var overlayBackgroundInteraction: String /* "NONE" | "CLOSE_ON_CLICK_OUTSIDE" */
}

external interface DocumentNode : BaseNodeMixin {
    var type: String /* "DOCUMENT" */
    var children: Array<PageNode>
    fun appendChild(child: PageNode)
    fun insertChild(index: Number, child: PageNode)
    fun findChildren(callback: (node: PageNode) -> Boolean = definedExternally): Array<PageNode>
    fun findChild(callback: (node: PageNode) -> Boolean): PageNode?
    fun findAll(callback: (node: dynamic /* PageNode | SliceNode | FrameNode | GroupNode | ComponentNode | InstanceNode | BooleanOperationNode | VectorNode | StarNode | LineNode | EllipseNode | PolygonNode | RectangleNode | TextNode */) -> Boolean = definedExternally): Array<dynamic /* PageNode | SliceNode | FrameNode | GroupNode | ComponentNode | InstanceNode | BooleanOperationNode | VectorNode | StarNode | LineNode | EllipseNode | PolygonNode | RectangleNode | TextNode */>
    fun findOne(callback: (node: dynamic /* PageNode | SliceNode | FrameNode | GroupNode | ComponentNode | InstanceNode | BooleanOperationNode | VectorNode | StarNode | LineNode | EllipseNode | PolygonNode | RectangleNode | TextNode */) -> Boolean): dynamic /* PageNode | SliceNode | FrameNode | GroupNode | ComponentNode | InstanceNode | BooleanOperationNode | VectorNode | StarNode | LineNode | EllipseNode | PolygonNode | RectangleNode | TextNode | Nothing? */
}

external interface `T$1` {
    var node: TextNode
    var start: Number
    var end: Number
}

external interface PageNode : BaseNodeMixin, ChildrenMixin, ExportMixin {
    var type: String /* "PAGE" */
    fun clone(): PageNode
    var guides: Array<Guide>
    var selection: Array<dynamic /* SliceNode | FrameNode | GroupNode | ComponentNode | InstanceNode | BooleanOperationNode | VectorNode | StarNode | LineNode | EllipseNode | PolygonNode | RectangleNode | TextNode */>
    var selectedTextRange: dynamic /* `T$1` | Nothing? */
        get() = definedExternally
        set(value) = definedExternally
    var backgrounds: Array<dynamic /* SolidPaint | GradientPaint | ImagePaint */>
    var prototypeStartNode: dynamic /* FrameNode | GroupNode | ComponentNode | InstanceNode | Nothing? */
        get() = definedExternally
        set(value) = definedExternally
}

external interface FrameNode : DefaultFrameMixin {
    var type: String /* "FRAME" */
    fun clone(): FrameNode
}

external interface GroupNode : BaseNodeMixin, SceneNodeMixin, ReactionMixin, ChildrenMixin, ContainerMixin, BlendMixin, LayoutMixin, ExportMixin {
    var type: String /* "GROUP" */
    fun clone(): GroupNode
}

external interface SliceNode : BaseNodeMixin, SceneNodeMixin, LayoutMixin, ExportMixin {
    var type: String /* "SLICE" */
    fun clone(): SliceNode
}

external interface RectangleNode : DefaultShapeMixin, ConstraintMixin, CornerMixin, RectangleCornerMixin {
    var type: String /* "RECTANGLE" */
    fun clone(): RectangleNode
}

external interface LineNode : DefaultShapeMixin, ConstraintMixin {
    var type: String /* "LINE" */
    fun clone(): LineNode
}

external interface EllipseNode : DefaultShapeMixin, ConstraintMixin, CornerMixin {
    var type: String /* "ELLIPSE" */
    fun clone(): EllipseNode
    var arcData: ArcData
}

external interface PolygonNode : DefaultShapeMixin, ConstraintMixin, CornerMixin {
    var type: String /* "POLYGON" */
    fun clone(): PolygonNode
    var pointCount: Number
}

external interface StarNode : DefaultShapeMixin, ConstraintMixin, CornerMixin {
    var type: String /* "STAR" */
    fun clone(): StarNode
    var pointCount: Number
    var innerRadius: Number
}

external interface VectorNode : DefaultShapeMixin, ConstraintMixin, CornerMixin {
    var type: String /* "VECTOR" */
    fun clone(): VectorNode
    var vectorNetwork: VectorNetwork
    var vectorPaths: VectorPaths
    var handleMirroring: dynamic /* "NONE" | "ANGLE" | "ANGLE_AND_LENGTH" | Any */
        get() = definedExternally
        set(value) = definedExternally
}

external interface TextNode : DefaultShapeMixin, ConstraintMixin {
    var type: String /* "TEXT" */
    fun clone(): TextNode
    var hasMissingFont: Boolean
    var textAlignHorizontal: String /* "LEFT" | "CENTER" | "RIGHT" | "JUSTIFIED" */
    var textAlignVertical: String /* "TOP" | "CENTER" | "BOTTOM" */
    var textAutoResize: String /* "NONE" | "WIDTH_AND_HEIGHT" | "HEIGHT" */
    var paragraphIndent: Number
    var paragraphSpacing: Number
    var autoRename: Boolean
    var textStyleId: dynamic /* String | Any */
        get() = definedExternally
        set(value) = definedExternally
    var fontSize: dynamic /* Number | Any */
        get() = definedExternally
        set(value) = definedExternally
    var fontName: dynamic /* FontName | Any */
        get() = definedExternally
        set(value) = definedExternally
    var textCase: dynamic /* "ORIGINAL" | "UPPER" | "LOWER" | "TITLE" | Any */
        get() = definedExternally
        set(value) = definedExternally
    var textDecoration: dynamic /* "NONE" | "UNDERLINE" | "STRIKETHROUGH" | Any */
        get() = definedExternally
        set(value) = definedExternally
    var letterSpacing: dynamic /* LetterSpacing | Any */
        get() = definedExternally
        set(value) = definedExternally
    var lineHeight: dynamic /* `T$2` | `T$3` | Any */
        get() = definedExternally
        set(value) = definedExternally
    var characters: String
    fun insertCharacters(start: Number, characters: String, useStyle: String = definedExternally)
    fun deleteCharacters(start: Number, end: Number)
    fun getRangeFontSize(start: Number, end: Number): dynamic /* Number | Any */
    fun setRangeFontSize(start: Number, end: Number, value: Number)
    fun getRangeFontName(start: Number, end: Number): dynamic /* FontName | Any */
    fun setRangeFontName(start: Number, end: Number, value: FontName)
    fun getRangeTextCase(start: Number, end: Number): dynamic /* "ORIGINAL" | "UPPER" | "LOWER" | "TITLE" | Any */
    fun setRangeTextCase(start: Number, end: Number, value: String)
    fun getRangeTextDecoration(start: Number, end: Number): dynamic /* "NONE" | "UNDERLINE" | "STRIKETHROUGH" | Any */
    fun setRangeTextDecoration(start: Number, end: Number, value: String)
    fun getRangeLetterSpacing(start: Number, end: Number): dynamic /* LetterSpacing | Any */
    fun setRangeLetterSpacing(start: Number, end: Number, value: LetterSpacing)
    fun getRangeLineHeight(start: Number, end: Number): dynamic /* `T$2` | `T$3` | Any */
    fun setRangeLineHeight(start: Number, end: Number, value: `T$2`)
    fun setRangeLineHeight(start: Number, end: Number, value: `T$3`)
    fun getRangeFills(start: Number, end: Number): dynamic /* Array<dynamic /* SolidPaint | GradientPaint | ImagePaint */> | Any */
    fun setRangeFills(start: Number, end: Number, value: Array<dynamic /* SolidPaint | GradientPaint | ImagePaint */>)
    fun getRangeTextStyleId(start: Number, end: Number): dynamic /* String | Any */
    fun setRangeTextStyleId(start: Number, end: Number, value: String)
    fun getRangeFillStyleId(start: Number, end: Number): dynamic /* String | Any */
    fun setRangeFillStyleId(start: Number, end: Number, value: String)
    fun insertCharacters(start: Number, characters: String)
}

external interface ComponentNode : DefaultFrameMixin {
    var type: String /* "COMPONENT" */
    fun clone(): ComponentNode
    fun createInstance(): InstanceNode
    var description: String
    var remote: Boolean
    var key: String
}

external interface InstanceNode : DefaultFrameMixin {
    var type: String /* "INSTANCE" */
    fun clone(): InstanceNode
    var masterComponent: ComponentNode
    var scaleFactor: Number
}

external interface BooleanOperationNode : DefaultShapeMixin, ChildrenMixin, CornerMixin {
    var type: String /* "BOOLEAN_OPERATION" */
    fun clone(): BooleanOperationNode
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
    fun remove()
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
        get() = definedExternally
        set(value) = definedExternally
    var paragraphIndent: Number
    var paragraphSpacing: Number
    var textCase: String /* "ORIGINAL" | "UPPER" | "LOWER" | "TITLE" */
}

external interface EffectStyle : BaseStyle {
    var type: String /* "EFFECT" */
    var effects: Array<dynamic /* ShadowEffect | BlurEffect */>
}

external interface GridStyle : BaseStyle {
    var type: String /* "GRID" */
    var layoutGrids: Array<dynamic /* RowsColsLayoutGrid | GridLayoutGrid */>
}
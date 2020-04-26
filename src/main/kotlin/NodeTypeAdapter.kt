import com.beust.klaxon.TypeAdapter
import kotlin.reflect.KClass

class NodeTypeAdapter : TypeAdapter<BaseNodeMixin> {
    override fun classFor(type: Any): KClass<out BaseNodeMixin> = when (type as String) {
        "FRAME" -> FrameNode::class
        "COMPONENT" -> ComponentNode::class
        "VECTOR" -> VectorNode::class
        "INSTANCE" -> InstanceNode::class
        "GROUP" -> GroupNodeImpl::class
        "TEXT" -> TextNode::class
        "RECTANGLE" -> RectangleNode::class
        else -> BaseNodeMixinImpl::class
    }
}

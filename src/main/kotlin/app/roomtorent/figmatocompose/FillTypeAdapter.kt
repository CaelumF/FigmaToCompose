package app.roomtorent.figmatocompose

import GradientPaint
import ImagePaint
import Paint
import SolidPaint
import com.beust.klaxon.TypeAdapter
import kotlin.reflect.KClass

class FillTypeAdapter : TypeAdapter<Paint> {
    override fun classFor(type: Any): KClass<out Paint> = when (type as String) {

        "SOLID" -> SolidPaint::class
        "GRADIENT_LINEAR" -> GradientPaint::class
        "GRADIENT_RADIAL" -> GradientPaint::class
        "GRADIENT_ANGULAR" -> GradientPaint::class
        "GRADIENT_DIAMOND" -> GradientPaint::class
        "IMAGE" -> ImagePaint::class
        "EMOJI" -> ImagePaint::class

        else -> throw Exception("Unknown paint type $type")
    }
}

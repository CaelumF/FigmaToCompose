package app.roomtorent.figmatocompose

import Effect
import ShadowEffect
import com.beust.klaxon.TypeAdapter
import kotlin.reflect.KClass

class EffectAdapter : TypeAdapter<Effect> {
    override fun classFor(type: Any): KClass<out Effect> = when (type as String) {
        "DROP_SHADOW" -> ShadowEffect::class
        "INNER_SHADOW" -> {
            println("Warning! INNER_SHADOW wil be treated the same as DROP_SHADOW")
            ShadowEffect::class
        }
        else -> throw Exception("Unknown paint type $type")
    }
}

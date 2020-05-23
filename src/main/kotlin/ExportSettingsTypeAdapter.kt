import com.beust.klaxon.TypeAdapter
import java.lang.Exception
import kotlin.reflect.KClass

class ExportSettingsTypeAdapter : TypeAdapter<ExportSettings> {
    override fun classFor(format: Any): KClass<out ExportSettings> = when (format as String) {
        "PNG",
        "JPG" -> ExportSettingsImage::class
        "SVG" -> ExportSettingsSVG::class
        "PDF" -> ExportSettingsPDF::class
        else -> throw Exception("Type adapter $format must be new")
    }
}

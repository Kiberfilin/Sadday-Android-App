package ru.cyber_eagle_owl.saddayappkt.clean.data.entities.data.attachments.doc.preview

import ru.cyber_eagle_owl.saddayappkt.constants.VkConstants
import org.json.JSONObject
import timber.log.Timber

class PreviewGraffiti(
    var src: String?,
    var width: Long?,
    var height: Long?
) {
    companion object {

        fun parse(jsonObject: JSONObject?): PreviewGraffiti? {
            Timber.d("Парсим ${PreviewGraffiti::class.java.simpleName} Получили такой JSONObject $jsonObject")

            return if (jsonObject != null) {
                PreviewGraffiti(
                    jsonObject.optString(VkConstants.VKAPI_CONST_SRC),
                    jsonObject.optLong(VkConstants.VKAPI_CONST_WIDTH),
                    jsonObject.optLong(VkConstants.VKAPI_CONST_HEIGHT)
                )
            } else {
                null
            }
        }
    }
}

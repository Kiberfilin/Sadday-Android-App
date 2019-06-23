package ru.cyber_eagle_owl.saddayappkt.clean.data.entities.data.attachments.doc

import ru.cyber_eagle_owl.saddayappkt.constants.VkConstants
import org.json.JSONObject
import timber.log.Timber
import ru.cyber_eagle_owl.saddayappkt.clean.data.entities.data.attachments.Attachable
import ru.cyber_eagle_owl.saddayappkt.clean.data.entities.data.attachments.doc.preview.Preview

class Doc(
          var id: Long?,
          var ownerId: Long?,
          var title: String?,
          var size: Long?,
          var ext: String?,
          var url: String?,
          var date: Long?,
          var type: Int?,
          var preview: Preview?) : Attachable {

    companion object {

        fun parse(jsonObject: JSONObject?): Doc? {
            Timber.d("Парсим ${Doc::class.java.simpleName} Получили такой JSONObject $jsonObject")

            return if (jsonObject != null) {
                Doc(jsonObject.optLong(VkConstants.VKAPI_CONST_ID),
                        jsonObject.optLong(VkConstants.VKAPI_CONST_OWNER_ID),
                        jsonObject.optString(VkConstants.VKAPI_CONST_TITLE),
                        jsonObject.optLong(VkConstants.VKAPI_CONST_SIZE),
                        jsonObject.optString(VkConstants.VKAPI_CONST_EXT),
                        jsonObject.optString(VkConstants.VKAPI_CONST_URL),
                        jsonObject.optLong(VkConstants.VKAPI_CONST_DATE),
                        jsonObject.optInt(VkConstants.VKAPI_CONST_TYPE),
                        Preview.parse(jsonObject.optJSONObject(VkConstants.VKAPI_CONST_PREVIEW)))
            } else {
                null
            }
        }
    }
}

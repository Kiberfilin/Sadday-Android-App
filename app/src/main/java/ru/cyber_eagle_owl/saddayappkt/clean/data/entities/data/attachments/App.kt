package ru.cyber_eagle_owl.saddayappkt.clean.data.entities.data.attachments

import ru.cyber_eagle_owl.saddayappkt.constants.VkConstants
import org.json.JSONObject
import timber.log.Timber

class App(
    var id: Long?,
    var name: String?,
    var photo130: String?,
    var photo604: String?
) : Attachable {

    companion object {

        fun parse(jsonObject: JSONObject?): App? {
            Timber.d("Парсим ${App::class.java.simpleName} Получили такой JSONObject $jsonObject")

            return if (jsonObject != null) {
                App(
                    jsonObject.optLong(VkConstants.VKAPI_CONST_ID),
                    jsonObject.optString(VkConstants.VKAPI_CONST_NAME),
                    jsonObject.optString(VkConstants.VKAPI_CONST_PHOTO_130),
                    jsonObject.optString(VkConstants.VKAPI_CONST_PHOTO_604)
                )
            } else {
                null
            }
        }
    }
}

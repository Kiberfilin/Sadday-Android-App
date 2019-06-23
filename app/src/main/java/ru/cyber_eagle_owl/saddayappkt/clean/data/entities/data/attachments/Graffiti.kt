package ru.cyber_eagle_owl.saddayappkt.clean.data.entities.data.attachments

import ru.cyber_eagle_owl.saddayappkt.constants.VkConstants
import org.json.JSONObject
import timber.log.Timber

class Graffiti(
    var id: Long?,
    var ownerId: Long?,
    var photo130: String?,
    var photo604: String?
) : Attachable {

    companion object {

        fun parse(jsonObject: JSONObject?): Graffiti? {
            Timber.d("Парсим ${Graffiti::class.java.simpleName} Получили такой JSONObject $jsonObject")

            return if (jsonObject != null) {
                Graffiti(
                    jsonObject.optLong(VkConstants.VKAPI_CONST_ID),
                    jsonObject.optLong(VkConstants.VKAPI_CONST_OWNER_ID),
                    jsonObject.optString(VkConstants.VKAPI_CONST_PHOTO_130),
                    jsonObject.optString(VkConstants.VKAPI_CONST_PHOTO_604)
                )
            } else {
                null
            }
        }
    }
}

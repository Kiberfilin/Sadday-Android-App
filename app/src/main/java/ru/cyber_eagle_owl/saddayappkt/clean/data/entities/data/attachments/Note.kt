package ru.cyber_eagle_owl.saddayappkt.clean.data.entities.data.attachments

import ru.cyber_eagle_owl.saddayappkt.constants.VkConstants
import org.json.JSONObject
import timber.log.Timber

class Note(
    var id: Long?,
    var ownerId: Long?,
    var title: String?,
    var text: String?,
    var date: Long?,
    var comments: Long?,
    var readComments: Long?,
    var viewUrl: String?
) : Attachable {

    companion object {

        fun parse(jsonObject: JSONObject?): Note? {
            Timber.d("Парсим ${Note::class.java.simpleName} Получили такой JSONObject $jsonObject")

            return if (jsonObject != null) {
                Note(
                    jsonObject.optLong(VkConstants.VKAPI_CONST_ID),
                    jsonObject.optLong(VkConstants.VKAPI_CONST_OWNER_ID),
                    jsonObject.optString(VkConstants.VKAPI_CONST_TITLE),
                    jsonObject.optString(VkConstants.VKAPI_CONST_TEXT),
                    jsonObject.optLong(VkConstants.VKAPI_CONST_DATE),
                    jsonObject.optLong(VkConstants.VKAPI_CONST_COMMENTS),
                    jsonObject.optLong(VkConstants.VKAPI_CONST_READ_COMMENTS),
                    jsonObject.optString(VkConstants.VKAPI_CONST_VIEW_URL)
                )
            } else {
                null
            }
        }
    }
}

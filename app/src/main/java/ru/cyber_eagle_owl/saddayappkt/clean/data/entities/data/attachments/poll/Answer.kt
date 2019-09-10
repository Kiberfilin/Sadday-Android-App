package ru.cyber_eagle_owl.saddayappkt.clean.data.entities.data.attachments.poll

import org.json.JSONObject
import ru.cyber_eagle_owl.saddayappkt.constants.VkConstants
import timber.log.Timber

class Answer(
    var id: Long?,
    var text: String?,
    var votes: Long?,
    var rate: String?
) {

    companion object {

        fun parse(jsonObject: JSONObject?): Answer? {
            Timber.d("Парсим ${Answer::class.java.simpleName} Получили такой JSONObject $jsonObject")

            return if (jsonObject != null) {
                Answer(
                    jsonObject.optLong(VkConstants.VKAPI_CONST_ID),
                    jsonObject.optString(VkConstants.VKAPI_CONST_TEXT),
                    jsonObject.optLong(VkConstants.VKAPI_CONST_VOTES),
                    jsonObject.optString(VkConstants.VKAPI_CONST_RATE)
                )
            } else {
                null
            }
        }
    }
}

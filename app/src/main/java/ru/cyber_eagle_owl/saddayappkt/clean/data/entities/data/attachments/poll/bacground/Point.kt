package ru.cyber_eagle_owl.saddayappkt.clean.data.entities.data.attachments.poll.bacground

import org.json.JSONObject
import ru.cyber_eagle_owl.saddayappkt.constants.VkConstants
import timber.log.Timber

class Point(var position: String?, var color: String?) {

    companion object {

        fun parse(jsonObject: JSONObject?): Point? {
            Timber.d("Парсим ${Point::class.java.simpleName} Получили такой JSONObject $jsonObject")

            return if (jsonObject != null) {
                Point(
                    jsonObject.optString(VkConstants.VKAPI_CONST_POSITION),
                    jsonObject.optString(VkConstants.VKAPI_CONST_COLOR)
                )
            } else {
                null
            }
        }
    }
}

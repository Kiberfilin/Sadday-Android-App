package ru.cyber_eagle_owl.saddayappkt.clean.data.entities.data

import ru.cyber_eagle_owl.saddayappkt.constants.VkConstants
import org.json.JSONObject
import timber.log.Timber

class Likes(var count: Long?, var userLikes: Int?, var canLike: Int?, var canPublish: Int?) {

    companion object {

        fun parse(jsonObject: JSONObject?): Likes? {
            Timber.d("Парсим ${Likes::class.java.simpleName} Получили такой JSONObject $jsonObject")

            return if (jsonObject != null) {
                Likes(
                    jsonObject.optLong(VkConstants.VKAPI_CONST_COUNT),
                    jsonObject.optInt(VkConstants.VKAPI_CONST_USER_LIKES),
                    jsonObject.optInt(VkConstants.VKAPI_CONST_CAN_LIKE),
                    jsonObject.optInt(VkConstants.VKAPI_CONST_CAN_PUBLISH)
                )
            } else {
                null
            }
        }
    }
}

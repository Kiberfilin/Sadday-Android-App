package ru.cyber_eagle_owl.saddayappkt.clean.data.entities.data

import org.json.JSONObject
import ru.cyber_eagle_owl.saddayappkt.constants.VkConstants
import timber.log.Timber

class Group(
    var id: Long?,
    var isAdmin: Long?,
    var isAdvertiser: Long?,
    var isClosed: Long?,
    var isMember: Long?,
    var name: String?,
    var photo100: String?,
    var photo200: String?,
    var photo50: String?,
    var screenName: String?,
    var type: String?
) {

    companion object {

        fun parse(jsonObject: JSONObject?): Group? {
            Timber.d("Парсим ${Group::class.java.simpleName} Получили такой JSONObject $jsonObject")

            return if (jsonObject != null)
                Group(
                    jsonObject.optLong(VkConstants.VKAPI_CONST_ID),
                    jsonObject.optLong(VkConstants.VKAPI_CONST_IS_ADMIN),
                    jsonObject.optLong(VkConstants.VKAPI_CONST_IS_ADVERTISER),
                    jsonObject.optLong(VkConstants.VKAPI_CONST_IS_CLOSED),
                    jsonObject.optLong(VkConstants.VKAPI_CONST_IS_MEMBER),
                    jsonObject.optString(VkConstants.VKAPI_CONST_NAME),
                    jsonObject.optString(VkConstants.VKAPI_CONST_PHOTO_100),
                    jsonObject.optString(VkConstants.VKAPI_CONST_PHOTO_200),
                    jsonObject.optString(VkConstants.VKAPI_CONST_PHOTO_50),
                    jsonObject.optString(VkConstants.VKAPI_CONST_SCREEN_NAME),
                    jsonObject.optString(VkConstants.VKAPI_CONST_TYPE)
                )
            else null
        }
    }
}

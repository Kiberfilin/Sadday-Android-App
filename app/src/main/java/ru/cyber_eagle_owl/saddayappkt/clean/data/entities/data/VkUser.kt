package ru.cyber_eagle_owl.saddayappkt.clean.data.entities.data

import org.json.JSONObject
import ru.cyber_eagle_owl.saddayappkt.constants.VkConstants
import timber.log.Timber

class VkUser(
    var canAccessClosed: Boolean?,
    var firstName: String?,
    var id: Long?,
    var isClosed: Boolean?,
    var lastName: String?,
    var online: Long?,
    var onlineApp: Long?,
    var onlineMobile: Long?,
    var photo100: String?,
    var photo50: String?,
    var screenName: String?,
    var sex: Long?
) {

    companion object {

        fun parse(jsonObject: JSONObject?): VkUser? {
            Timber.d("parse(jsonObject: JSONObject?): VkUser?")

            return if (jsonObject != null)
                VkUser(
                    jsonObject.optBoolean(VkConstants.VKAPI_CONST_CAN_ACCESS_CLOSED),
                    jsonObject.optString(VkConstants.VKAPI_CONST_FIRST_NAME),
                    jsonObject.optLong(VkConstants.VKAPI_CONST_ID),
                    jsonObject.optBoolean(VkConstants.VKAPI_CONST_IS_CLOSED),
                    jsonObject.optString(VkConstants.VKAPI_CONST_LAST_NAME),
                    jsonObject.optLong(VkConstants.VKAPI_CONST_ONLINE),
                    jsonObject.optLong(VkConstants.VKAPI_CONST_ONLINE_APP),
                    jsonObject.optLong(VkConstants.VKAPI_CONST_ONLINE_MOBILE),
                    jsonObject.optString(VkConstants.VKAPI_CONST_PHOTO_100),
                    jsonObject.optString(VkConstants.VKAPI_CONST_PHOTO_50),
                    jsonObject.optString(VkConstants.VKAPI_CONST_SCREEN_NAME),
                    jsonObject.optLong(VkConstants.VKAPI_CONST_SEX)
                )
            else null
        }
    }
}

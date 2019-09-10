package ru.cyber_eagle_owl.saddayappkt.clean.data.entities.data

import ru.cyber_eagle_owl.saddayappkt.constants.VkConstants
import org.json.JSONObject
import timber.log.Timber

class Place(
    var id: Long?,
    var title: String?,
    var latitude: Double?,
    var longitude: Double?,
    var created: Long?,
    var icon: String?,
    var checkins: Long?,
    var updated: Long?,
    var type: Long?,
    var country: Long?,
    var city: Long?,
    var address: String?
) {

    companion object {

        fun parse(jsonObject: JSONObject?): Place? {
            Timber.d("Парсим ${Place::class.java.simpleName} Получили такой JSONObject $jsonObject")

            return if (jsonObject != null) {
                Place(
                    jsonObject.optLong(VkConstants.VKAPI_CONST_ID),
                    jsonObject.optString(VkConstants.VKAPI_CONST_TITLE),
                    jsonObject.optDouble(VkConstants.VKAPI_CONST_LATITUDE),
                    jsonObject.optDouble(VkConstants.VKAPI_CONST_LONGITUDE),
                    jsonObject.optLong(VkConstants.VKAPI_CONST_CREATED),
                    jsonObject.optString(VkConstants.VKAPI_CONST_ICON),
                    jsonObject.optLong(VkConstants.VKAPI_CONST_CHECKINS),
                    jsonObject.optLong(VkConstants.VKAPI_CONST_UPDATED),
                    jsonObject.optLong(VkConstants.VKAPI_CONST_TYPE),
                    jsonObject.optLong(VkConstants.VKAPI_CONST_COUNTRY),
                    jsonObject.optLong(VkConstants.VKAPI_CONST_CITY),
                    jsonObject.optString(VkConstants.VKAPI_CONST_ADDRESS)
                )
            } else {
                null
            }
        }
    }
}

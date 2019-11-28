package ru.cyber_eagle_owl.saddayappkt.clean.data.entities.data

import org.json.JSONObject
import ru.cyber_eagle_owl.saddayappkt.constants.VkConstants
import timber.log.Timber

class Address(
    var id: Long?,
    var country_id: Long?,
    var city_id: Long?,
    var title: String?,
    var address: String?,
    var additional_address: String?,
    var latitude: Double?,
    var longitude: Double?,
    var metro_station_id: Long?,
    var work_info_status: String?,
    var timetable: String?
) {

    companion object {

        fun parse(jsonObject: JSONObject?): Address? {
            Timber.d("Парсим ${Address::class.java.simpleName} Получили такой JSONObject $jsonObject")

            return if (jsonObject != null) {
                Address(
                    jsonObject.optLong(VkConstants.VKAPI_CONST_ID),
                    jsonObject.optLong(VkConstants.VKAPI_CONST_COUNTRY_ID),
                    jsonObject.optLong(VkConstants.VKAPI_CONST_CITY_ID),
                    jsonObject.optString(VkConstants.VKAPI_CONST_TITLE),
                    jsonObject.optString(VkConstants.VKAPI_CONST_ADDRESS),
                    jsonObject.optString(VkConstants.VKAPI_CONST_ADDITIONAL_ADDRESS),
                    jsonObject.optDouble(VkConstants.VKAPI_CONST_LATITUDE),
                    jsonObject.optDouble(VkConstants.VKAPI_CONST_LONGITUDE),
                    jsonObject.optLong(VkConstants.VKAPI_CONST_METRO_STATION_ID),
                    jsonObject.optString(VkConstants.VKAPI_CONST_WORK_INFO_STATUS),
                    jsonObject.optString(VkConstants.VKAPI_CONST_TIMETABLE)
                )
            } else {
                null
            }
        }
    }
}

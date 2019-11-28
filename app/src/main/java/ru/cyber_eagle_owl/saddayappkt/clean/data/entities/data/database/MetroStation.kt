package ru.cyber_eagle_owl.saddayappkt.clean.data.entities.data.database

import org.json.JSONObject
import ru.cyber_eagle_owl.saddayappkt.constants.VkConstants
import timber.log.Timber

class MetroStation(
    var id: Long?,
    var name: String?,
    var cityId: Long?,
    var color: String?
) {

    companion object {

        fun parse(jsonObject: JSONObject?): MetroStation? {
            Timber.d("Парсим ${MetroStation::class.java.simpleName} Получили такой JSONObject $jsonObject")

            return if (jsonObject != null) {
                MetroStation(
                    jsonObject.optLong(VkConstants.VKAPI_CONST_ID),
                    jsonObject.optString(VkConstants.VKAPI_CONST_NAME),
                    jsonObject.optLong(VkConstants.VKAPI_CONST_CITY_ID),
                    jsonObject.optString(VkConstants.VKAPI_CONST_COLOR)
                )
            } else {
                null
            }
        }
    }
}

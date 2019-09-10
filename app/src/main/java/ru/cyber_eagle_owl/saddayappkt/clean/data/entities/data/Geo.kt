package ru.cyber_eagle_owl.saddayappkt.clean.data.entities.data

import ru.cyber_eagle_owl.saddayappkt.constants.VkConstants
import org.json.JSONObject
import timber.log.Timber

class Geo(var type: String?, var coordinates: String?, var place: Place?) {
    companion object {

        fun parse(jsonObject: JSONObject?): Geo? {
            Timber.d("Парсим ${Geo::class.java.simpleName} Получили такой JSONObject $jsonObject")

            return if (jsonObject != null) {
                Geo(jsonObject.optString(VkConstants.VKAPI_CONST_TYPE),
                        jsonObject.optString(VkConstants.VKAPI_CONST_COORDINATES),
                        Place.parse(jsonObject.optJSONObject(VkConstants.VKAPI_CONST_PLACE)))
            } else {
                null
            }
        }
    }
}

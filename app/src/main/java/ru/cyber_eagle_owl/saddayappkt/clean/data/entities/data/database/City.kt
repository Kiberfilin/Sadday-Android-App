package ru.cyber_eagle_owl.saddayappkt.clean.data.entities.data.database

import org.json.JSONObject
import ru.cyber_eagle_owl.saddayappkt.constants.VkConstants
import timber.log.Timber

class City(
    var id: Long?,
    var title: String?
) {

    companion object {

        fun parse(jsonObject: JSONObject?): City? {
            Timber.d("Парсим ${City::class.java.simpleName} Получили такой JSONObject $jsonObject")

            return if (jsonObject != null) {
                City(
                    jsonObject.optLong(VkConstants.VKAPI_CONST_ID),
                    jsonObject.optString(VkConstants.VKAPI_CONST_TITLE)
                )
            } else {
                null
            }
        }
    }
}

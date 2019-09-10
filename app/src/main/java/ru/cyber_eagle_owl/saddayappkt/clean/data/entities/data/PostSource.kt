package ru.cyber_eagle_owl.saddayappkt.clean.data.entities.data

import ru.cyber_eagle_owl.saddayappkt.constants.VkConstants
import org.json.JSONObject
import timber.log.Timber

class PostSource(var type: String?, var platform: String?, var data: String?, var url: String?) {
    companion object {

        fun parse(jsonObject: JSONObject?): PostSource? {
            Timber.d("Парсим ${PostSource::class.java.simpleName} Получили такой JSONObject $jsonObject")

            return if (jsonObject != null) {
                PostSource(
                    jsonObject.optString(VkConstants.VKAPI_CONST_TYPE),
                    jsonObject.optString(VkConstants.VKAPI_CONST_PLATFORM),
                    jsonObject.optString(VkConstants.VKAPI_CONST_DATA),
                    jsonObject.optString(VkConstants.VKAPI_CONST_URL)
                )
            } else {
                null
            }
        }
    }
}

package ru.cyber_eagle_owl.saddayappkt.clean.data.entities.data

import org.json.JSONObject
import ru.cyber_eagle_owl.saddayappkt.constants.VkConstants
import timber.log.Timber

open class FullResponse(var response: Response?) {

    companion object {

        fun parse(jsonObject: JSONObject?): FullResponse? {
            Timber.d("Парсим ${FullResponse::class.java.simpleName} Получили такой JSONObject $jsonObject")

            return if (jsonObject != null) {
                FullResponse(Response.parse(jsonObject.optJSONObject(VkConstants.VKAPI_CONST_RESPONSE)))
            } else {
                null
            }
        }
    }
}

package ru.cyber_eagle_owl.saddayappkt.clean.data.entities.data.attachments.link.product.price.currency

import ru.cyber_eagle_owl.saddayappkt.constants.VkConstants
import org.json.JSONObject
import timber.log.Timber

class Currency(var id: Long?, var name: String?) {

    companion object {

        fun parse(jsonObject: JSONObject?): Currency? {
            Timber.d("Парсим ${Currency::class.java.simpleName} Получили такой JSONObject $jsonObject")

            return if (jsonObject != null) {
                Currency(
                    jsonObject.optLong(VkConstants.VKAPI_CONST_ID),
                    jsonObject.optString(VkConstants.VKAPI_CONST_NAME)
                )
            } else {
                null
            }
        }
    }
}

package ru.cyber_eagle_owl.saddayappkt.clean.data.entities.data.attachments.link.product.price

import ru.cyber_eagle_owl.saddayappkt.constants.VkConstants
import org.json.JSONObject
import timber.log.Timber
import ru.cyber_eagle_owl.saddayappkt.clean.data.entities.data.attachments.link.product.price.currency.Currency

class Price(
            var amount: Long?,
            var currency: Currency?,
            var text: String?) {

    companion object {

        fun parse(jsonObject: JSONObject?): Price? {
            Timber.d("Парсим ${Price::class.java.simpleName} Получили такой JSONObject $jsonObject")

            return if (jsonObject != null) {
                Price(
                        jsonObject.optLong(VkConstants.VKAPI_CONST_AMOUNT),
                        Currency.parse(jsonObject.optJSONObject(VkConstants.VKAPI_CONST_CURRENCY)),
                        jsonObject.optString(VkConstants.VKAPI_CONST_TEXT)
                )
            } else {
                null
            }
        }
    }
}

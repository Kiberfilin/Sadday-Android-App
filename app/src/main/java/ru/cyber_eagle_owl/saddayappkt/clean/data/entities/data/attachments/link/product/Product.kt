package ru.cyber_eagle_owl.saddayappkt.clean.data.entities.data.attachments.link.product

import ru.cyber_eagle_owl.saddayappkt.constants.VkConstants
import org.json.JSONObject
import timber.log.Timber
import ru.cyber_eagle_owl.saddayappkt.clean.data.entities.data.attachments.link.product.price.Price

class Product(var price: Price?) {

    companion object {

        fun parse(jsonObject: JSONObject?): Product? {
            Timber.d("Парсим ${Product::class.java.simpleName} Получили такой JSONObject $jsonObject")

            return if (jsonObject != null) {
                Product(Price.parse(jsonObject.optJSONObject(VkConstants.VKAPI_CONST_PRICE)))
            } else {
                null
            }
        }
    }
}

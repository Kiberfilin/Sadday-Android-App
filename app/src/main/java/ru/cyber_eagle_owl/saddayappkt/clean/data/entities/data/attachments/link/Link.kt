package ru.cyber_eagle_owl.saddayappkt.clean.data.entities.data.attachments.link

import ru.cyber_eagle_owl.saddayappkt.constants.VkConstants
import org.json.JSONObject
import timber.log.Timber
import ru.cyber_eagle_owl.saddayappkt.clean.data.entities.data.attachments.Attachable
import ru.cyber_eagle_owl.saddayappkt.clean.data.entities.data.attachments.link.button.Button
import ru.cyber_eagle_owl.saddayappkt.clean.data.entities.data.attachments.photo.Photo
import ru.cyber_eagle_owl.saddayappkt.clean.data.entities.data.attachments.link.product.Product

class Link(
    var url: String?,
    var title: String?,
    var caption: String?,
    var description: String?,
    var photo: Photo?,
    var product: Product?,
    var button: Button?,
    var previewPage: String?,
    var previewUrl: String?
) : Attachable {

    companion object {

        fun parse(jsonObject: JSONObject?): Link? {
            Timber.d("Парсим ${Link::class.java.simpleName} Получили такой JSONObject $jsonObject")

            return if (jsonObject != null) {
                Link(
                    jsonObject.optString(VkConstants.VKAPI_CONST_URL),
                    jsonObject.optString(VkConstants.VKAPI_CONST_TITLE),
                    jsonObject.optString(VkConstants.VKAPI_CONST_CAPTION),
                    jsonObject.optString(VkConstants.VKAPI_CONST_DESCRIPTION),
                    Photo.parse(jsonObject.optJSONObject(VkConstants.VKAPI_CONST_PHOTO)),
                    Product.parse(jsonObject.optJSONObject(VkConstants.VKAPI_CONST_PRODUCT)),
                    Button.parse(jsonObject.optJSONObject(VkConstants.VKAPI_CONST_BUTTON)),
                    jsonObject.optString(VkConstants.VKAPI_CONST_PREVIEW_PAGE),
                    jsonObject.optString(VkConstants.VKAPI_CONST_PREVIEW_URL)
                )
            } else {
                null
            }
        }
    }
}

package ru.cyber_eagle_owl.saddayappkt.clean.data.entities.data.attachments.doc.preview.previewphoto

import ru.cyber_eagle_owl.saddayappkt.constants.VkConstants
import org.json.JSONObject
import ru.cyber_eagle_owl.saddayappkt.clean.data.entities.data.attachments.photo.size.Size
import timber.log.Timber

class PreviewPhoto(var sizes: List<Size?>?) {

    companion object {

        fun parse(jsonObject: JSONObject?): PreviewPhoto? {
            Timber.d("Парсим ${PreviewPhoto::class.java.simpleName} Получили такой JSONObject $jsonObject")

            return if (jsonObject != null) {
                val jsonArrayOfSizes = jsonObject.optJSONArray(VkConstants.VKAPI_CONST_SIZES)
                var sizes: ArrayList<Size?>? = null
                if (jsonArrayOfSizes != null) {
                    sizes = ArrayList()
                    for (i in 0 until jsonArrayOfSizes.length()) {
                        sizes.add(Size.parse(jsonArrayOfSizes.optJSONObject(i)))
                    }
                }
                PreviewPhoto(sizes)
            } else {
                null
            }
        }
    }
}

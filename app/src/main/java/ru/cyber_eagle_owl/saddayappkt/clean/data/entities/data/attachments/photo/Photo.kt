package ru.cyber_eagle_owl.saddayappkt.clean.data.entities.data.attachments.photo

import java.util.ArrayList
import org.json.JSONObject
import ru.cyber_eagle_owl.saddayappkt.constants.VkConstants
import ru.cyber_eagle_owl.saddayappkt.clean.data.entities.data.attachments.Attachable
import timber.log.Timber
import ru.cyber_eagle_owl.saddayappkt.clean.data.entities.data.attachments.photo.size.Size


class Photo(var id: Long?,
            var albumId: Long?,
            var ownerId: Long?,
            var userId: Long?,
            var text: String?,
            var date: Long?,
            var sizes: List<Size?>?,
            var width: Int?,
            var height: Int?,
            var accessKey: String?) : Attachable {

    companion object {

        fun parse(jsonObject: JSONObject?): Photo? {
            Timber.d("Парсим ${Photo::class.java.simpleName} Получили такой JSONObject $jsonObject")

            if (jsonObject != null) {
                val jsonArrayOfSizes = jsonObject.optJSONArray(VkConstants.VKAPI_CONST_SIZES)
                var sizes: ArrayList<Size?>? = ArrayList()
                if (jsonArrayOfSizes != null) {
                    sizes = ArrayList()
                    for (i in 0 until jsonArrayOfSizes.length()) {
                        sizes.add(Size.parse(jsonArrayOfSizes.optJSONObject(i)))
                    }
                }

                return Photo(jsonObject.optLong(VkConstants.VKAPI_CONST_ID),
                        jsonObject.optLong(VkConstants.VKAPI_CONST_ALBUM_ID),
                        jsonObject.optLong(VkConstants.VKAPI_CONST_OWNER_ID),
                        jsonObject.optLong(VkConstants.VKAPI_CONST_USER_ID),
                        jsonObject.optString(VkConstants.VKAPI_CONST_TEXT),
                        jsonObject.optLong(VkConstants.VKAPI_CONST_DATE),
                        sizes,
                        jsonObject.optInt(VkConstants.VKAPI_CONST_WIDTH),
                        jsonObject.optInt(VkConstants.VKAPI_CONST_HEIGHT),
                        jsonObject.optString(VkConstants.VKAPI_CONST_ACCESS_KEY))
            } else {
                return null
            }
        }
    }
}



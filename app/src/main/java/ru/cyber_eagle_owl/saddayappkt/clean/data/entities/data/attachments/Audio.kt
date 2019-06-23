package ru.cyber_eagle_owl.saddayappkt.clean.data.entities.data.attachments

import ru.cyber_eagle_owl.saddayappkt.constants.VkConstants
import org.json.JSONObject
import timber.log.Timber

class Audio(
    var id: Long?,
    var ownerId: Long?,
    var artist: String?,
    var title: String?,
    var duration: Long?,
    var url: String?,
    var lyricsId: Int?,
    var albumId: Long?,
    var genreId: Int?,
    var date: Long?,
    var noSearch: Int?,
    var isHq: Int?
) : Attachable {

    companion object {

        fun parse(jsonObject: JSONObject?): Audio? {
            Timber.d("Парсим ${Audio::class.java.simpleName} Получили такой JSONObject $jsonObject")

            return if (jsonObject != null) {
                Audio(
                    jsonObject.optLong(VkConstants.VKAPI_CONST_ID),
                    jsonObject.optLong(VkConstants.VKAPI_CONST_OWNER_ID),
                    jsonObject.optString(VkConstants.VKAPI_CONST_ARTIST),
                    jsonObject.optString(VkConstants.VKAPI_CONST_TITLE),
                    jsonObject.optLong(VkConstants.VKAPI_CONST_DURATION),
                    jsonObject.optString(VkConstants.VKAPI_CONST_URL),
                    jsonObject.optInt(VkConstants.VKAPI_CONST_LYRICS_ID),
                    jsonObject.optLong(VkConstants.VKAPI_CONST_ALBUM_ID),
                    jsonObject.optInt(VkConstants.VKAPI_CONST_GENRE_ID),
                    jsonObject.optLong(VkConstants.VKAPI_CONST_DATE),
                    jsonObject.optInt(VkConstants.VKAPI_CONST_NO_SEARCH),
                    jsonObject.optInt(VkConstants.VKAPI_CONST_IS_HQ)
                )
            } else {
                null
            }
        }
    }
}

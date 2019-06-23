package ru.cyber_eagle_owl.saddayappkt.clean.data.entities.data.attachments

import ru.cyber_eagle_owl.saddayappkt.constants.VkConstants
import org.json.JSONObject
import timber.log.Timber

class Video(
    var id: Long?,
    var ownerId: Long?,
    var title: String?,
    var description: String?,
    var duration: Long?,
    var photo130: String?,
    var photo320: String?,
    var photo640: String?,
    var photo800: String?,
    var photo1280: String?,
    var firstFrame130: String?,
    var firstFrame320: String?,
    var firstFrame640: String?,
    var firstFrame800: String?,
    var firstFrame1280: String?,
    var date: Long?,
    var addingDate: Long?,
    var views: Long?,
    var comments: Long?,
    var player: String?,
    var platform: String?,
    var canEdit: Int?,
    var canAdd: Int?,
    var isPrivate: Int?,
    var accessKey: String?,
    var processing: Int?,
    var live: Int?,
    var upcoming: Int?,
    var favorite: Boolean?
) : Attachable {

    companion object {

        fun parse(jsonObject: JSONObject?): Video? {
            Timber.d("Парсим ${Video::class.java.simpleName} Получили такой JSONObject $jsonObject")

            return if (jsonObject != null) {
                Video(
                    jsonObject.optLong(VkConstants.VKAPI_CONST_ID),
                    jsonObject.optLong(VkConstants.VKAPI_CONST_OWNER_ID),
                    jsonObject.optString(VkConstants.VKAPI_CONST_TITLE),
                    jsonObject.optString(VkConstants.VKAPI_CONST_DESCRIPTION),
                    jsonObject.optLong(VkConstants.VKAPI_CONST_DURATION),
                    jsonObject.optString(VkConstants.VKAPI_CONST_PHOTO_130),
                    jsonObject.optString(VkConstants.VKAPI_CONST_PHOTO_320),
                    jsonObject.optString(VkConstants.VKAPI_CONST_PHOTO_640),
                    jsonObject.optString(VkConstants.VKAPI_CONST_PHOTO_800),
                    jsonObject.optString(VkConstants.VKAPI_CONST_PHOTO_1280),
                    jsonObject.optString(VkConstants.VKAPI_CONST_FIRST_FRAME_130),
                    jsonObject.optString(VkConstants.VKAPI_CONST_FIRST_FRAME_320),
                    jsonObject.optString(VkConstants.VKAPI_CONST_FIRST_FRAME_640),
                    jsonObject.optString(VkConstants.VKAPI_CONST_FIRST_FRAME_800),
                    jsonObject.optString(VkConstants.VKAPI_CONST_FIRST_FRAME_1280),
                    jsonObject.optLong(VkConstants.VKAPI_CONST_DATE),
                    jsonObject.optLong(VkConstants.VKAPI_CONST_ADDING_DATE),
                    jsonObject.optLong(VkConstants.VKAPI_CONST_VIEWS),
                    jsonObject.optLong(VkConstants.VKAPI_CONST_COMMENTS),
                    jsonObject.optString(VkConstants.VKAPI_CONST_PLAYER),
                    jsonObject.optString(VkConstants.VKAPI_CONST_PLATFORM),
                    jsonObject.optInt(VkConstants.VKAPI_CONST_CAN_EDIT),
                    jsonObject.optInt(VkConstants.VKAPI_CONST_CAN_ADD),
                    jsonObject.optInt(VkConstants.VKAPI_CONST_IS_PRIVATE),
                    jsonObject.optString(VkConstants.VKAPI_CONST_ACCESS_KEY),
                    jsonObject.optInt(VkConstants.VKAPI_CONST_PROCESSING),
                    jsonObject.optInt(VkConstants.VKAPI_CONST_LIVE),
                    jsonObject.optInt(VkConstants.VKAPI_CONST_UPCOMING),
                    jsonObject.optBoolean(VkConstants.VKAPI_CONST_IS_FAVORITE)
                )
            } else {
                null
            }
        }
    }
}

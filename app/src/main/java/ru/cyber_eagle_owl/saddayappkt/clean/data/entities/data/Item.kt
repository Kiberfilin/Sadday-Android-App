package ru.cyber_eagle_owl.saddayappkt.clean.data.entities.data

import org.json.JSONArray
import org.json.JSONObject
import ru.cyber_eagle_owl.saddayappkt.clean.data.entities.data.attachments.Attachment
import ru.cyber_eagle_owl.saddayappkt.constants.VkConstants
import timber.log.Timber
import java.util.*

class Item(var id: Long?,
           var ownerId: Long?,
           var fromId: Long?,
           var createdBy: Long?,
           var date: Long?,
           var text: String?,
           var replyOwnerId: Long?,
           var replyPostId: Long?,
           var friendsOnly: Int?,
           var comments: Comments?,
           var likes: Likes?,
           var reposts: Reposts?,
           var views: Views?,
           var postType: String?,
           var postSource: PostSource?,
           var attachments: List<Attachment?>?,
           var geo: Geo?,
           var signerId: Long?,
           var copyHistory: List<Item?>?,
           var canPin: Int?,
           var canDelete: Int?,
           var canEdit: Int?,
           var isPinned: Int?,
           var markedAsAds: Int?,
           var favorite: Boolean?) {

    fun getIsFavorite(): Boolean? {
        return favorite
    }

    fun setIsFavorite(isFavorite: Boolean?) {
        this.favorite = isFavorite
    }

    companion object {

        fun parse(jsonObject: JSONObject?): Item? {
            Timber.d("Парсим ${Item::class.java.simpleName} Получили такой JSONObject $jsonObject")

            if (jsonObject != null) {
                val jsonArrayAttachments = jsonObject.optJSONArray(VkConstants.VKAPI_CONST_ATTACHMENTS)
                val jsonArrayCopyHistory = jsonObject.optJSONArray(VkConstants.VKAPI_CONST_COPY_HISTORY)

                Timber.d("${Item::class.java.simpleName} jsonArrayAttachments: $jsonArrayAttachments")
                Timber.d("${Item::class.java.simpleName} jsonArrayCopyHistory: $jsonArrayCopyHistory")

                val tmpAttachments = parseAttachments(jsonArrayAttachments)
                val tmpCopyHistory = parseItems(jsonArrayCopyHistory)

                Timber.d("${Item::class.java.simpleName} tmpAttachments.toString(): $tmpAttachments")
                Timber.d("${Item::class.java.simpleName} tmpCopyHistory.toString(): $tmpCopyHistory")

                return Item(jsonObject.optLong(VkConstants.VKAPI_CONST_ID),
                        jsonObject.optLong(VkConstants.VKAPI_CONST_OWNER_ID),
                        jsonObject.optLong(VkConstants.VKAPI_CONST_FROM_ID),
                        jsonObject.optLong(VkConstants.VKAPI_CONST_CREATED_BY),
                        jsonObject.optLong(VkConstants.VKAPI_CONST_DATE),
                        jsonObject.optString(VkConstants.VKAPI_CONST_TEXT),
                        jsonObject.optLong(VkConstants.VKAPI_CONST_REPLY_OWNER_ID),
                        jsonObject.optLong(VkConstants.VKAPI_CONST_REPLY_POST_ID),
                        jsonObject.optInt(VkConstants.VKAPI_CONST_FRIENDS_ONLY),
                        Comments.parse(jsonObject.optJSONObject(VkConstants.VKAPI_CONST_COMMENTS)),
                        Likes.parse(jsonObject.optJSONObject(VkConstants.VKAPI_CONST_LIKES)),
                        Reposts.parse(jsonObject.optJSONObject(VkConstants.VKAPI_CONST_REPOSTS)),
                        Views.parse(jsonObject.optJSONObject(VkConstants.VKAPI_CONST_VIEWS)),
                        jsonObject.optString(VkConstants.VKAPI_CONST_POST_TYPE),
                        PostSource.parse(jsonObject.optJSONObject(VkConstants.VKAPI_CONST_POST_SOURCE)),
                        tmpAttachments,
                        Geo.parse(jsonObject.optJSONObject(VkConstants.VKAPI_CONST_GEO)),
                        jsonObject.optLong(VkConstants.VKAPI_CONST_SIGNER_ID),
                        tmpCopyHistory,
                        jsonObject.optInt(VkConstants.VKAPI_CONST_CAN_PIN),
                        jsonObject.optInt(VkConstants.VKAPI_CONST_CAN_DELETE),
                        jsonObject.optInt(VkConstants.VKAPI_CONST_CAN_EDIT),
                        jsonObject.optInt(VkConstants.VKAPI_CONST_IS_PINNED),
                        jsonObject.optInt(VkConstants.VKAPI_CONST_MARKED_AS_ADS),
                        jsonObject.optBoolean(VkConstants.VKAPI_CONST_IS_FAVORITE))
            } else {
                return null
            }
        }

        private fun parseItems(jsonArray: JSONArray?): ArrayList<Item?>? {
            Timber.d("parseItems(jsonArray: JSONArray?): ArrayList<Item>")

            return if (jsonArray != null) {
                val tmpList: ArrayList<Item?> = ArrayList()
                for (i in 0 until jsonArray.length()) {
                    tmpList.add(parse(jsonArray.optJSONObject(i)))
                }
                tmpList
            } else {
                null
            }
        }

        private fun parseAttachments(jsonArray: JSONArray?): ArrayList<Attachment?>? {
            Timber.d("parseAttachments(jsonArray: JSONArray?): ArrayList<Attachment>")

            return if (jsonArray != null) {
                val tmpList: ArrayList<Attachment?> = ArrayList()
                for (i in 0 until jsonArray.length()) {
                    tmpList.add(Attachment.parse(jsonArray.optJSONObject(i)))
                }
                tmpList
            } else {
                null
            }
        }
    }
}

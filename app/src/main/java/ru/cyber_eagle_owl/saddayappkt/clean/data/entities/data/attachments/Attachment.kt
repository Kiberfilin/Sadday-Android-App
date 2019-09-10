package ru.cyber_eagle_owl.saddayappkt.clean.data.entities.data.attachments

import ru.cyber_eagle_owl.saddayappkt.constants.VkConstants
import org.json.JSONObject
import timber.log.Timber
import ru.cyber_eagle_owl.saddayappkt.clean.data.entities.data.attachments.doc.Doc
import ru.cyber_eagle_owl.saddayappkt.clean.data.entities.data.attachments.link.Link
import ru.cyber_eagle_owl.saddayappkt.clean.data.entities.data.attachments.photo.Photo
import ru.cyber_eagle_owl.saddayappkt.clean.data.entities.data.attachments.poll.Poll

class Attachment(var type: String?, var attachment: Attachable?) {

    companion object {

        fun parse(jsonObject: JSONObject?): Attachment? {
            Timber.d("Парсим ${Attachment::class.java.simpleName} Получили такой JSONObject $jsonObject")

            return if (jsonObject != null) {
                val tmpType = jsonObject.optString(VkConstants.VKAPI_CONST_TYPE)
                var tmpAttachment: Attachable? = null
                when (tmpType) {
                    VkConstants.VKAPI_CONST_PHOTO -> tmpAttachment =
                        Photo.parse(jsonObject.optJSONObject(VkConstants.VKAPI_CONST_PHOTO))
                    VkConstants.VKAPI_CONST_POSTED_PHOTO -> tmpAttachment =
                        PostedPhoto.parse(jsonObject.optJSONObject(VkConstants.VKAPI_CONST_POSTED_PHOTO))
                    VkConstants.VKAPI_CONST_VIDEO -> tmpAttachment =
                        Video.parse(jsonObject.optJSONObject(VkConstants.VKAPI_CONST_VIDEO))
                    VkConstants.VKAPI_CONST_AUDIO -> tmpAttachment =
                        Audio.parse(jsonObject.optJSONObject(VkConstants.VKAPI_CONST_AUDIO))
                    VkConstants.VKAPI_CONST_DOC -> tmpAttachment =
                        Doc.parse(jsonObject.optJSONObject(VkConstants.VKAPI_CONST_DOC))
                    VkConstants.VKAPI_CONST_GRAFFITI -> tmpAttachment =
                        Graffiti.parse(jsonObject.optJSONObject(VkConstants.VKAPI_CONST_GRAFFITI))
                    VkConstants.VKAPI_CONST_LINK -> tmpAttachment =
                        Link.parse(jsonObject.optJSONObject(VkConstants.VKAPI_CONST_LINK))
                    VkConstants.VKAPI_CONST_NOTE -> tmpAttachment =
                        Note.parse(jsonObject.optJSONObject(VkConstants.VKAPI_CONST_NOTE))
                    VkConstants.VKAPI_CONST_APP -> tmpAttachment =
                        App.parse(jsonObject.optJSONObject(VkConstants.VKAPI_CONST_APP))
                    VkConstants.VKAPI_CONST_POLL -> tmpAttachment =
                        Poll.parse(jsonObject.optJSONObject(VkConstants.VKAPI_CONST_POLL))
                    VkConstants.VKAPI_CONST_PAGE -> {
                    }
                    VkConstants.VKAPI_CONST_ALBUM -> {
                    }
                    VkConstants.VKAPI_CONST_PHOTOS_LIST -> {
                    }
                    VkConstants.VKAPI_CONST_MARKET -> {
                    }
                    VkConstants.VKAPI_CONST_MARKET_ALBUM -> {
                    }
                    VkConstants.VKAPI_CONST_STICKER -> {
                    }
                    VkConstants.VKAPI_CONST_PRETTY_CARDS -> {
                    }
                }//tmpAttachment =
                //tmpAttachment =
                //tmpAttachment =
                //tmpAttachment =
                //tmpAttachment =
                //tmpAttachment =
                //tmpAttachment =
                Attachment(tmpType, tmpAttachment)
            } else {
                null
            }
        }
    }
}

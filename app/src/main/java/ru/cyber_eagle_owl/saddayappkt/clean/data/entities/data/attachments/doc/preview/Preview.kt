package ru.cyber_eagle_owl.saddayappkt.clean.data.entities.data.attachments.doc.preview

import ru.cyber_eagle_owl.saddayappkt.constants.VkConstants
import org.json.JSONObject
import timber.log.Timber
import ru.cyber_eagle_owl.saddayappkt.clean.data.entities.data.attachments.doc.preview.previewphoto.PreviewPhoto

class Preview(
    var previewPhoto: PreviewPhoto?,
    var previewGraffiti: PreviewGraffiti?,
    var audioMessage: AudioMessage?
) {

    companion object {

        fun parse(jsonObject: JSONObject?): Preview? {
            Timber.d("Парсим ${Preview::class.java.simpleName} Получили такой JSONObject $jsonObject")

            return if (jsonObject != null) {
                Preview(
                    PreviewPhoto.parse(jsonObject.optJSONObject(VkConstants.VKAPI_CONST_PHOTO)),
                    PreviewGraffiti.parse(jsonObject.optJSONObject(VkConstants.VKAPI_CONST_GRAFFITI)),
                    AudioMessage.parse(jsonObject.optJSONObject(VkConstants.VKAPI_CONST_AUDIO_MESSAGE))
                )
            } else {
                null
            }
        }
    }
}

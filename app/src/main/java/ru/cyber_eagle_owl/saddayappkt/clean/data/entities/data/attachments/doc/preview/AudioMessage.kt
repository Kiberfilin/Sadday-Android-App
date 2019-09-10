package ru.cyber_eagle_owl.saddayappkt.clean.data.entities.data.attachments.doc.preview

import ru.cyber_eagle_owl.saddayappkt.constants.VkConstants
import org.json.JSONObject
import timber.log.Timber

class AudioMessage(
    var duration: Long?,
    var waveform: List<Int?>?,
    var linkOgg: String?,
    var linkMp3: String?
) {

    companion object {

        fun parse(jsonObject: JSONObject?): AudioMessage? {
            Timber.d("Парсим ${AudioMessage::class.java.simpleName} Получили такой JSONObject $jsonObject")

            if (jsonObject != null) {
                val tmpWaveformArray = jsonObject.optJSONArray(VkConstants.VKAPI_CONST_WAVEFORM)
                var tmpListOfInt: ArrayList<Int?>? = null
                if (tmpWaveformArray != null) {
                    tmpListOfInt = ArrayList()
                    for (i in 0 until tmpWaveformArray.length()) {
                        tmpListOfInt.add(tmpWaveformArray.optInt(i))
                    }
                }
                return AudioMessage(
                    jsonObject.optLong(VkConstants.VKAPI_CONST_DURATION),
                    tmpListOfInt,
                    jsonObject.optString(VkConstants.VKAPI_CONST_LINK_OGG),
                    jsonObject.optString(VkConstants.VKAPI_CONST_LINK_MP3)
                )
            } else {
                return null
            }
        }
    }
}

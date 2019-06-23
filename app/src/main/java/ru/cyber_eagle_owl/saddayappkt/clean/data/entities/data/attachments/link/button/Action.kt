package ru.cyber_eagle_owl.saddayappkt.clean.data.entities.data.attachments.link.button

import ru.cyber_eagle_owl.saddayappkt.constants.VkConstants
import org.json.JSONObject
import timber.log.Timber

class Action(
    var type: String?,
    var url: String?
) {

    companion object {

        fun parse(jsonObject: JSONObject?): Action? {
            Timber.d("Парсим ${Action::class.java.simpleName} Получили такой JSONObject $jsonObject")

            return if (jsonObject != null) {
                Action(
                    jsonObject.optString(VkConstants.VKAPI_CONST_TYPE),
                    jsonObject.optString(VkConstants.VKAPI_CONST_URL)
                )
            } else {
                null
            }
        }
    }
}

package ru.cyber_eagle_owl.saddayappkt.clean.data.entities.data.attachments.link.button

import ru.cyber_eagle_owl.saddayappkt.constants.VkConstants
import org.json.JSONObject
import timber.log.Timber

class Button(
    var title: String?,
    var action: Action?
) {

    companion object {

        fun parse(jsonObject: JSONObject?): Button? {
            Timber.d("Парсим ${Button::class.java.simpleName} Получили такой JSONObject $jsonObject")

            return if (jsonObject != null) {
                Button(
                    jsonObject.optString(VkConstants.VKAPI_CONST_TITLE),
                    Action.parse(jsonObject.optJSONObject(VkConstants.VKAPI_CONST_ACTION))
                )
            } else {
                null
            }
        }
    }
}

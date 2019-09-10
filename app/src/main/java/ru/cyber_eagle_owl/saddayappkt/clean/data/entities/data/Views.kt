package ru.cyber_eagle_owl.saddayappkt.clean.data.entities.data

import ru.cyber_eagle_owl.saddayappkt.constants.VkConstants
import org.json.JSONObject
import timber.log.Timber

class Views(var count: Long?) {

    companion object {

        fun parse(jsonObject: JSONObject?): Views? {
            Timber.d("Парсим ${Views::class.java.simpleName} Получили такой JSONObject $jsonObject")

            return if (jsonObject != null) {
                Views(jsonObject.optLong(VkConstants.VKAPI_CONST_COUNT))
            } else {
                null
            }
        }
    }
}

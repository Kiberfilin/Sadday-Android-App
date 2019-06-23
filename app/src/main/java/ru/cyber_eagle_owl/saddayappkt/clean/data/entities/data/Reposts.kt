package ru.cyber_eagle_owl.saddayappkt.clean.data.entities.data

import ru.cyber_eagle_owl.saddayappkt.constants.VkConstants
import org.json.JSONObject
import timber.log.Timber

class Reposts(var count: Long?, var userReposted: Int?) {

    companion object {

        fun parse(jsonObject: JSONObject?): Reposts? {
            Timber.d("Парсим ${Reposts::class.java.simpleName} Получили такой JSONObject $jsonObject")

            return if (jsonObject != null) {
                Reposts(
                    jsonObject.optLong(VkConstants.VKAPI_CONST_COUNT),
                    jsonObject.optInt(VkConstants.VKAPI_CONST_USER_REPOSTED)
                )
            } else {
                null
            }
        }
    }
}

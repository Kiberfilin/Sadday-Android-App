package ru.cyber_eagle_owl.saddayappkt.clean.data.web

import com.vk.api.sdk.requests.VKRequest
import org.json.JSONObject
import ru.cyber_eagle_owl.saddayappkt.clean.data.entities.data.Item
import ru.cyber_eagle_owl.saddayappkt.clean.data.entities.data.VkUser
import ru.cyber_eagle_owl.saddayappkt.constants.VkConstants
import timber.log.Timber

class VkUsersRequest(users: String) : VKRequest<List<VkUser?>?>(VkConstants.USERS_GET_METHOD) {

    init {
        addParam(VkConstants.VKAPI_CONST_USER_IDS, users)
    }

    override fun parse(r: JSONObject): List<VkUser?>? {
        Timber.d("parse(response: String): List<VkUser?>?")

        val users = r.getJSONArray(VkConstants.VKAPI_CONST_RESPONSE)
        val result = ArrayList<VkUser?>()
        for (i in 0 until users.length()) {
            result.add(VkUser.parse(users.getJSONObject(i)))
        }

        return result
    }
}
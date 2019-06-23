package ru.cyber_eagle_owl.saddayappkt.clean.data.web

import com.vk.api.sdk.requests.VKRequest
import org.json.JSONObject
import ru.cyber_eagle_owl.saddayappkt.clean.data.entities.data.Group
import ru.cyber_eagle_owl.saddayappkt.constants.VkConstants
import timber.log.Timber

class VkGroupRequest(id: String) : VKRequest<Group?>(VkConstants.GROUPS_GET_BY_ID_METHOD) {

    init {
        addParam(VkConstants.VKAPI_CONST_GROUP_IDS, id)
    }

    override fun parse(r: JSONObject): Group? {
        Timber.d("parse(r: JSONObject): Group?")

        val groups = r.getJSONArray(VkConstants.VKAPI_CONST_RESPONSE)
        val result = ArrayList<Group?>()
        for (i in 0 until groups.length()) {
            result.add(Group.parse(groups.getJSONObject(i)))
        }

        return result[0]
    }
}
package ru.cyber_eagle_owl.saddayappkt.clean.data.web

import com.vk.api.sdk.requests.VKRequest
import org.json.JSONObject
import ru.cyber_eagle_owl.saddayappkt.clean.data.entities.data.Item
import ru.cyber_eagle_owl.saddayappkt.constants.VkConstants
import timber.log.Timber

class NewsRequest : VKRequest<List<Item?>?>("wall.get") {

    init {
        addParam(VkConstants.VKAPI_CONST_OWNER_ID, VkConstants.BOOKING_AGENCY_GROUP_ID)
        addParam(VkConstants.VKAPI_CONST_COUNT, VkConstants.VKAPI_DEFAULT_COUNT)
        addParam(VkConstants.VKAPI_CONST_EXTENDED, 1)
    }

    override fun parse(r: JSONObject): List<Item?>? {
        Timber.d("parse(r: JSONObject): Response")

        val items = r.getJSONObject(VkConstants.VKAPI_CONST_RESPONSE).getJSONArray(VkConstants.VKAPI_CONST_ITEMS)
        //Timber.d("Profiles JSONArray: ${r.getJSONObject(VkConstants.VKAPI_CONST_RESPONSE).getJSONArray(VkConstants.VKAPI_CONST_PROFILES)}")
        val result = ArrayList<Item?>()
        for (i in 0 until items.length()) {
            result.add(Item.parse(items.getJSONObject(i)))
        }
        return result
    }


}
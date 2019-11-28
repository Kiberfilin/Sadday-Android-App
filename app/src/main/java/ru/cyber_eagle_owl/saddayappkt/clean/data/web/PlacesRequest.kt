package ru.cyber_eagle_owl.saddayappkt.clean.data.web

import com.vk.api.sdk.requests.VKRequest
import org.json.JSONObject
import ru.cyber_eagle_owl.saddayappkt.clean.data.entities.data.Address
import ru.cyber_eagle_owl.saddayappkt.constants.VkConstants
import timber.log.Timber

class PlacesRequest : VKRequest<List<Address?>?>("groups.getAddresses") {

    init {
        addParam(VkConstants.VKAPI_CONST_GROUP_ID, VkConstants.TEST_GROUP_ID)
        //addParam(VkConstants.VKAPI_CONST_COUNT, VkConstants.VKAPI_DEFAULT_COUNT)
    }

    override fun parse(r: JSONObject): List<Address?>? {
        Timber.d("parse(r: JSONObject): Response")

        val items = r.getJSONObject(VkConstants.VKAPI_CONST_RESPONSE).getJSONArray(VkConstants.VKAPI_CONST_ITEMS)
        //Timber.d("Profiles JSONArray: ${r.getJSONObject(VkConstants.VKAPI_CONST_RESPONSE).getJSONArray(VkConstants.VKAPI_CONST_PROFILES)}")
        val result = ArrayList<Address?>()
        for (i in 0 until items.length()) {
            result.add(Address.parse(items.getJSONObject(i)))
        }
        return result
    }


}
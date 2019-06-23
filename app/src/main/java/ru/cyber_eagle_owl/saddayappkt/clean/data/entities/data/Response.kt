package ru.cyber_eagle_owl.saddayappkt.clean.data.entities.data

import java.util.ArrayList

import org.json.JSONArray
import org.json.JSONObject
import ru.cyber_eagle_owl.saddayappkt.constants.VkConstants
import timber.log.Timber


class Response(
    var count: Long?,
    var items: List<Item?>?,
    var groups: List<Group?>?,
    var vkUsers: List<VkUser?>?
) {
    companion object {

        fun parse(jsonObject: JSONObject?): Response? {

            Timber.d("Парсим ${Response::class.java.simpleName} Получили такой JSONObject $jsonObject")

            return if (jsonObject != null) {
                val jsonArrayOfItems = jsonObject.optJSONArray(VkConstants.VKAPI_CONST_ITEMS)
                val jsonArrayOfGroups = jsonObject.optJSONArray(VkConstants.VKAPI_CONST_GROUPS)
                val jsonArrayOfProfiles = jsonObject.optJSONArray(VkConstants.VKAPI_CONST_PROFILES)

                Response(
                    jsonObject.optLong(VkConstants.VKAPI_CONST_COUNT),
                    parseItems(jsonArrayOfItems), parseGroups(jsonArrayOfGroups), parseProfiles(jsonArrayOfProfiles)
                )
            } else {
                null
            }
        }

        private fun parseItems(jsonArray: JSONArray?): ArrayList<Item?>? {
            Timber.d("parseItems(jsonArray: JSONArray?): ArrayList<Item>")

            return if (jsonArray != null) {
                val tmpList: ArrayList<Item?> = ArrayList()
                for (i in 0 until jsonArray.length()) {
                    tmpList.add(Item.parse(jsonArray.optJSONObject(i)))
                }
                tmpList
            } else {
                null
            }
        }

        private fun parseGroups(jsonArray: JSONArray?): ArrayList<Group?>? {
            Timber.d("parseGroups(jsonArray: JSONArray?): ArrayList<Group>")

            return if (jsonArray != null) {
                val tmpList: ArrayList<Group?> = ArrayList()
                for (i in 0 until jsonArray.length()) {
                    tmpList.add(Group.parse(jsonArray.optJSONObject(i)))
                }
                tmpList
            } else {
                null
            }
        }

        private fun parseProfiles(jsonArray: JSONArray?): ArrayList<VkUser?>? {
            Timber.d("parseProfiles(jsonArray: JSONArray?): ArrayList<VkUser>")

            return if (jsonArray != null) {
                val tmpList: ArrayList<VkUser?> = ArrayList()
                for (i in 0 until jsonArray.length()) {
                    tmpList.add(VkUser.parse(jsonArray.optJSONObject(i)))
                }
                tmpList
            } else {
                null
            }
        }
    }
}

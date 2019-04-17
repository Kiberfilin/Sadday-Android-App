package ru.cyber_eagle_owl.saddayappkt.constants

import com.vk.api.sdk.auth.VKScope

class VkConstants {
    companion object {
        val DEFAULT_LOGIN_SCOPE: ArrayList<VKScope> =
            arrayListOf(VKScope.WALL, VKScope.PHOTOS, VKScope.GROUPS, VKScope.VIDEO)
    }
}
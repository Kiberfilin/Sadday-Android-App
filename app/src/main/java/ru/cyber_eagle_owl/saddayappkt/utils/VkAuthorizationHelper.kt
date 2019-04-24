package ru.cyber_eagle_owl.saddayappkt.utils

import android.app.Activity
import com.vk.api.sdk.VK
import ru.cyber_eagle_owl.saddayappkt.constants.VkConstants
import ru.cyber_eagle_owl.saddayappkt.mvpcore.MvpView

class VkAuthorizationHelper : AuthorizationHelper {
    override fun isLoggedIn(): Boolean {
        return VK.isLoggedIn()
    }

    override fun login(mvpView: MvpView) {
        VK.login(mvpView as Activity, VkConstants.DEFAULT_LOGIN_SCOPE)
    }

}
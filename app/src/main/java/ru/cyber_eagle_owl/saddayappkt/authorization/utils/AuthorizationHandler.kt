package ru.cyber_eagle_owl.saddayappkt.authorization.utils

import android.app.Activity
import com.vk.api.sdk.VK
import ru.cyber_eagle_owl.saddayappkt.constants.VkConstants
import ru.cyber_eagle_owl.saddayappkt.mvpcore.activity.interfaces.MvpActivityView

class AuthorizationHandler<T: MvpActivityView> {
    private lateinit var tmpActivity: T

    fun setMvpView(mvpActivityView: T) {
        tmpActivity = mvpActivityView
    }

    fun isLoggedIn(): Boolean {
        return VK.isLoggedIn()
    }

    fun login() {
        VK.login(tmpActivity as Activity, VkConstants.DEFAULT_LOGIN_SCOPE)
    }
}
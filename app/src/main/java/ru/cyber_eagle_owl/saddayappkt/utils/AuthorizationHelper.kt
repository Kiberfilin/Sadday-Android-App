package ru.cyber_eagle_owl.saddayappkt.utils

import ru.cyber_eagle_owl.saddayappkt.mvpcore.MvpView

interface AuthorizationHelper {

    fun isLoggedIn(): Boolean

    fun login(mvpView: MvpView)
}
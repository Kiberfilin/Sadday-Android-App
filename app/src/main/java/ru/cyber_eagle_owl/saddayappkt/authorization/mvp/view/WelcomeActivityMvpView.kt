package ru.cyber_eagle_owl.saddayappkt.authorization.mvp.view

import ru.cyber_eagle_owl.saddayappkt.mvpcore.activity.interfaces.MvpActivityView

interface WelcomeActivityMvpView: MvpActivityView {

    fun prepareDependencyInjection()

    fun screenPreparation()

    fun viewsVisibilityHandling()

    fun finishActivity()
}
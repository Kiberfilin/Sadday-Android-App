package ru.cyber_eagle_owl.saddayappkt.authorization.mvp.presenter

import ru.cyber_eagle_owl.saddayappkt.authorization.mvp.view.WelcomeActivityMvpView
import ru.cyber_eagle_owl.saddayappkt.mvpcore.activity.interfaces.MvpActivityPresenter

interface WelcomeActivityMvpPresenter<T : WelcomeActivityMvpView> : MvpActivityPresenter<T> {

    fun onCreateLoginHandling()
}
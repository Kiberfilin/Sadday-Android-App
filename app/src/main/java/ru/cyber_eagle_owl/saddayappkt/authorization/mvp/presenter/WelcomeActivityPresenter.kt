package ru.cyber_eagle_owl.saddayappkt.authorization.mvp.presenter

import ru.cyber_eagle_owl.saddayappkt.MainMenuActivity
import ru.cyber_eagle_owl.saddayappkt.authorization.mvp.view.WelcomeActivityMvpView
import ru.cyber_eagle_owl.saddayappkt.authorization.utils.AuthorizationHandler
import ru.cyber_eagle_owl.saddayappkt.mvpcore.activity.BaseActivityPresenter

class WelcomeActivityPresenter<V : WelcomeActivityMvpView>() : BaseActivityPresenter<V>(),
    WelcomeActivityMvpPresenter<V> {

    private lateinit var authorizationHandler: AuthorizationHandler<V>

    constructor(auth: AuthorizationHandler<V>) : this() {
        authorizationHandler = auth
        authorizationHandler.setMvpView(mvpActivityView as V)
    }

    override fun onCreateLoginHandling() {
        if (authorizationHandler.isLoggedIn()) {
            MainMenuActivity.startFrom(mvpActivityView as WelcomeActivityMvpView)
            mvpActivityView!!.finishActivity()
            return
        } else {
            authorizationHandler.login()
        }
    }

}
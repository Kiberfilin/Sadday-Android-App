package ru.cyber_eagle_owl.saddayappkt.clean.presentation.features.authorization

import ru.cyber_eagle_owl.saddayappkt.clean.presentation.mvpcore.MvpView

interface WelcomeMvp {

    interface View : MvpView {

        fun startMainMenu()
        fun onAnotherLoginAttempt()
    }

    interface Presenter {

        fun onViewCreated()
        fun onResumed()
        fun onPauseLoginHandling()
        fun onDestroy()

        fun onLoginButtonClick()
    }
}
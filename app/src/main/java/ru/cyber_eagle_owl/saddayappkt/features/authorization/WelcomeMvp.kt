package ru.cyber_eagle_owl.saddayappkt.features.authorization

import ru.cyber_eagle_owl.saddayappkt.mvpcore.MvpView

interface WelcomeMvp {

    interface View : MvpView {

        fun showToast()

        fun showInjects()

        fun windowPreparation()

        fun startMainMenu()

        fun showViewsForAnotherLoginAttempt()
    }

    interface Presenter{

        fun onViewCreated()

        fun onCreateLoginHandling()

        fun onCreateScreenPreparation(sdkVersion: Int, kitkatSdkVersion: Int, viewTune: Unit)

        fun onResumeLoginHandling()

        fun onPauseLoginHandling()

        fun onLoginButtonClick()

        fun onDestroy()
    }
}
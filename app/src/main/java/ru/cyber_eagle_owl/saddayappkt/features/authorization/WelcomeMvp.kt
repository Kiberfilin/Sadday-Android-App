package ru.cyber_eagle_owl.saddayappkt.features.authorization

import ru.cyber_eagle_owl.saddayappkt.mvpcore.MvpView

interface WelcomeMvp {

    interface View : MvpView {

        fun showToast(toastText: String)
        fun showInjects()
        fun windowPreparation()
        fun startMainMenu()
        fun showViewsForAnotherLoginAttempt()
    }

    interface Presenter{

        fun onViewCreated()
        fun onCreateLoginHandling()
        fun onCreateScreenPreparation(sdkVersion: Int, kitkatSdkVersion: Int)
        fun onResumeLoginHandling()
        fun onPauseLoginHandling()
        fun onDestroy()

        fun onLoginButtonClick()
        fun saveStringToPref(key: String, data: String)
        fun getStringFromPref(key: String): String
    }

    interface Model {

        fun saveStringDataToSharedPreferences(key: String, data: String)
        fun getStringDataToSharedPreferences(key: String): String
    }
}
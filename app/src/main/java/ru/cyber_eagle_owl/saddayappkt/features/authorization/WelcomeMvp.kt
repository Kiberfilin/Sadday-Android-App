package ru.cyber_eagle_owl.saddayappkt.features.authorization

import ru.cyber_eagle_owl.saddayappkt.mvpcore.MvpView

interface WelcomeMvp {

    interface View : MvpView {

        fun showToast(toastText: String)
        fun showInjects()
        fun startMainMenu()
        fun onAnotherLoginAttempt()
    }

    interface Presenter{

        fun onViewCreated()
        fun onResumed()
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
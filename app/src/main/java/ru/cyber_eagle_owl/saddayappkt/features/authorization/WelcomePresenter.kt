package ru.cyber_eagle_owl.saddayappkt.features.authorization

import android.util.Log
import ru.cyber_eagle_owl.saddayappkt.mvpcore.BasePresenter
import ru.cyber_eagle_owl.saddayappkt.utils.AuthorizationHelper
import javax.inject.Inject

class WelcomePresenter @Inject constructor() :
    BasePresenter<WelcomeMvp.View>(),
    WelcomeMvp.Presenter {

    private val logTag: String = "WelcomePresenter"

    private var isItTheFirstTryToLoginAfterActivityWasCreated: Boolean = true

    @Inject lateinit var authorizationHelper: AuthorizationHelper

    @Inject lateinit var model: WelcomeMvp.Model

    override fun onViewCreated() {
        Log.d(logTag, "onViewCreated")

        authorizationHelper.run {
            if (isLoggedIn()) {
                Log.d(logTag, "User logged in")
                view.startMainMenu()
                return
            } else {
                Log.d(logTag, "User don't logged in")
                login(view)
            }
        }

        saveStringToPref(logTag, "Сохранённый в SharedPref текст ${System.currentTimeMillis()}")

        view.showToast(getStringFromPref(logTag))
        view.showInjects()
    }

    override fun onResumed() {
        Log.d(logTag, "onResumed")

        authorizationHelper.run {
            if (isLoggedIn()) {
                view.startMainMenu()
                return
            } else if (!isLoggedIn() && !isItTheFirstTryToLoginAfterActivityWasCreated) {
                view.onAnotherLoginAttempt()
            }
        }
    }

    override fun onPauseLoginHandling() {
        Log.d(logTag, "onPauseLoginHandling")

        if (!authorizationHelper.isLoggedIn() && isItTheFirstTryToLoginAfterActivityWasCreated) {
            isItTheFirstTryToLoginAfterActivityWasCreated = false
        }
    }

    override fun onDestroy() {
        Log.d(logTag, "onDestroy")
    }

    override fun onLoginButtonClick() {
        Log.d(logTag, "onLoginButtonClick")

        authorizationHelper.login(view)
    }

    //region SharedPreferences testing
    override fun saveStringToPref(key: String, data: String) {
        model.saveStringDataToSharedPreferences(key, data)
    }

    override fun getStringFromPref(key: String): String {
        return model.getStringDataToSharedPreferences(key)
    }
    //endregion

}

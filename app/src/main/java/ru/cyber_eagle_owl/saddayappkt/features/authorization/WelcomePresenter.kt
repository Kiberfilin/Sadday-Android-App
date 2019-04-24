package ru.cyber_eagle_owl.saddayappkt.features.authorization

import android.util.Log
import ru.cyber_eagle_owl.saddayappkt.mvpcore.BasePresenter
import ru.cyber_eagle_owl.saddayappkt.utils.AuthorizationHelper
import ru.cyber_eagle_owl.saddayappkt.utils.VkAuthorizationHelper
import javax.inject.Inject

class WelcomePresenter @Inject constructor() :
    BasePresenter<WelcomeMvp.View>(),
    WelcomeMvp.Presenter {
    private val logTag: String = "WelcomePresenter"

    private var isItTheFirstTryToLoginAfterActivityWasCreated: Boolean = true

    private val authorizationHelper: AuthorizationHelper = VkAuthorizationHelper()

    override fun onViewCreated() {
        Log.d(logTag, "onViewCreated")

        view.showInjects()
    }

    override fun onCreateLoginHandling() {
        Log.d(logTag, "onCreateLoginHandling")

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
    }

    override fun onCreateScreenPreparation(sdkVersion: Int, kitkatSdkVersion: Int, viewTune: Unit) {
        if (sdkVersion >= kitkatSdkVersion) {
            viewTune
        }
    }

    override fun onResumeLoginHandling() {
        Log.d(logTag, "onResumeLoginHandling")

        authorizationHelper.run {
            if (isLoggedIn()) {
                view.startMainMenu()
                return
            } else if (!isLoggedIn() && !isItTheFirstTryToLoginAfterActivityWasCreated) {
                view.showViewsForAnotherLoginAttempt()
            }
        }
    }

    override fun onPauseLoginHandling() {
        Log.d(logTag, "onPauseLoginHandling")

        if (!authorizationHelper.isLoggedIn() && isItTheFirstTryToLoginAfterActivityWasCreated) {
            isItTheFirstTryToLoginAfterActivityWasCreated = false
        }
    }

    override fun onLoginButtonClick() {
        Log.d(logTag, "onLoginButtonClick")

        authorizationHelper.login(view)
    }

    override fun onDestroy() {
        Log.d(logTag, "onDestroy")
        //TODO Как отцепить отсюда view?
    }
}

package ru.cyber_eagle_owl.saddayappkt.clean.presentation.features.authorization

import ru.cyber_eagle_owl.saddayappkt.clean.domain.interactors.CheckIsLoggedInInteractor
import ru.cyber_eagle_owl.saddayappkt.clean.domain.interactors.LogInInteractor
import ru.cyber_eagle_owl.saddayappkt.clean.domain.boundaries.presenter.inputports.CheckIsLoggedInInputPort
import ru.cyber_eagle_owl.saddayappkt.clean.domain.boundaries.presenter.inputports.LogInInputPort
import ru.cyber_eagle_owl.saddayappkt.clean.domain.boundaries.presenter.outputports.CheckIsLoggedInOutputPort
import ru.cyber_eagle_owl.saddayappkt.clean.presentation.mvpcore.BasePresenter
import ru.cyber_eagle_owl.saddayappkt.clean.data.repositories.VkAuthorizationRepository
import timber.log.Timber
import javax.inject.Inject

class WelcomePresenter @Inject constructor() :
    BasePresenter<WelcomeMvp.View>(),
    WelcomeMvp.Presenter,
    CheckIsLoggedInOutputPort {

    private val authRepo: VkAuthorizationRepository =
        VkAuthorizationRepository()
    private val isLoggedIn: CheckIsLoggedInInputPort = CheckIsLoggedInInteractor(this, authRepo)
    private val login: LogInInputPort = LogInInteractor(authRepo)

    private var isTheUserLoggedIn: Boolean = false
    private var isTheFirstLoginAttemptWasExecuted: Boolean = false
    private var isAnotherLoginAttemptPreparationNeeded: Boolean = false

    override fun onViewCreated() {
        Timber.d("onViewCreated")

        isLoggedIn.execute()
    }

    override fun onLoggingInChecked(isLoggedIn: Boolean) {
        Timber.d("onLoggingInChecked")

        isTheUserLoggedIn = isLoggedIn

            if (isLoggedIn) {
                Timber.d("User logged in")
                view.startMainMenu()
                return
            } else {
                Timber.d("User don't logged in")
                login.execute(view)
            }

        if (!isTheFirstLoginAttemptWasExecuted) isTheFirstLoginAttemptWasExecuted = true
    }

    override fun onResumed() {
        Timber.d("onResumed")

        if (isAnotherLoginAttemptPreparationNeeded) {
            view.onAnotherLoginAttempt()
        }

        if (!isTheUserLoggedIn && isTheFirstLoginAttemptWasExecuted) {
            isAnotherLoginAttemptPreparationNeeded = true
        }
    }

    override fun onPauseLoginHandling() {
        Timber.d("onPauseLoginHandling")

    }

    override fun onDestroy() {
        Timber.d("onDestroy")

    }

    override fun onLoginButtonClick() {
        Timber.d("onLoginButtonClick")

        login.execute(view)
    }
}

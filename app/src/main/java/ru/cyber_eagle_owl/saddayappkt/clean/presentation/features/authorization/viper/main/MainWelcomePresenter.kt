package ru.cyber_eagle_owl.saddayappkt.clean.presentation.features.authorization.viper.main

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import ru.cyber_eagle_owl.saddayappkt.clean.domain.boundaries.presenter.inputports.CheckIsLoggedInInputPort
import ru.cyber_eagle_owl.saddayappkt.clean.domain.boundaries.presenter.inputports.LogInInputPort
import ru.cyber_eagle_owl.saddayappkt.clean.presentation.features.authorization.viper.WelcomeViperContract
import ru.cyber_eagle_owl.saddayappkt.clean.vipercore.BasePresenter
import ru.cyber_eagle_owl.saddayappkt.utils.wrappers.RouterToolbox
import timber.log.Timber
import javax.inject.Inject

class MainWelcomePresenter @Inject constructor() : BasePresenter(),
    WelcomeViperContract.WelcomePresenter {
    override lateinit var view: WelcomeViperContract.WelcomeView
    @Inject
    lateinit var router: WelcomeViperContract.WelcomeRouter
    private lateinit var routerToolBox: RouterToolbox
    @Inject
    lateinit var isLoggedIn: CheckIsLoggedInInputPort
    @Inject
    lateinit var login: LogInInputPort
    private var isTheUserLoggedIn: Boolean = false
    private var isTheFirstLoginAttemptWasExecuted: Boolean = false
    private var isAnotherLoginAttemptPreparationNeeded: Boolean = false
    private val bag = CompositeDisposable()

    override fun onFinishInflate(toolbox: RouterToolbox) {
        routerToolBox = toolbox
        router.setToolsForRouting(toolbox)
    }

    override fun onViewCreated(
        view: WelcomeViperContract.WelcomeView,
        isOrientationChanged: Boolean
    ) {
        Timber.d("onViewCreated")
        this.view = view
        isLoggedIn.execute().subscribe { isLoggedIn: Boolean ->
            if (!isOrientationChanged) onLoggingInChecked(isLoggedIn)
            else view.showLoginBtnAndText()
        }.addTo(bag)
    }

    private fun onLoggingInChecked(isLoggedIn: Boolean) {
        Timber.d("onLoggingInChecked")
        isTheUserLoggedIn = isLoggedIn
        if (isLoggedIn) {
            Timber.d("User logged in")
            router.routeToMainMenuActivity()
            return
        } else {
            Timber.d("User don't logged in")
            login.execute(routerToolBox)
        }
        if (!isTheFirstLoginAttemptWasExecuted) isTheFirstLoginAttemptWasExecuted = true
    }

    override fun onResumed() {
        Timber.d("onResumed")
        if (isAnotherLoginAttemptPreparationNeeded) {
            view.showLoginBtnAndText()
        }
        if (!isTheUserLoggedIn && isTheFirstLoginAttemptWasExecuted) {
            isAnotherLoginAttemptPreparationNeeded = true
        }
    }

    override fun onLoginSuccess() {
        router.routeToMainMenuActivity()
    }

    override fun onLoginFailed() {
        with(view) {
            showToast("User didn't pass authorization.")
            showLoginBtnAndText()
        }
    }

    override fun onLoginButtonClicked() {
        Timber.d("onLoginButtonClick")
        isLoggedIn.execute().subscribe { isLoggedIn: Boolean ->
            onLoggingInChecked(isLoggedIn)
        }.addTo(bag)
    }

    override fun onStop() {
        bag.clear()
    }
}
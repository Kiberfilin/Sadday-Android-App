package ru.cyber_eagle_owl.saddayappkt.clean.presentation.features.authorization.viper

import ru.cyber_eagle_owl.saddayappkt.clean.vipercore.ViperPresenter
import ru.cyber_eagle_owl.saddayappkt.clean.vipercore.ViperRouter
import ru.cyber_eagle_owl.saddayappkt.clean.vipercore.ViperView
import ru.cyber_eagle_owl.saddayappkt.utils.wrappers.RouterToolbox

interface WelcomeViperContract {

    interface WelcomeView : ViperView<WelcomePresenter> {

        fun onFinishInflate(toolbox: RouterToolbox, isOrientationChanged: Boolean)
        fun showLoginBtnAndText()
        fun onLoginSuccess()
        fun onLoginFailed()
        fun showToast(toastText: String)
        fun onResume()
        fun onStop()
    }

    interface WelcomePresenter : ViperPresenter {

        var view: WelcomeView

        fun onViewCreated(view: WelcomeView, isOrientationChanged: Boolean)
        fun onFinishInflate(toolbox: RouterToolbox)
        fun onLoginButtonClicked()
        fun onLoginSuccess()
        fun onLoginFailed()
        fun onResumed()
        fun onStop()
    }

    interface WelcomeRouter : ViperRouter {

        fun routeToMainMenuActivity()
    }
}
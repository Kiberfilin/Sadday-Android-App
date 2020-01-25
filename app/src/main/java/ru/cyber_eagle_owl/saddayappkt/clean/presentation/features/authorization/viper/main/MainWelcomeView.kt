package ru.cyber_eagle_owl.saddayappkt.clean.presentation.features.authorization.viper.main

import android.content.Context
import android.view.View
import android.widget.TextView
import android.widget.Toast
import ru.cyber_eagle_owl.saddayappkt.R
import ru.cyber_eagle_owl.saddayappkt.clean.presentation.features.authorization.viper.WelcomeViperContract
import ru.cyber_eagle_owl.saddayappkt.clean.vipercore.BaseView
import ru.cyber_eagle_owl.saddayappkt.utils.wrappers.RouterToolbox
import timber.log.Timber
import javax.inject.Inject

class MainWelcomeView @Inject constructor() : BaseView<WelcomeViperContract.WelcomePresenter>(),
    WelcomeViperContract.WelcomeView {
    private lateinit var welcomeLoginButton: TextView
    private lateinit var welcomeText: TextView
    private var currentToast: Toast? = null
    private lateinit var context: Context

    private fun initViews() {
        Timber.d("initViews()")
        welcomeLoginButton = viperRootView.findViewById(R.id.welcomeLoginButton)
        welcomeText = viperRootView.findViewById(R.id.welcomeText)
        welcomeLoginButton.setOnClickListener { presenter.onLoginButtonClicked() }
    }

    override fun onFinishInflate(toolbox: RouterToolbox, isOrientationChanged: Boolean) {
        Timber.d("onFinishInflate")
        context = toolbox.activityContext()
        initViews()
        presenter.apply {
            onFinishInflate(toolbox)
            onViewCreated(this@MainWelcomeView, isOrientationChanged)
        }
    }

    override fun onLoginSuccess() {
        presenter.onLoginSuccess()
    }

    override fun onLoginFailed() {
        presenter.onLoginFailed()
    }

    override fun showLoginBtnAndText() {
        Timber.d("showLoginBtnAndText()")
        welcomeLoginButton.visibility = View.VISIBLE
        welcomeText.visibility = View.VISIBLE
    }

    override fun onResume() {
        presenter.onResumed()
    }

    override fun onStop() {
        presenter.onStop()
    }

    override fun showToast(toastText: String) {
        currentToast?.let {
            currentToast!!.cancel()
        }
        currentToast = Toast.makeText(context, toastText, Toast.LENGTH_LONG)
        currentToast?.show()
    }
}
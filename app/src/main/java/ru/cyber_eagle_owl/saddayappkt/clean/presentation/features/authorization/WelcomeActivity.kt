package ru.cyber_eagle_owl.saddayappkt.clean.presentation.features.authorization

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.Toast
import com.vk.api.sdk.VK
import com.vk.api.sdk.auth.VKAccessToken
import com.vk.api.sdk.auth.VKAuthCallback
import kotlinx.android.synthetic.main.activity_main.*
import ru.cyber_eagle_owl.saddayappkt.R
import ru.cyber_eagle_owl.saddayappkt.clean.presentation.features.menu.MainMenuActivity
import ru.cyber_eagle_owl.saddayappkt.base.BaseActivity
import timber.log.Timber
import javax.inject.Inject

class WelcomeActivity : BaseActivity(), WelcomeMvp.View {

    @Inject
    lateinit var welcomePresenter: WelcomeMvp.Presenter

    private var currentToast: Toast? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.d("onCreate")

        setContentView(R.layout.activity_main)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            val w: Window = window
            w.setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
            )
        }

        welcomePresenter.onViewCreated()
    }

    override fun onResume() {
        super.onResume()
        Timber.d("onResume")

        welcomePresenter.onResumed()
    }

    override fun onPause() {
        super.onPause()
        Timber.d("onPause")

        welcomePresenter.onPauseLoginHandling()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        Timber.d("onActivityResult")

        val callback = object : VKAuthCallback {
            override fun onLogin(token: VKAccessToken) {
                // User passed authorization
                Timber.d("onLogin, User passed authorization")
                startMainMenu()
            }

            override fun onLoginFailed(errorCode: Int) {
                // User didn't pass authorization
                Timber.d("onLogin, User didn't pass authorization")
            }
        }
        if (data == null || !VK.onActivityResult(requestCode, resultCode, data, callback)) {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }

    override fun showToast(toastText: String) {

        currentToast?.let {
            currentToast!!.cancel()
        }

        currentToast = Toast.makeText(this, toastText, Toast.LENGTH_LONG)
        currentToast!!.show()
    }

    fun onLoginButtonClick(view: View) {
        Timber.d("onLoginButtonClick")

        welcomePresenter.onLoginButtonClick()
    }

    override fun startMainMenu() {
        Timber.d("startMainMenu")

        MainMenuActivity.startFrom(this@WelcomeActivity)
        finish()
    }

    override fun onAnotherLoginAttempt() {
        Timber.d("onAnotherLoginAttempt")

        welcomeLoginButton.visibility = View.VISIBLE
        welcomeText.visibility = View.VISIBLE
    }

    override fun onDestroy() {
        Timber.d("onDestroy")

        welcomePresenter.onDestroy()
        super.onDestroy()
    }

    companion object {

        fun startFrom(context: Context) {
            Timber.d("startFrom")

            val intent = Intent(context, WelcomeActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
            context.startActivity(intent)
        }
    }
}


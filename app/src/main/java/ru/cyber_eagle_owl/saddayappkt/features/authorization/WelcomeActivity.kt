package ru.cyber_eagle_owl.saddayappkt.features.authorization

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.Toast
import com.vk.api.sdk.VK
import com.vk.api.sdk.auth.VKAccessToken
import com.vk.api.sdk.auth.VKAuthCallback
import kotlinx.android.synthetic.main.activity_main.*
import ru.cyber_eagle_owl.saddayappkt.R
import ru.cyber_eagle_owl.saddayappkt.features.menu.MainMenuActivity
import ru.cyber_eagle_owl.saddayappkt.base.BaseActivity
import javax.inject.Inject
import javax.inject.Named

/*
* WelcomeActivity нужна для обработки авторизации пользователя при помощи VK android sdk. При запуске приложения
* надо проверить залогинен пользователь или нет. Если залогинен, то нужно пропустить его дальше (в главное меню).
* Если пользователь не залогинен, то нужно показать ему форму для логина (запустить VK.login) и пока не залогинится
* дальше не пропускать.
*
* процессы - можно прочитать про них в официальной андроид документации
* выучить aral и extentions в котлине*/

class WelcomeActivity : BaseActivity(), WelcomeMvp.View {

    @Inject
    lateinit var welcomePresenter: WelcomeMvp.Presenter

    @Inject
    @field:Named("example")
    lateinit var exampleString: String

    @Inject
    @field:Named("example2")
    lateinit var exampleString2: String

    private val logTag: String = "WelcomeActivity"

    private var currentToast: Toast? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(logTag, "onCreate")

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
        Log.d(logTag, "onResume")

        welcomePresenter.onResumed()
    }

    override fun onPause() {
        super.onPause()
        Log.d(logTag, "onPause")

        welcomePresenter.onPauseLoginHandling()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        Log.d(logTag, "onActivityResult")

        val callback = object : VKAuthCallback {
            override fun onLogin(token: VKAccessToken) {
                // User passed authorization
                Log.d(logTag, "onLogin, User passed authorization")
                startMainMenu()
            }

            override fun onLoginFailed(errorCode: Int) {
                // User didn't pass authorization
                Log.d(logTag, "onLogin, User didn't pass authorization")
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

    override fun showInjects() {
        Log.e("WelcomeActivity", "====== INJECT TEST ======")
        Log.e("WelcomeActivity", exampleString)
        Log.e("WelcomeActivity", exampleString2)
        Log.e("WelcomeActivity", "====== INJECT TEST ======")
    }

    fun onLoginButtonClick(view: View) {
        Log.d(logTag, "onLoginButtonClick")

        welcomePresenter.onLoginButtonClick()
    }

    override fun startMainMenu() {
        Log.d(logTag, "startMainMenu")

        MainMenuActivity.startFrom(this@WelcomeActivity)
        finish()
    }

    override fun onAnotherLoginAttempt() {
        Log.d(logTag, "onAnotherLoginAttempt")

        welcomeLoginButton.visibility = View.VISIBLE
        welcomeText.visibility = View.VISIBLE
    }

    override fun onDestroy() {
        Log.d(logTag, "onDestroy")

        welcomePresenter.onDestroy()
        super.onDestroy()
    }

    companion object {

        fun startFrom(context: Context) {
            Log.d("WelcomeActivity", "startFrom")

            val intent = Intent(context, WelcomeActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
            context.startActivity(intent)
        }
    }
}


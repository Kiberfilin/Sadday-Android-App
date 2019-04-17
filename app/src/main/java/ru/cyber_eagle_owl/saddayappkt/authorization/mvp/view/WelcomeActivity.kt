package ru.cyber_eagle_owl.saddayappkt.authorization.mvp.view

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import com.vk.api.sdk.VK
import com.vk.api.sdk.auth.VKAccessToken
import com.vk.api.sdk.auth.VKAuthCallback
import com.vk.api.sdk.auth.VKScope
import kotlinx.android.synthetic.main.activity_main.*
import ru.cyber_eagle_owl.saddayappkt.App
import ru.cyber_eagle_owl.saddayappkt.MainMenuActivity
import ru.cyber_eagle_owl.saddayappkt.R
import ru.cyber_eagle_owl.saddayappkt.authorization.di.components.WelcomeActivitySubComponent
import ru.cyber_eagle_owl.saddayappkt.authorization.di.modules.WelcomeActivityModule
import ru.cyber_eagle_owl.saddayappkt.authorization.di.modules.WelcomeActivityPresenterModule
import ru.cyber_eagle_owl.saddayappkt.authorization.mvp.presenter.WelcomeActivityPresenter
import ru.cyber_eagle_owl.saddayappkt.mvpcore.activity.BaseActivity
import javax.inject.Inject

/*
* WelcomeActivity нужна для обработки авторизации пользователя при помощи VK android sdk. При запуске приложения
* надо проверить залогинен пользователь или нет. Если залогинен, то нужно пропустить его дальше (в главное меню).
* Если пользователь не залогинен, то нужно показать ему форму для логина (запустить VK.login) и пока не залогинится
* дальше не пропускать.
*
* процессы - можно прочитать про них в официальной андроид документации
* выучить aral и extentions в котлине*/

class WelcomeActivity : BaseActivity(), WelcomeActivityMvpView {

    private var isItTheFirstTryToLoginAfterActivityWasCreated: Boolean = true

    private var welcomeActivityComponent: WelcomeActivitySubComponent? = null

    @Inject lateinit var welcomeActivityPresenter: WelcomeActivityPresenter<WelcomeActivityMvpView>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        prepareDependencyInjection()

        welcomeActivityPresenter.onAttach(this)

        //region onCreateLoginHandling -> presenter
        if (VK.isLoggedIn()) {
            MainMenuActivity.startFrom(this)
            finishActivity()
            return
        } else {
            VK.login(this, arrayListOf(VKScope.WALL, VKScope.PHOTOS))
        }
        //endregion
    }

    override fun onResume() {
        super.onResume()
        //region onResumeLoginHandling -> presenter
        if (VK.isLoggedIn()) {
            MainMenuActivity.startFrom(this)
            finishActivity()
            return
        } else if (!VK.isLoggedIn() && !isItTheFirstTryToLoginAfterActivityWasCreated){
            viewsVisibilityHandling()
        }
        //endregion
    }

    override fun onPause() {
        super.onPause()
        //region onPauseLoginHandling
        if (!VK.isLoggedIn() && isItTheFirstTryToLoginAfterActivityWasCreated) {
            isItTheFirstTryToLoginAfterActivityWasCreated = false
        }
        //endregion
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val callback = object : VKAuthCallback {
            override fun onLogin(token: VKAccessToken) {
                // User passed authorization
                MainMenuActivity.startFrom(this@WelcomeActivity)
                finishActivity()
            }

            override fun onLoginFailed(errorCode: Int) {
                // User didn't pass authorization
            }
        }
        if (data == null || !VK.onActivityResult(requestCode, resultCode, data, callback)) {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }

    override fun prepareDependencyInjection() {
        if (welcomeActivityComponent == null) {
            welcomeActivityComponent = App.getAppComponent().
                newWelcomeActivityComponent(WelcomeActivityModule(this), WelcomeActivityPresenterModule())
        }
        welcomeActivityComponent!!.inject(this)
    }

    override fun viewsVisibilityHandling() {
        welcome_login_button.visibility = View.VISIBLE
        welcome_text.visibility = View.VISIBLE
    }

    override fun screenPreparation() {
        setContentView(R.layout.activity_main)
        //todo move Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT to presenter
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            val w: Window = window
            w.setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
            )
        }
    }

    override fun finishActivity() {
        finish()
    }

    fun onLoginButtonClick(view: View) {
        VK.login(this, arrayListOf(VKScope.WALL, VKScope.PHOTOS))
    }

    companion object {
        fun startFrom(context: Context) {
            val intent = Intent(context, WelcomeActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
            context.startActivity(intent)
        }
    }
}

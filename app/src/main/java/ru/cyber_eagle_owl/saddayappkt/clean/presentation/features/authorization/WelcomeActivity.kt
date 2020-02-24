package ru.cyber_eagle_owl.saddayappkt.clean.presentation.features.authorization

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import com.vk.api.sdk.VK
import com.vk.api.sdk.auth.VKAccessToken
import com.vk.api.sdk.auth.VKAuthCallback
import ru.cyber_eagle_owl.saddayappkt.R
import ru.cyber_eagle_owl.saddayappkt.base.BaseActivity
import ru.cyber_eagle_owl.saddayappkt.clean.presentation.features.authorization.viper.WelcomeViperContract
import timber.log.Timber
import javax.inject.Inject

class WelcomeActivity : BaseActivity() {
    @Inject
    lateinit var welcomeView: WelcomeViperContract.WelcomeView
    var isOrientationChanged: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.d("onCreate")
        isOrientationChanged = savedInstanceState != null
        val rootView = LayoutInflater.from(this).inflate(R.layout.activity_main, null)
        setContentView(rootView)
        prepareScreen()
        welcomeView.apply {
            setRootView(rootView)
            onFinishInflate(getRouterToolbox(), isOrientationChanged)
        }
    }

    override fun onResume() {
        super.onResume()
        Timber.d("onResume")
        welcomeView.onResume()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        Timber.d("onActivityResult")
        val callback = object : VKAuthCallback {
            override fun onLogin(token: VKAccessToken) {
                // User passed authorization
                Timber.d("onLogin, User passed authorization")
                welcomeView.onLoginSuccess()
            }
            override fun onLoginFailed(errorCode: Int) {
                // User didn't pass authorization
                Timber.d("onLogin, User didn't pass authorization")
                welcomeView.onLoginFailed()
            }
        }
        if (data == null || !VK.onActivityResult(requestCode, resultCode, data, callback)) {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }

    override fun onStop() {
        welcomeView.onStop()
        super.onStop()
    }

    companion object {
        fun startFrom(context: Context) { // используется в App
            Timber.d("startFrom")
            val intent = Intent(context, WelcomeActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
            context.startActivity(intent)
        }
    }
}


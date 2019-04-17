package ru.cyber_eagle_owl.saddayappkt

import android.app.Application
import com.vk.api.sdk.VK
import com.vk.api.sdk.VKTokenExpiredHandler
import ru.cyber_eagle_owl.saddayappkt.authorization.mvp.view.WelcomeActivity
import ru.cyber_eagle_owl.saddayappkt.diglobal.components.AppComponent
import ru.cyber_eagle_owl.saddayappkt.diglobal.components.DaggerAppComponent
import ru.cyber_eagle_owl.saddayappkt.diglobal.modules.AppModule

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        prepareApplication()
        prepareDependencyInjection()
        prepareVkSdk()
    }
    private fun prepareApplication() {
        app = this
    }

    private fun prepareDependencyInjection() {
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
    }

    private fun prepareVkSdk() {
        VK.addTokenExpiredHandler(tokenTracker)
    }

    private val tokenTracker = object: VKTokenExpiredHandler {
        override fun onTokenExpired() {
            WelcomeActivity.startFrom(this@App)
        }
    }

    companion object {

        private lateinit var appComponent: AppComponent
        private lateinit var app: App

        fun getAppComponent(): AppComponent {
            return appComponent
        }

        fun getApp(): App {
            return app
        }
    }
}
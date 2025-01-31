package ru.cyber_eagle_owl.saddayappkt

import com.vk.api.sdk.VK
import com.vk.api.sdk.VKTokenExpiredHandler
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import ru.cyber_eagle_owl.saddayappkt.clean.presentation.features.authorization.WelcomeActivity
import ru.cyber_eagle_owl.saddayappkt.di.AppComponent
import ru.cyber_eagle_owl.saddayappkt.di.AppModule
import ru.cyber_eagle_owl.saddayappkt.di.DaggerAppComponent
import timber.log.Timber

class App : DaggerApplication() {

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        prepareTimber()
        prepareVkSdk()
    }

    private fun prepareTimber() {
        Timber.plant(Timber.DebugTree())
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        //@Deprecated after filling applicationGraph @Deprecated will be removed
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
        return appComponent
    }

    private fun prepareVkSdk() {
        VK.addTokenExpiredHandler(tokenTracker)
    }

    private val tokenTracker = object: VKTokenExpiredHandler {
        override fun onTokenExpired() {
            WelcomeActivity.startFrom(this@App)
        }
    }
}
package ru.cyber_eagle_owl.saddayappkt.authorization.di.modules

import android.content.Context
import dagger.Module
import dagger.Provides
import ru.cyber_eagle_owl.saddayappkt.authorization.mvp.view.WelcomeActivityMvpView
import ru.cyber_eagle_owl.saddayappkt.diglobal.scopes.WelcomeActivityScope

@Module
class WelcomeActivityModule(private val welcomeActivity: Context) {

    @Provides
    @WelcomeActivityScope
    fun provideActivityContext(): Context {
        return welcomeActivity
    }
}
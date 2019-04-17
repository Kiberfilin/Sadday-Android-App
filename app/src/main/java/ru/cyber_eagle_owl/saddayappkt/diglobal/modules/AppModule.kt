package ru.cyber_eagle_owl.saddayappkt.diglobal.modules

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import ru.cyber_eagle_owl.saddayappkt.diglobal.scopes.ApplicationScope

@Module
class AppModule(val app: Context) {

    private val applicationContext: Context = app

    @Provides
    @ApplicationScope
    fun provideAppContext(): Context {
        return applicationContext
    }
}
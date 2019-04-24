package ru.cyber_eagle_owl.saddayappkt.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.android.support.DaggerApplication
import ru.cyber_eagle_owl.saddayappkt.di.scopes.ApplicationScope

@Module
class AppModule(private val application: DaggerApplication) {

    @Provides
    @ApplicationScope
    fun provideApplicationContext(): Context = application.applicationContext
}
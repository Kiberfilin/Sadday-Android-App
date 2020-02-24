package ru.cyber_eagle_owl.saddayappkt.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.android.support.DaggerApplication
import ru.cyber_eagle_owl.saddayappkt.di.scopes.ApplicationScope
import ru.cyber_eagle_owl.saddayappkt.utils.helpers.ResourcesHelper
import ru.cyber_eagle_owl.saddayappkt.utils.helpers.SharedPreferencesHelper
import timber.log.Timber

@Module
class AppModule(private val application: DaggerApplication) {

    @Provides
    @ApplicationScope
    fun provideApplicationContext(): Context = application.applicationContext

    @Provides
    @ApplicationScope
    fun provideSharedPreferencesHelper(context: Context): SharedPreferencesHelper {
        return SharedPreferencesHelper(
            context.getSharedPreferences(
                "SADDAY APP",
                Context.MODE_PRIVATE
            )
        )
    }

    @Provides
    @ApplicationScope
    fun provideResourcesHelper(context: Context): ResourcesHelper {
        Timber.d("***provideResourcesHelper(context: Context): ResourcesHelper***")
        return ResourcesHelper(context.resources)
    }
}
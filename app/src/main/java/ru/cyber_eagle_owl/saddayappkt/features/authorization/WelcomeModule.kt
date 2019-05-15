package ru.cyber_eagle_owl.saddayappkt.features.authorization

import dagger.Binds
import dagger.Module
import dagger.Provides
import ru.cyber_eagle_owl.saddayappkt.di.scopes.ActivityScope
import ru.cyber_eagle_owl.saddayappkt.utils.AuthorizationHelper
import ru.cyber_eagle_owl.saddayappkt.utils.VkAuthorizationHelper
import javax.inject.Named

@Module
abstract class WelcomeModule {

    @Binds
    @ActivityScope
    abstract fun view(activity: WelcomeActivity): WelcomeMvp.View

    @Binds
    @ActivityScope
    abstract fun presenter(presenter: WelcomePresenter): WelcomeMvp.Presenter

    @Binds
    @ActivityScope
    abstract fun welcomeRepo(welcomeRepo: WelcomeRepo): WelcomeMvp.Model

    @Binds
    @ActivityScope
    abstract fun authorizationHelper(authorizationHelper: VkAuthorizationHelper): AuthorizationHelper

    @Module
    companion object {
        @JvmStatic @Provides @Named("example") fun provideExampleString(): String = "Я Inject String ☺"
        @JvmStatic @Provides @Named("example2") fun provideExampleString2(): String = "Я Inject String ☺"
    }
}

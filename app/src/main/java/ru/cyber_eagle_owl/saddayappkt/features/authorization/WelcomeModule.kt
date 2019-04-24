package ru.cyber_eagle_owl.saddayappkt.features.authorization

import dagger.Binds
import dagger.Module
import dagger.Provides
import ru.cyber_eagle_owl.saddayappkt.di.scopes.ActivityScope
import javax.inject.Named

@Module
abstract class WelcomeModule {

    @Binds
    @ActivityScope
    abstract fun view(activity: WelcomeActivity): WelcomeMvp.View

    @Binds
    @ActivityScope
    abstract fun presenter(presenter: WelcomePresenter): WelcomeMvp.Presenter

    @Module
    companion object {
        @JvmStatic @Provides @Named("example") fun provideExampleString(): String = "Я Inject String ☺"
        @JvmStatic @Provides @Named("example2") fun provideExampleString2(): String = "Я Inject String ☺ ☺"
    }
}

package ru.cyber_eagle_owl.saddayappkt.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ru.cyber_eagle_owl.saddayappkt.di.scopes.ActivityScope
import ru.cyber_eagle_owl.saddayappkt.features.authorization.WelcomeActivity
import ru.cyber_eagle_owl.saddayappkt.features.authorization.WelcomeModule
import ru.cyber_eagle_owl.saddayappkt.features.menu.MainMenuActivity
import ru.cyber_eagle_owl.saddayappkt.features.menu.MainMenuModule

@Module
abstract class ActivityBindingModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [WelcomeModule::class, MainMenuModule::class])
    abstract fun bindWelcomeActivity(): WelcomeActivity

    abstract fun bindMainMenuActivity(): MainMenuActivity
}
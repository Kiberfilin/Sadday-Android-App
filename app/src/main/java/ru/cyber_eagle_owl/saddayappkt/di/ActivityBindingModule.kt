package ru.cyber_eagle_owl.saddayappkt.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ru.cyber_eagle_owl.saddayappkt.di.scopes.ActivityScope
import ru.cyber_eagle_owl.saddayappkt.features.authorization.WelcomeActivity
import ru.cyber_eagle_owl.saddayappkt.features.authorization.WelcomeModule

@Module
abstract class ActivityBindingModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [WelcomeModule::class])
    abstract fun bindWelcomeActivity(): WelcomeActivity
}
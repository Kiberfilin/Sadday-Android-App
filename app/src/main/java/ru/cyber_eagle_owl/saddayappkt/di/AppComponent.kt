package ru.cyber_eagle_owl.saddayappkt.di

import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import ru.cyber_eagle_owl.saddayappkt.App
import ru.cyber_eagle_owl.saddayappkt.di.scopes.ApplicationScope

@ApplicationScope
@Component(modules = [
    AppModule::class,
    ActivityBindingModule::class,
    AndroidSupportInjectionModule::class])

interface AppComponent : AndroidInjector<App>
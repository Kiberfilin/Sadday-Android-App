package ru.cyber_eagle_owl.saddayappkt.diglobal.components

import dagger.Component
import ru.cyber_eagle_owl.saddayappkt.authorization.di.components.WelcomeActivitySubComponent
import ru.cyber_eagle_owl.saddayappkt.authorization.di.modules.WelcomeActivityModule
import ru.cyber_eagle_owl.saddayappkt.authorization.di.modules.WelcomeActivityPresenterModule
import ru.cyber_eagle_owl.saddayappkt.diglobal.modules.AppModule
import ru.cyber_eagle_owl.saddayappkt.diglobal.scopes.ApplicationScope

@ApplicationScope
@Component(modules = [AppModule::class])
interface AppComponent {

    fun newWelcomeActivityComponent(welcomeActivityModule: WelcomeActivityModule,
                                    welcomeActivityPresenterModule: WelcomeActivityPresenterModule): WelcomeActivitySubComponent
}
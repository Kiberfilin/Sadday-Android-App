package ru.cyber_eagle_owl.saddayappkt.authorization.di.components

import dagger.Subcomponent
import ru.cyber_eagle_owl.saddayappkt.authorization.di.modules.AuthorizationHandlerModule
import ru.cyber_eagle_owl.saddayappkt.authorization.di.modules.WelcomeActivityModule
import ru.cyber_eagle_owl.saddayappkt.authorization.di.modules.WelcomeActivityPresenterModule
import ru.cyber_eagle_owl.saddayappkt.authorization.mvp.view.WelcomeActivity
import ru.cyber_eagle_owl.saddayappkt.diglobal.scopes.WelcomeActivityScope

@WelcomeActivityScope
@Subcomponent(modules = [WelcomeActivityModule::class, AuthorizationHandlerModule::class, WelcomeActivityPresenterModule::class])
interface WelcomeActivitySubComponent {

    fun inject(welcomeActivity: WelcomeActivity)
}
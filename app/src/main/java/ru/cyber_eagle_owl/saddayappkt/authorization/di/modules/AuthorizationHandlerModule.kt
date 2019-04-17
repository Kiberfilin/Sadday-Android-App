package ru.cyber_eagle_owl.saddayappkt.authorization.di.modules

import dagger.Module
import dagger.Provides
import ru.cyber_eagle_owl.saddayappkt.authorization.utils.AuthorizationHandler
import ru.cyber_eagle_owl.saddayappkt.diglobal.scopes.WelcomeActivityScope
import ru.cyber_eagle_owl.saddayappkt.mvpcore.activity.interfaces.MvpActivityView

@Module
class AuthorizationHandlerModule {

    @Provides
    @WelcomeActivityScope
    fun provideAuthorizationHandler(): AuthorizationHandler<MvpActivityView> {
        return AuthorizationHandler()
    }
}
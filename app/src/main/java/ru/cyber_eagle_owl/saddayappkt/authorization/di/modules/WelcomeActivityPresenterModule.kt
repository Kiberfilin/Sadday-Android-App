package ru.cyber_eagle_owl.saddayappkt.authorization.di.modules

import dagger.Module
import dagger.Provides
import ru.cyber_eagle_owl.saddayappkt.authorization.mvp.presenter.WelcomeActivityPresenter
import ru.cyber_eagle_owl.saddayappkt.authorization.mvp.view.WelcomeActivityMvpView
import ru.cyber_eagle_owl.saddayappkt.authorization.utils.AuthorizationHandler
import ru.cyber_eagle_owl.saddayappkt.diglobal.scopes.WelcomeActivityScope

@Module
class WelcomeActivityPresenterModule {

    @Provides
    @WelcomeActivityScope
    fun provideWelcomeActivityPresenter(): WelcomeActivityPresenter<WelcomeActivityMvpView> {
        return WelcomeActivityPresenter(AuthorizationHandler())
    }
}

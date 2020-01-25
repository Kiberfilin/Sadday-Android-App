package ru.cyber_eagle_owl.saddayappkt.clean.presentation.features.authorization

import dagger.Binds
import dagger.Module
import ru.cyber_eagle_owl.saddayappkt.clean.data.repositories.VkAuthorizationRepository
import ru.cyber_eagle_owl.saddayappkt.clean.domain.boundaries.presenter.inputports.CheckIsLoggedInInputPort
import ru.cyber_eagle_owl.saddayappkt.clean.domain.boundaries.presenter.inputports.LogInInputPort
import ru.cyber_eagle_owl.saddayappkt.clean.domain.boundaries.repository.inputports.AuthorizationRepositoryInputPort
import ru.cyber_eagle_owl.saddayappkt.clean.domain.interactors.CheckIsLoggedInInteractor
import ru.cyber_eagle_owl.saddayappkt.clean.domain.interactors.LogInInteractor
import ru.cyber_eagle_owl.saddayappkt.clean.presentation.features.authorization.viper.WelcomeViperContract
import ru.cyber_eagle_owl.saddayappkt.clean.presentation.features.authorization.viper.main.MainWelcomePresenter
import ru.cyber_eagle_owl.saddayappkt.clean.presentation.features.authorization.viper.main.MainWelcomeRouter
import ru.cyber_eagle_owl.saddayappkt.clean.presentation.features.authorization.viper.main.MainWelcomeView
import ru.cyber_eagle_owl.saddayappkt.di.scopes.ActivityScope

@Module
abstract class WelcomeModule {

    @Binds
    @ActivityScope
    abstract fun welcomeMainView(viewMain: MainWelcomeView): WelcomeViperContract.WelcomeView

    @Binds
    @ActivityScope
    abstract fun welcomeMainPresenter(presenterMain: MainWelcomePresenter): WelcomeViperContract.WelcomePresenter

    @Binds
    @ActivityScope
    abstract fun welcomeMainRouter(routerMain: MainWelcomeRouter): WelcomeViperContract.WelcomeRouter

    @Binds
    @ActivityScope
    abstract fun checkIsLoggedInInteractor(interactor: CheckIsLoggedInInteractor): CheckIsLoggedInInputPort

    @Binds
    @ActivityScope
    abstract fun logInInteractor(interactor: LogInInteractor): LogInInputPort

    @Binds
    @ActivityScope
    abstract fun authRepo(authorizationRepository: VkAuthorizationRepository): AuthorizationRepositoryInputPort
}

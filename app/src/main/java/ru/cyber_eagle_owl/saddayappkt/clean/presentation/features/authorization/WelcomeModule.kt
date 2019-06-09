package ru.cyber_eagle_owl.saddayappkt.clean.presentation.features.authorization

import dagger.Binds
import dagger.Module
import ru.cyber_eagle_owl.saddayappkt.di.scopes.ActivityScope

@Module
abstract class WelcomeModule {

    @Binds
    @ActivityScope
    abstract fun view(activity: WelcomeActivity): WelcomeMvp.View

    @Binds
    @ActivityScope
    abstract fun presenter(presenter: WelcomePresenter): WelcomeMvp.Presenter

/*    @Binds
    @ActivityScope
    abstract fun isLoggedInOutput(presenter: WelcomePresenter): CheckIsLoggedInOutputPort

    @Binds
    @ActivityScope
    abstract fun checkIsLoggedInInteractor(isLoggedIn: CheckIsLoggedInInteractor): CheckIsLoggedInInputPort

    @Binds
    @ActivityScope
    abstract fun logInInteractor(logIn: LogInInteractor): LogInInputPort

    @Binds
    @ActivityScope
    abstract fun authorizationRepo(authRepo: VkAuthorizationRepository): AuthorizationRepositoryInputPort
*/
}

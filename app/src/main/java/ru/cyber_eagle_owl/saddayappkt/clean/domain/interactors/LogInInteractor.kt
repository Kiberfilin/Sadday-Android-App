package ru.cyber_eagle_owl.saddayappkt.clean.domain.interactors

import ru.cyber_eagle_owl.saddayappkt.clean.domain.boundaries.presenter.inputports.LogInInputPort
import ru.cyber_eagle_owl.saddayappkt.clean.presentation.mvpcore.MvpView
import ru.cyber_eagle_owl.saddayappkt.clean.domain.boundaries.repository.inputports.AuthorizationRepositoryInputPort
import timber.log.Timber

class LogInInteractor(private val authRepo: AuthorizationRepositoryInputPort) : LogInInputPort {

    override fun execute(mvpView: MvpView) {
        Timber.d("execute(mvpView: MvpView)")

        authRepo.login(mvpView)
    }
}
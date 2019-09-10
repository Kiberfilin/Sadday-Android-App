package ru.cyber_eagle_owl.saddayappkt.clean.domain.interactors

import ru.cyber_eagle_owl.saddayappkt.clean.domain.boundaries.presenter.inputports.CheckIsLoggedInInputPort
import ru.cyber_eagle_owl.saddayappkt.clean.domain.boundaries.presenter.outputports.CheckIsLoggedInOutputPort
import ru.cyber_eagle_owl.saddayappkt.clean.domain.boundaries.repository.inputports.AuthorizationRepositoryInputPort
import ru.cyber_eagle_owl.saddayappkt.clean.domain.boundaries.repository.outputports.AuthorizationRepositoryOutputPort
import timber.log.Timber

class CheckIsLoggedInInteractor(
    private val presentationOutputPort: CheckIsLoggedInOutputPort,
    private val dataInputPort: AuthorizationRepositoryInputPort
) : CheckIsLoggedInInputPort, AuthorizationRepositoryOutputPort {

    init {
        Timber.d("init")

        dataInputPort.setOutputPort(this)
    }

    override fun isLoggedInResult(result: Boolean) {
        Timber.d("isLoggedInResult(result: Boolean)")

        presentationOutputPort.onLoggingInChecked(result)
    }

    override fun execute() {
        Timber.d("execute()")

        dataInputPort.isLoggedIn()
    }
}
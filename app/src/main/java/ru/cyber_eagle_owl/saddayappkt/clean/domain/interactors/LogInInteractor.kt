package ru.cyber_eagle_owl.saddayappkt.clean.domain.interactors

import ru.cyber_eagle_owl.saddayappkt.clean.domain.boundaries.presenter.inputports.LogInInputPort
import ru.cyber_eagle_owl.saddayappkt.clean.domain.boundaries.repository.inputports.AuthorizationRepositoryInputPort
import ru.cyber_eagle_owl.saddayappkt.utils.wrappers.RouterToolbox
import timber.log.Timber
import javax.inject.Inject

class LogInInteractor @Inject constructor() : LogInInputPort {

    @Inject
    lateinit var dataInputPort: AuthorizationRepositoryInputPort

    override fun execute(routerToolBox: RouterToolbox) {
        Timber.d("execute(routerToolBox: RouterToolbox)")
        dataInputPort.login(routerToolBox)
    }
}
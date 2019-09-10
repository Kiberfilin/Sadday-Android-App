package ru.cyber_eagle_owl.saddayappkt.clean.domain.boundaries.repository.inputports

import ru.cyber_eagle_owl.saddayappkt.clean.domain.boundaries.repository.outputports.AuthorizationRepositoryOutputPort
import ru.cyber_eagle_owl.saddayappkt.clean.presentation.mvpcore.MvpView

interface AuthorizationRepositoryInputPort {

    fun setOutputPort(outputPort: AuthorizationRepositoryOutputPort)

    fun isLoggedIn()

    fun login(mvpView: MvpView)
}
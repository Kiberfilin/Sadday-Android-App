package ru.cyber_eagle_owl.saddayappkt.clean.domain.boundaries.repository.inputports

import io.reactivex.Single
import ru.cyber_eagle_owl.saddayappkt.utils.wrappers.RouterToolbox

interface AuthorizationRepositoryInputPort {
    fun isLoggedIn(): Single<Boolean>
    fun login(routerToolBox: RouterToolbox)
}
package ru.cyber_eagle_owl.saddayappkt.clean.domain.boundaries.presenter.inputports

import io.reactivex.Single

interface CheckIsLoggedInInputPort {

    fun execute(): Single<Boolean>
}
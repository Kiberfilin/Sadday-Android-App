package ru.cyber_eagle_owl.saddayappkt.clean.domain.boundaries.presenter.inputports

import ru.cyber_eagle_owl.saddayappkt.clean.presentation.mvpcore.MvpView

interface LogInInputPort {

    fun execute(mvpView: MvpView)
}
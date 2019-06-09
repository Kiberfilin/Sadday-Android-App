package ru.cyber_eagle_owl.saddayappkt.clean.domain.boundaries.presenter.outputports

interface CheckIsLoggedInOutputPort {

    fun onLoggingInChecked(isLoggedIn: Boolean)
}
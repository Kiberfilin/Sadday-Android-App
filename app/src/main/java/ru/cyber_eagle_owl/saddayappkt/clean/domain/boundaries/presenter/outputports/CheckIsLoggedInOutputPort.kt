package ru.cyber_eagle_owl.saddayappkt.clean.domain.boundaries.presenter.outputports
@Deprecated("внедрить RxKotlin")
interface CheckIsLoggedInOutputPort {
    fun onLoggingInChecked(isLoggedIn: Boolean)
}
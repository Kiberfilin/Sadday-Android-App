package ru.cyber_eagle_owl.saddayappkt.clean.domain.interactors

import io.reactivex.Single
import ru.cyber_eagle_owl.saddayappkt.clean.domain.boundaries.presenter.inputports.CheckIsLoggedInInputPort
import ru.cyber_eagle_owl.saddayappkt.clean.domain.boundaries.repository.inputports.AuthorizationRepositoryInputPort
import timber.log.Timber
import javax.inject.Inject

class CheckIsLoggedInInteractor @Inject constructor(
    //private val presentationOutputPort: CheckIsLoggedInOutputPort,
    ) : CheckIsLoggedInInputPort { //, AuthorizationRepositoryOutputPort {

    @Inject
    lateinit var dataInputPort: AuthorizationRepositoryInputPort

    /*init {
        Timber.d("init")
        dataInputPort.setOutputPort(this)
    }
*/
    /*override fun isLoggedInResult(result: Boolean) {
        Timber.d("isLoggedInResult(result: Boolean)")
        presentationOutputPort.onLoggingInChecked(result)
    }*/

    override fun execute(): Single<Boolean> {
        Timber.d("execute(): Single<Boolean>")
        return dataInputPort.isLoggedIn()
    }
}
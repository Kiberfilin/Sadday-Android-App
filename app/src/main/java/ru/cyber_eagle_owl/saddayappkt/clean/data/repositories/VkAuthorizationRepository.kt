package ru.cyber_eagle_owl.saddayappkt.clean.data.repositories

import android.app.Activity
import com.vk.api.sdk.VK
import ru.cyber_eagle_owl.saddayappkt.clean.domain.boundaries.repository.inputports.AuthorizationRepositoryInputPort
import ru.cyber_eagle_owl.saddayappkt.clean.domain.boundaries.repository.outputports.AuthorizationRepositoryOutputPort
import ru.cyber_eagle_owl.saddayappkt.constants.VkConstants
import ru.cyber_eagle_owl.saddayappkt.clean.presentation.mvpcore.MvpView
import timber.log.Timber

class VkAuthorizationRepository :
    AuthorizationRepositoryInputPort {

    private var interactor: AuthorizationRepositoryOutputPort? = null

    override fun setOutputPort(outputPort: AuthorizationRepositoryOutputPort) {
        Timber.d("setOutputPort")

        interactor = outputPort
    }

    override fun isLoggedIn() {
        Timber.d("isLoggedIn()")

        interactor?.isLoggedInResult(VK.isLoggedIn())
    }

    override fun login(mvpView: MvpView) {
        Timber.d("login(mvpView: MvpView)")

        VK.login(mvpView as Activity, VkConstants.DEFAULT_LOGIN_SCOPE)
    }

}
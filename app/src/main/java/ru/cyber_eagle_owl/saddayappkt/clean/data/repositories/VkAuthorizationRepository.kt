package ru.cyber_eagle_owl.saddayappkt.clean.data.repositories

import android.app.Activity
import com.vk.api.sdk.VK
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ru.cyber_eagle_owl.saddayappkt.clean.domain.boundaries.repository.inputports.AuthorizationRepositoryInputPort
import ru.cyber_eagle_owl.saddayappkt.constants.VkConstants
import ru.cyber_eagle_owl.saddayappkt.utils.wrappers.RouterToolbox
import timber.log.Timber
import javax.inject.Inject

class VkAuthorizationRepository @Inject constructor(): AuthorizationRepositoryInputPort {
    override fun isLoggedIn(): Single<Boolean> {
        Timber.d("isLoggedIn(): Single<Boolean>")
        return Single.just(VK.isLoggedIn())
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    override fun login(routerToolBox: RouterToolbox) {
        Timber.d("login(mvpView: MvpView)")
        VK.login(routerToolBox.activityContext() as Activity, VkConstants.DEFAULT_LOGIN_SCOPE)
    }
}
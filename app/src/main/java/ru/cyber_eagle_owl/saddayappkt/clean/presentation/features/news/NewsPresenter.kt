package ru.cyber_eagle_owl.saddayappkt.clean.presentation.features.news

import ru.cyber_eagle_owl.saddayappkt.clean.presentation.mvpcore.BasePresenter
import timber.log.Timber
import javax.inject.Inject

class NewsPresenter @Inject constructor() : BasePresenter<NewsMvp.View>(), NewsMvp.Presenter {

    override fun onViewCreated() {
        Timber.d("onViewCreated()")

    }
}
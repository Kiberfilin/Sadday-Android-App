package ru.cyber_eagle_owl.saddayappkt.clean.presentation.features.place.viper.main

import ru.cyber_eagle_owl.saddayappkt.clean.presentation.features.place.viper.PlaceMainViperContract
import ru.cyber_eagle_owl.saddayappkt.clean.presentation.vipercore.BaseView
import ru.cyber_eagle_owl.saddayappkt.utils.wrappers.RouterToolbox
import timber.log.Timber
import javax.inject.Inject

class PlaceActivityView @Inject constructor() : BaseView<PlaceMainViperContract.MainPresenter>(),
    PlaceMainViperContract.MainView {

    override fun onFinishInflate() {
        Timber.d("onResume()")
        initViews()
        presenter.onViewCreated(this)
    }

    override fun onResume(toolbox: RouterToolbox) {
        presenter.onResume(toolbox)
    }

    private fun initViews() {
        Timber.d("initViews()")
        //todo
    }
}
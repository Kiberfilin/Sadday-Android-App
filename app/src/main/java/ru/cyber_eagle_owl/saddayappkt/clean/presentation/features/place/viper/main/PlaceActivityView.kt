package ru.cyber_eagle_owl.saddayappkt.clean.presentation.features.place.viper.main

import ru.cyber_eagle_owl.saddayappkt.clean.presentation.features.place.viper.PlaceMainViperContract
import ru.cyber_eagle_owl.saddayappkt.clean.presentation.vipercore.BaseView
import ru.cyber_eagle_owl.saddayappkt.utils.wrappers.RouterToolbox
import timber.log.Timber
import javax.inject.Inject

class PlaceActivityView @Inject constructor() : BaseView<PlaceMainViperContract.MainPresenter>(),
    PlaceMainViperContract.MainView {

    override fun onFinishInflate(toolbox: RouterToolbox, isOrientationChanged: Boolean) {
        Timber.d("onResume()")
        initViews()
        presenter.apply {
            onViewCreated(this@PlaceActivityView)
            onFinishInflate(toolbox, isOrientationChanged)
        }
    }

    private fun initViews() {
        Timber.d("initViews()")
        //todo
    }
}
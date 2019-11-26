package ru.cyber_eagle_owl.saddayappkt.clean.presentation.features.place.viper.main

import ru.cyber_eagle_owl.saddayappkt.clean.presentation.features.place.viper.PlaceMainViperContract
import ru.cyber_eagle_owl.saddayappkt.clean.presentation.vipercore.BasePresenter
import ru.cyber_eagle_owl.saddayappkt.utils.wrappers.RouterToolbox
import timber.log.Timber
import javax.inject.Inject

class PlaceActivityPresenter @Inject constructor() : BasePresenter(),
    PlaceMainViperContract.MainPresenter {

    override lateinit var view: PlaceMainViperContract.MainView

    @Inject
    lateinit var router: PlaceMainViperContract.MainRouter

    override fun onFinishInflate(toolbox: RouterToolbox, isOrientationChanged: Boolean) {
        router.setToolsForRouting(toolbox)
        if (!isOrientationChanged) router.addPlacesListingFragment()
    }

    override fun onViewCreated(view: PlaceMainViperContract.MainView) {
        Timber.d("onViewCreated()")
        this.view = view
    }
}
package ru.cyber_eagle_owl.saddayappkt.clean.presentation.features.place.viper.placeslistingfragment

import ru.cyber_eagle_owl.saddayappkt.clean.presentation.features.place.viper.PlacesListingViperContract
import ru.cyber_eagle_owl.saddayappkt.clean.presentation.vipercore.BasePresenter
import ru.cyber_eagle_owl.saddayappkt.utils.wrappers.RouterToolbox
import javax.inject.Inject

class PlacesListingPresenterImpl @Inject constructor() : BasePresenter(),
    PlacesListingViperContract.PlacesListingPresenter {

    override lateinit var view: PlacesListingViperContract.PlacesListingView

    @Inject
    lateinit var router: PlacesListingViperContract.PlacesListingRouter

    override fun onViewCreated(view: PlacesListingViperContract.PlacesListingView) {
        this.view = view
    }

    override fun onStart(toolbox: RouterToolbox) {
        router.setToolsForRouting(toolbox)
    }
}
package ru.cyber_eagle_owl.saddayappkt.clean.presentation.features.place.viper.placeslistingfragment

import ru.cyber_eagle_owl.saddayappkt.clean.presentation.features.place.viper.PlacesListingViperContract
import ru.cyber_eagle_owl.saddayappkt.clean.presentation.vipercore.BaseRouter
import ru.cyber_eagle_owl.saddayappkt.utils.wrappers.RouterToolbox
import javax.inject.Inject

class PlacesListingRouterImpl @Inject constructor() : BaseRouter(),
    PlacesListingViperContract.PlacesListingRouter {

    override fun setToolsForRouting(toolbox: RouterToolbox) {
        this.toolbox = toolbox
    }
}
package ru.cyber_eagle_owl.saddayappkt.clean.presentation.features.place.viper

import ru.cyber_eagle_owl.saddayappkt.clean.presentation.vipercore.ViperPresenter
import ru.cyber_eagle_owl.saddayappkt.clean.presentation.vipercore.ViperRouter
import ru.cyber_eagle_owl.saddayappkt.clean.presentation.vipercore.ViperView
import ru.cyber_eagle_owl.saddayappkt.utils.wrappers.RouterToolbox

interface PlaceMainViperContract {

    interface MainView : ViperView<MainPresenter> {

        fun onFinishInflate(toolbox: RouterToolbox)
    }

    interface MainPresenter : ViperPresenter {

        var view: MainView

        fun onViewCreated(view: MainView)
        fun onFinishInflate(toolbox: RouterToolbox)
    }

    interface MainRouter : ViperRouter {

        fun addPlacesListingFragment()
    }
}

interface PlacesListingViperContract {

    interface PlacesListingView : ViperView<PlacesListingPresenter> {

        fun onStart(toolbox: RouterToolbox)
    }

    interface PlacesListingPresenter : ViperPresenter {

        var view: PlacesListingView

        fun onViewCreated(view: PlacesListingView)
        fun onStart(toolbox: RouterToolbox)
    }

    interface PlacesListingRouter : ViperRouter {

    }
}
package ru.cyber_eagle_owl.saddayappkt.clean.presentation.features.place.viper

import io.reactivex.Single
import ru.cyber_eagle_owl.saddayappkt.clean.data.entities.presentation.PlaceItem
import ru.cyber_eagle_owl.saddayappkt.clean.vipercore.ViperPresenter
import ru.cyber_eagle_owl.saddayappkt.clean.vipercore.ViperRouter
import ru.cyber_eagle_owl.saddayappkt.clean.vipercore.ViperView
import ru.cyber_eagle_owl.saddayappkt.utils.wrappers.RouterToolbox

interface PlaceMainViperContract {

    interface MainView : ViperView<MainPresenter> {

        fun onFinishInflate(toolbox: RouterToolbox, isOrientationChanged: Boolean)
    }

    interface MainPresenter : ViperPresenter {

        var view: MainView

        fun onViewCreated(view: MainView)
        fun onFinishInflate(toolbox: RouterToolbox, isOrientationChanged: Boolean)
    }

    interface MainRouter : ViperRouter {

        fun addPlacesListingFragment()
    }
}

interface PlacesListingViperContract {

    interface PlacesListingView : ViperView<PlacesListingPresenter> {

        fun onStart(toolbox: RouterToolbox)
        fun onStop()
    }

    interface PlacesListingPresenter : ViperPresenter {

        var view: PlacesListingView

        fun onViewCreated(view: PlacesListingView)
        fun onStart(toolbox: RouterToolbox)
        fun onRefreshing(): Single<ArrayList<PlaceItem>>
    }

    interface PlacesListingRouter : ViperRouter {

    }
}
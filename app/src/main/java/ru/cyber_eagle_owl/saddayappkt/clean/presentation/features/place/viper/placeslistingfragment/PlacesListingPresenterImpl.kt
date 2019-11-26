package ru.cyber_eagle_owl.saddayappkt.clean.presentation.features.place.viper.placeslistingfragment

import io.reactivex.Single
import ru.cyber_eagle_owl.saddayappkt.clean.data.entities.presentation.PlaceItem
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

    override fun onRefreshing(): Single<ArrayList<PlaceItem>> {
        val tmpListOfPlaces = arrayListOf(
            PlaceItem(
                "SADDAY TEST 1",
                "All your base are belong to us",
                "Улица Пушкина, дом Колотушкина"
            ),
            PlaceItem(
                "SADDAY TEST 2",
                "All your base are belong to us",
                "Улица Пушкина, дом Колотушкина"
            ),
            PlaceItem(
                "SADDAY TEST 3",
                "All your base are belong to us",
                "Улица Пушкина, дом Колотушкина"
            )
        )
        return Single.create { observer ->
            observer.onSuccess(tmpListOfPlaces)
        }
    }
}
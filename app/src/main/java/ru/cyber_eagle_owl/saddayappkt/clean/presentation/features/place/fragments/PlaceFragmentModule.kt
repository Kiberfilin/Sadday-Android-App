package ru.cyber_eagle_owl.saddayappkt.clean.presentation.features.place.fragments

import dagger.Binds
import dagger.Module
import ru.cyber_eagle_owl.saddayappkt.clean.presentation.features.place.viper.PlacesListingViperContract
import ru.cyber_eagle_owl.saddayappkt.clean.presentation.features.place.viper.placeslistingfragment.PlacesListingPresenterImpl
import ru.cyber_eagle_owl.saddayappkt.clean.presentation.features.place.viper.placeslistingfragment.PlacesListingRouterImpl
import ru.cyber_eagle_owl.saddayappkt.clean.presentation.features.place.viper.placeslistingfragment.PlacesListingViewImpl
import ru.cyber_eagle_owl.saddayappkt.di.scopes.FragmentScope

@Module
abstract class PlaceFragmentModule {

    @Binds
    @FragmentScope
    abstract fun placesListingView(placesListingView: PlacesListingViewImpl): PlacesListingViperContract.PlacesListingView

    @Binds
    @FragmentScope
    abstract fun placesListingPresenter(placesListingPresenter: PlacesListingPresenterImpl): PlacesListingViperContract.PlacesListingPresenter

    @Binds
    @FragmentScope
    abstract fun placesListingRouter(placesListingRouter: PlacesListingRouterImpl): PlacesListingViperContract.PlacesListingRouter
}
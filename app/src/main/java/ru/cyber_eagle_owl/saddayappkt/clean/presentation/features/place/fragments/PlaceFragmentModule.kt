package ru.cyber_eagle_owl.saddayappkt.clean.presentation.features.place.fragments

import dagger.Binds
import dagger.Module
import ru.cyber_eagle_owl.saddayappkt.clean.data.repositories.PlacesRepository
import ru.cyber_eagle_owl.saddayappkt.clean.domain.boundaries.presenter.inputports.GetPlacesInputPort
import ru.cyber_eagle_owl.saddayappkt.clean.domain.boundaries.repository.inputports.PlacesRepositoryInputPort
import ru.cyber_eagle_owl.saddayappkt.clean.domain.interactors.GetPlacesInteractor
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

    @Binds
    @FragmentScope
    abstract fun getPlacesInteractor(getPlacesInteractor: GetPlacesInteractor): GetPlacesInputPort

    @Binds
    @FragmentScope
    abstract fun placesRepository(placesRepository: PlacesRepository): PlacesRepositoryInputPort
}
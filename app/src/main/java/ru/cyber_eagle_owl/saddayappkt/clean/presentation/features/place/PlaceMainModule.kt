package ru.cyber_eagle_owl.saddayappkt.clean.presentation.features.place

import dagger.Binds
import dagger.Module
import ru.cyber_eagle_owl.saddayappkt.clean.presentation.features.place.viper.PlaceMainViperContract
import ru.cyber_eagle_owl.saddayappkt.clean.presentation.features.place.viper.main.PlaceActivityPresenter
import ru.cyber_eagle_owl.saddayappkt.clean.presentation.features.place.viper.main.PlaceActivityView
import ru.cyber_eagle_owl.saddayappkt.clean.presentation.features.place.viper.main.PlaceRouter
import ru.cyber_eagle_owl.saddayappkt.di.scopes.ActivityScope

@Module
abstract class PlaceMainModule {

    @Binds
    @ActivityScope
    abstract fun placeActivityView(placeActivityView: PlaceActivityView): PlaceMainViperContract.MainView

    @Binds
    @ActivityScope
    abstract fun placeActivityPresenter(placeActivityPresenter: PlaceActivityPresenter): PlaceMainViperContract.MainPresenter

    @Binds
    @ActivityScope
    abstract fun placeActivityRouter(placeActivityRouter: PlaceRouter): PlaceMainViperContract.MainRouter
}
package ru.cyber_eagle_owl.saddayappkt.clean.presentation.features.place.viper.placeslistingfragment

import ru.cyber_eagle_owl.saddayappkt.clean.presentation.features.place.viper.PlacesListingViperContract
import ru.cyber_eagle_owl.saddayappkt.clean.presentation.vipercore.BaseView
import ru.cyber_eagle_owl.saddayappkt.utils.wrappers.RouterToolbox
import timber.log.Timber
import javax.inject.Inject

class PlacesListingViewImpl @Inject constructor() : BaseView<PlacesListingViperContract.PlacesListingPresenter>(),
    PlacesListingViperContract.PlacesListingView {

    override fun onStart(toolbox: RouterToolbox) {
        Timber.d("onResume()")
        initViews()
        presenter.apply {
            onStart(toolbox)
            onViewCreated(this@PlacesListingViewImpl)
        }
    }

    private fun initViews() {
        Timber.d("initViews()")
        //todo
    }
}
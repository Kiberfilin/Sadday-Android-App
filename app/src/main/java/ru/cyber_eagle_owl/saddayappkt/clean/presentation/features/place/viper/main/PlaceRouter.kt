package ru.cyber_eagle_owl.saddayappkt.clean.presentation.features.place.viper.main

import ru.cyber_eagle_owl.saddayappkt.R
import ru.cyber_eagle_owl.saddayappkt.clean.presentation.features.place.fragments.PlacesListingFragment
import ru.cyber_eagle_owl.saddayappkt.clean.presentation.features.place.viper.PlaceMainViperContract
import ru.cyber_eagle_owl.saddayappkt.clean.presentation.vipercore.BaseRouter
import timber.log.Timber
import javax.inject.Inject

class PlaceRouter @Inject constructor(): BaseRouter(), PlaceMainViperContract.MainRouter {

    override fun addPlacesListingFragment() {
        Timber.d("addPlacesListingFragment()")
        toolbox.fragmentManager().beginTransaction().add(
            R.id.placeFragmentContainer,
            PlacesListingFragment.newInstance(),
            "PlacesListingFragment"
        ).commit()
    }
}
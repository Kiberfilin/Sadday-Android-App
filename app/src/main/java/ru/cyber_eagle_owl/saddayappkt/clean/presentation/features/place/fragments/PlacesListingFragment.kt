package ru.cyber_eagle_owl.saddayappkt.clean.presentation.features.place.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.cyber_eagle_owl.saddayappkt.R
import ru.cyber_eagle_owl.saddayappkt.base.BaseActivity
import ru.cyber_eagle_owl.saddayappkt.base.BaseFragment
import ru.cyber_eagle_owl.saddayappkt.clean.presentation.features.place.viper.PlacesListingViperContract
import timber.log.Timber
import javax.inject.Inject

class PlacesListingFragment : BaseFragment() {

    @Inject
    lateinit var view: PlacesListingViperContract.PlacesListingView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Timber.d("onCreateView")

        val fragmentView = inflater.inflate(R.layout.fragment_places_listing,
            container, false)

        view.setRootView(fragmentView)

        return fragmentView
    }

    override fun onStart() {
        super.onStart()

        view.onStart((activity as BaseActivity).getRouterToolbox())
    }

    companion object {
        //@JvmStatic
        fun newInstance() =
            PlacesListingFragment()
    }
}
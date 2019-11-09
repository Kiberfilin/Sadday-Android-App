package ru.cyber_eagle_owl.saddayappkt.clean.presentation.features.place.viper.placeslistingfragment

import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.RecyclerView
import ru.cyber_eagle_owl.saddayappkt.R
import ru.cyber_eagle_owl.saddayappkt.clean.presentation.features.place.fragments.PlacesListingRecyclerViewAdapter
import ru.cyber_eagle_owl.saddayappkt.clean.presentation.features.place.viper.PlacesListingViperContract
import ru.cyber_eagle_owl.saddayappkt.clean.presentation.vipercore.BaseView
import ru.cyber_eagle_owl.saddayappkt.utils.wrappers.RouterToolbox
import timber.log.Timber
import javax.inject.Inject

class PlacesListingViewImpl @Inject constructor() : BaseView<PlacesListingViperContract.PlacesListingPresenter>(),
    PlacesListingViperContract.PlacesListingView {

    private lateinit var placesListingSwipeRefresh: SwipeRefreshLayout
    private lateinit var placesListingRecyclerView: RecyclerView

    private lateinit var placesListingAdapter: PlacesListingRecyclerViewAdapter

    private lateinit var onRefreshListener: SwipeRefreshLayout.OnRefreshListener

    override fun onStart(toolbox: RouterToolbox) {
        Timber.d("onResume()")
        initViews()

        val dens: Float = viperRootView.context.resources.displayMetrics.density
        prepareRecyclerView(viperRootView.context.resources.configuration.orientation, dens)

        presenter.apply {
            onStart(toolbox)
            onViewCreated(this@PlacesListingViewImpl)
        }
    }

    private fun prepareRecyclerView(orientation: Int, dens: Float) {
        Timber.d("prepareRecyclerView()")
        placesListingAdapter = PlacesListingRecyclerViewAdapter()

        }

    private fun initViews() {
        Timber.d("initViews()")
        placesListingSwipeRefresh = viperRootView.findViewById(R.id.placesListingSwipeRefresh)
        placesListingRecyclerView = viperRootView.findViewById(R.id.placesListingRecyclerView)
    }
}
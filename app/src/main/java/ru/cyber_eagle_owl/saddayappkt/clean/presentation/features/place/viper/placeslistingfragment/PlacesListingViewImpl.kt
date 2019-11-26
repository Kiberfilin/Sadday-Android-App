package ru.cyber_eagle_owl.saddayappkt.clean.presentation.features.place.viper.placeslistingfragment

import android.content.res.Configuration
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers
import ru.cyber_eagle_owl.saddayappkt.R
import ru.cyber_eagle_owl.saddayappkt.clean.data.entities.presentation.PlaceItem
import ru.cyber_eagle_owl.saddayappkt.clean.presentation.features.place.fragments.PlacesListingRecyclerViewAdapter
import ru.cyber_eagle_owl.saddayappkt.clean.presentation.features.place.viper.PlacesListingViperContract
import ru.cyber_eagle_owl.saddayappkt.clean.presentation.vipercore.BaseView
import ru.cyber_eagle_owl.saddayappkt.utils.wrappers.RouterToolbox
import timber.log.Timber
import javax.inject.Inject

class PlacesListingViewImpl @Inject constructor() :
    BaseView<PlacesListingViperContract.PlacesListingPresenter>(),
    PlacesListingViperContract.PlacesListingView,
    PlacesListingRecyclerViewAdapter.OnItemClickListener {

    private lateinit var placesListingSwipeRefresh: SwipeRefreshLayout
    private lateinit var placesListingRecyclerView: RecyclerView
    private lateinit var placesListingAdapter: PlacesListingRecyclerViewAdapter
    private lateinit var onRefreshListener: SwipeRefreshLayout.OnRefreshListener

    private val bag = CompositeDisposable()

    override fun onStart(toolbox: RouterToolbox) {
        Timber.d("onResume()")
        initViews()

        val dens: Float = viperRootView.context.resources.displayMetrics.density
        prepareRecyclerView(viperRootView.context.resources.configuration.orientation, dens)
        prepareSwipeRefreshLayout()

        presenter.apply {
            onStart(toolbox)
            onViewCreated(this@PlacesListingViewImpl)
            onRefreshing().subscribeOnPlaces()
        }
        placesListingSwipeRefresh.isRefreshing = true
    }

    private fun prepareSwipeRefreshLayout() {
        Timber.d("prepareSwipeRefreshLayout()")

        onRefreshListener = SwipeRefreshLayout.OnRefreshListener {
            presenter.onRefreshing().subscribeOnPlaces()
        }

        placesListingSwipeRefresh.setOnRefreshListener(onRefreshListener)
    }

    private fun Single<ArrayList<PlaceItem>>.subscribeOnPlaces() = this.observeOn(AndroidSchedulers.mainThread())
        .subscribeOn(Schedulers.io())
        .subscribe({ places ->
            placesListingAdapter.places.accept(places)
            placesListingSwipeRefresh.isRefreshing = false
        }, { error ->
            Timber.d(error)
            placesListingSwipeRefresh.isRefreshing = false
        }).addTo(bag)

    private fun prepareRecyclerView(orientation: Int, dens: Float) {
        Timber.d("prepareRecyclerView()")
        placesListingAdapter = PlacesListingRecyclerViewAdapter(this)

        placesListingSwipeRefresh.apply {
            if (orientation == Configuration.ORIENTATION_PORTRAIT) {
                (layoutParams as ViewGroup.MarginLayoutParams).bottomMargin = (48 * dens).toInt()
                (layoutParams as ViewGroup.MarginLayoutParams).marginStart = (8 * dens).toInt()
                (layoutParams as ViewGroup.MarginLayoutParams).marginEnd = (8 * dens).toInt()
            } else {
                (layoutParams as ViewGroup.MarginLayoutParams).marginStart = (48 * dens).toInt()
                (layoutParams as ViewGroup.MarginLayoutParams).marginEnd = (48 * dens).toInt()
            }

            placesListingRecyclerView.layoutManager = LinearLayoutManager(viperRootView.context)
            placesListingRecyclerView.adapter = placesListingAdapter
        }
    }

    override fun onStop() {
        Timber.d("onStop()")
        placesListingSwipeRefresh.isRefreshing = false
        placesListingAdapter.bag.clear()
        bag.clear()
    }

    private fun initViews() {
        Timber.d("initViews()")
        placesListingSwipeRefresh = viperRootView.findViewById(R.id.placesListingSwipeRefresh)
        placesListingRecyclerView = viperRootView.findViewById(R.id.placesListingRecyclerView)
    }
}
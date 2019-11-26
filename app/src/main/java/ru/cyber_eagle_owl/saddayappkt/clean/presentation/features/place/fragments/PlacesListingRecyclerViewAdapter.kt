package ru.cyber_eagle_owl.saddayappkt.clean.presentation.features.place.fragments

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jakewharton.rxrelay2.BehaviorRelay
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import kotlinx.android.synthetic.main.places_listing_item.view.*
import ru.cyber_eagle_owl.saddayappkt.R
import ru.cyber_eagle_owl.saddayappkt.clean.data.entities.presentation.PlaceItem
import timber.log.Timber

class PlacesListingRecyclerViewAdapter(private val onItemClickListener: OnItemClickListener) :
    RecyclerView.Adapter<PlacesListingRecyclerViewAdapter.PlscesListingViewHolder>() {

    internal val bag = CompositeDisposable()

    internal var places = BehaviorRelay.createDefault(ArrayList<PlaceItem>())

    init {
        places.observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                notifyDataSetChanged()
            }.addTo(bag)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlscesListingViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.places_listing_item, parent, false)
        return PlscesListingViewHolder(view, onItemClickListener)}

    override fun getItemCount(): Int {
        return places.value.count()
    }

    override fun onBindViewHolder(holder: PlscesListingViewHolder, position: Int) {
        Timber.d("onBindViewHolder")

        places.value[position].also {
            //holder.view.setTag(R.string.photo_item_tag, it.id)
            holder.bind(it)
        }
    }


    class PlscesListingViewHolder(var view: View, private val onItemClickListener: OnItemClickListener):
        RecyclerView.ViewHolder(view) {

        init {
            view.setOnClickListener {
                //val tmpPhotoId = it.getTag(R.string.photo_item_tag) as Int
                //onItemClickListener.onItemClick(tmpPhotoId)
            }
        }

        fun bind(item: PlaceItem) {
            view.apply {
                festTitle.text = item.title
                festInfo.text = item.information
                festLocation.text = item.address
            }
        }
    }

    interface OnItemClickListener {

        //fun onItemClick(photoId: Int)
    }
}
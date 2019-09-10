package ru.cyber_eagle_owl.saddayappkt.clean.presentation.features.game.fragments

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.cards_description_listing_item.view.*
import ru.cyber_eagle_owl.saddayappkt.R
import ru.cyber_eagle_owl.saddayappkt.clean.data.entities.presentation.CardItem
import timber.log.Timber

class CardsInformationAdapter :
    RecyclerView.Adapter<CardsInformationAdapter.CardsListingViewHolder>() {

    var cardsItems: List<CardItem> = ArrayList()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CardsListingViewHolder {
        Timber.d("onCreateViewHolder()")

        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.cards_description_listing_item, parent, false)

        return CardsListingViewHolder(
            view
        )
    }

    override fun getItemCount(): Int {
        Timber.d("getItemCount() ${cardsItems.size}")

        return cardsItems.size
    }

    override fun onBindViewHolder(holder: CardsListingViewHolder, position: Int) {
        Timber.d("onBindViewHolder()")

        holder.bind(cardsItems[position])
    }

    class CardsListingViewHolder(var view: View) : RecyclerView.ViewHolder(view) {
        private val cardExampleAdapter = CardsExamplesListingAdapter()

        fun bind(item: CardItem) {
            Timber.d("bind(item: NewsItem)")

            view.apply {
                cardNameTV.text = item.cardStrings[0]
                cardStatsRPTV.text = resources.getString(
                    R.string.rockPowerText,
                    if (item.rockPowerValue == -1) "immune" else item.rockPowerValue
                )
                cardStatsMADTV.text =
                    resources.getString(
                        R.string.maxAlcoholDigestibilityText,
                        if (item.maxAlcoholDigestibilityValue == -1) "immune" else item.maxAlcoholDigestibilityValue
                    )
                cardStatsABPTV.text =
                    resources.getString(
                        R.string.acousticBrainProtectionText,
                        if (item.acousticBrainProtectionValue == -1) "immune" else item.acousticBrainProtectionValue
                    )
                totalCardsTV.text = resources.getString(R.string.totalCardsInDeck, item.cardImages.size)

                cardExampleAdapter.card = item
                cardsExamplesListingRV.layoutManager =
                    LinearLayoutManager(view.context, LinearLayoutManager.HORIZONTAL, false)
                cardsExamplesListingRV.adapter = cardExampleAdapter
                cardExampleAdapter.notifyDataSetChanged()
            }
        }
    }
}
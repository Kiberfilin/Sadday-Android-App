package ru.cyber_eagle_owl.saddayappkt.clean.presentation.features.game.fragments

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.cards_example_listing_item.view.*
import ru.cyber_eagle_owl.saddayappkt.R
import ru.cyber_eagle_owl.saddayappkt.clean.data.entities.presentation.CardItem
import timber.log.Timber

class CardsExamplesListingAdapter : RecyclerView.Adapter<CardsExamplesListingAdapter.CardExampleViewHolder>() {

    lateinit var card: CardItem

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardExampleViewHolder {
        Timber.d("onCreateViewHolder()")

        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.cards_example_listing_item, parent, false)

        return CardExampleViewHolder(view)
    }

    override fun getItemCount(): Int {
        Timber.d("getItemCount() ${card.cardImages.size}")
        return card.cardImages.size
    }

    override fun onBindViewHolder(holder: CardExampleViewHolder, position: Int) {
        Timber.d("onBindViewHolder()")

        holder.bind(card, position)
    }

    class CardExampleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(item: CardItem, position: Int) {
            Timber.d("bind(item: CardItem)")

            itemView.cardExample.apply {
                cardImage = item.cardImages[position]
                cardName = item.cardStrings[0]
                shortDescriptionText = item.cardStrings[1]
                specAbilityDescriptionText = item.cardStrings[2]
                rockPowerValue = item.rockPowerValue
                maxAlcoholDigestibilityValue = item.maxAlcoholDigestibilityValue
                acousticBrainProtectionValue = item.acousticBrainProtectionValue
            }
        }
    }
}
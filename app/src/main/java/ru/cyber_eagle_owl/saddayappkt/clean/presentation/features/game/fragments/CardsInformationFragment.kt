package ru.cyber_eagle_owl.saddayappkt.clean.presentation.features.game.fragments

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_cards_information.*
import ru.cyber_eagle_owl.saddayappkt.R
import ru.cyber_eagle_owl.saddayappkt.base.BaseFragment
import ru.cyber_eagle_owl.saddayappkt.clean.data.entities.presentation.CardItem
import ru.cyber_eagle_owl.saddayappkt.clean.presentation.features.game.GameMvp
import timber.log.Timber
import javax.inject.Inject

class CardsInformationFragment : BaseFragment(), GameMvp.View {

    private var currentToast: Toast? = null
    private lateinit var cardsInformationAdapter: CardsInformationAdapter

    @Inject
    lateinit var presenter: GameMvp.Presenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_cards_information, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        prepareRecyclerView()
        presenter.onViewCreated()
    }

    private fun prepareRecyclerView() {
        Timber.d("prepareRecyclerView()")

        cardsInformationAdapter =
            CardsInformationAdapter()
        cardsListingRV.layoutManager = LinearLayoutManager(this.context)
        cardsListingRV.adapter = cardsInformationAdapter
        cardsListingRV.adapter.notifyDataSetChanged()
    }

    override fun showCardsInfo(cards: List<CardItem>) {
        cardsInformationAdapter.cardsItems = cards
        cardsInformationAdapter.notifyDataSetChanged()
    }

    override fun showToast(toastText: String) {
        Timber.d("showToast")

        currentToast?.let {
            currentToast!!.cancel()
        }

        currentToast = Toast.makeText(activity, toastText, Toast.LENGTH_LONG)
        currentToast!!.show()
    }

    companion object {
        fun newInstance() = CardsInformationFragment()
    }
}

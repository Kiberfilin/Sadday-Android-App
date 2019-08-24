package ru.cyber_eagle_owl.saddayappkt.clean.presentation.features.game

import ru.cyber_eagle_owl.saddayappkt.clean.data.entities.presentation.CardItem
import ru.cyber_eagle_owl.saddayappkt.clean.data.repositories.CardsRepository
import ru.cyber_eagle_owl.saddayappkt.clean.domain.boundaries.presenter.inputports.GetCardsInputPort
import ru.cyber_eagle_owl.saddayappkt.clean.domain.boundaries.presenter.outputports.GetCardsOutputPort
import ru.cyber_eagle_owl.saddayappkt.clean.domain.interactors.GetCardsInteractor
import ru.cyber_eagle_owl.saddayappkt.clean.presentation.mvpcore.BasePresenter
import ru.cyber_eagle_owl.saddayappkt.utils.ResourcesHelper
import timber.log.Timber
import javax.inject.Inject

class GamePresenter @Inject constructor() : BasePresenter<GameMvp.View>(), GameMvp.Presenter, GetCardsOutputPort {

    @Inject
    lateinit var resources: ResourcesHelper

    private lateinit var getCards: GetCardsInputPort

    override fun onViewCreated() {
        Timber.d("onViewCreated()")
        //for (a: String in resources.getStringArray(R.array.fans)) Timber.d("***a*** $a")
        val cardsRepo = CardsRepository(resources)
        getCards = GetCardsInteractor(this, cardsRepo)
        getCards.execute()
    }

    override fun onCardsHasGotten(cardsToShow: List<CardItem>) {
        Timber.d("onCardsHasGotten(cardsToShow: List<CardItem>)")

        view.showCardsInfo(cardsToShow)
    }
}
package ru.cyber_eagle_owl.saddayappkt.clean.domain.interactors

import ru.cyber_eagle_owl.saddayappkt.clean.data.entities.presentation.CardItem
import ru.cyber_eagle_owl.saddayappkt.clean.domain.boundaries.presenter.inputports.GetCardsInputPort
import ru.cyber_eagle_owl.saddayappkt.clean.domain.boundaries.presenter.outputports.GetCardsOutputPort
import ru.cyber_eagle_owl.saddayappkt.clean.domain.boundaries.repository.inputports.CardsRepositoryInputPort
import ru.cyber_eagle_owl.saddayappkt.clean.domain.boundaries.repository.outputports.CardsRepositoryOutputPort
import timber.log.Timber

class GetCardsInteractor(
    private val presentationOutputPort: GetCardsOutputPort,
    private val dataInputPort: CardsRepositoryInputPort
) : GetCardsInputPort, CardsRepositoryOutputPort {

    init {
        dataInputPort.setOutputPort(this)
    }

    override fun execute() {
        Timber.d("execute()")

        dataInputPort.getCards()
    }

    override fun onCardsHasGotten(cards: List<CardItem>) {
        Timber.d("onCardsHasGotten(cards: List<CardItem>)")

        presentationOutputPort.onCardsHasGotten(cards)
    }
}
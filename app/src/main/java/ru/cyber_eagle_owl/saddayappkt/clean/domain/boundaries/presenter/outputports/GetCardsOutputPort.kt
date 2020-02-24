package ru.cyber_eagle_owl.saddayappkt.clean.domain.boundaries.presenter.outputports

import ru.cyber_eagle_owl.saddayappkt.clean.data.entities.presentation.CardItem
@Deprecated("внедрить RxKotlin")
interface GetCardsOutputPort {

    fun onCardsHasGotten(cardsToShow: List<CardItem>)
}
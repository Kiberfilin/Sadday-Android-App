package ru.cyber_eagle_owl.saddayappkt.clean.domain.boundaries.repository.outputports

import ru.cyber_eagle_owl.saddayappkt.clean.data.entities.presentation.CardItem
@Deprecated("Заменить на RxKotlin")
interface CardsRepositoryOutputPort {

    fun onCardsHasGotten(cards: List<CardItem>)
}
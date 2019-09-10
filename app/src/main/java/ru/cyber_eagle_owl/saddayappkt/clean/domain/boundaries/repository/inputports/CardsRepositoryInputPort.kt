package ru.cyber_eagle_owl.saddayappkt.clean.domain.boundaries.repository.inputports

import ru.cyber_eagle_owl.saddayappkt.clean.domain.boundaries.repository.outputports.CardsRepositoryOutputPort

interface CardsRepositoryInputPort {

    fun setOutputPort(outputPort: CardsRepositoryOutputPort)

    fun getCards()
}
package ru.cyber_eagle_owl.saddayappkt.clean.domain.boundaries.presenter.inputports

import io.reactivex.Single
import ru.cyber_eagle_owl.saddayappkt.clean.data.entities.presentation.PlaceItem

interface GetPlacesInputPort {

    fun execute(): Single<ArrayList<PlaceItem>>
}
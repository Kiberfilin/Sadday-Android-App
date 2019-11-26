package ru.cyber_eagle_owl.saddayappkt.clean.domain.boundaries.repository.inputports

import io.reactivex.Single
import ru.cyber_eagle_owl.saddayappkt.clean.data.entities.presentation.PlaceItem

interface PlacesRepositoryInputPort {

    fun getPlaces(): Single<ArrayList<PlaceItem>>
}
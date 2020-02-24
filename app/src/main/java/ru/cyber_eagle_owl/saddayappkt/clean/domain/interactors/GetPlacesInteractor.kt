package ru.cyber_eagle_owl.saddayappkt.clean.domain.interactors

import io.reactivex.Single
import ru.cyber_eagle_owl.saddayappkt.clean.data.entities.presentation.PlaceItem
import ru.cyber_eagle_owl.saddayappkt.clean.domain.boundaries.presenter.inputports.GetPlacesInputPort
import ru.cyber_eagle_owl.saddayappkt.clean.domain.boundaries.repository.inputports.PlacesRepositoryInputPort
import javax.inject.Inject

class GetPlacesInteractor @Inject constructor() : GetPlacesInputPort {

    @Inject
    lateinit var dataInputPort: PlacesRepositoryInputPort

    override fun execute(): Single<ArrayList<PlaceItem>> {
        return dataInputPort.getPlaces()
    }
}
package ru.cyber_eagle_owl.saddayappkt.clean.data.repositories

import io.reactivex.Single
import ru.cyber_eagle_owl.saddayappkt.clean.data.entities.presentation.PlaceItem
import ru.cyber_eagle_owl.saddayappkt.clean.domain.boundaries.repository.inputports.PlacesRepositoryInputPort
import javax.inject.Inject

class PlacesRepository @Inject constructor() : PlacesRepositoryInputPort {

    override fun getPlaces(): Single<ArrayList<PlaceItem>> {
        val tmpListOfPlaces = arrayListOf(
            PlaceItem(
                "SADDAY TEST 1",
                "All your base are belong to us",
                "Улица Пушкина, дом Колотушкина"
            ),
            PlaceItem(
                "SADDAY TEST 2",
                "All your base are belong to us",
                "Улица Пушкина, дом Колотушкина"
            ),
            PlaceItem(
                "SADDAY TEST 3",
                "All your base are belong to us",
                "Улица Пушкина, дом Колотушкина"
            )
        )
        return Single.create { observer ->
            observer.onSuccess(tmpListOfPlaces)
        }
    }
}
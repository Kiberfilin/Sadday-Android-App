package ru.cyber_eagle_owl.saddayappkt.clean.data.repositories

import com.vk.api.sdk.VK
import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.Single
import io.reactivex.functions.BiFunction
import ru.cyber_eagle_owl.saddayappkt.clean.data.entities.data.Address
import ru.cyber_eagle_owl.saddayappkt.clean.data.entities.data.database.City
import ru.cyber_eagle_owl.saddayappkt.clean.data.entities.data.database.MetroStation
import ru.cyber_eagle_owl.saddayappkt.clean.data.entities.presentation.PlaceItem
import ru.cyber_eagle_owl.saddayappkt.clean.data.web.CityRequest
import ru.cyber_eagle_owl.saddayappkt.clean.data.web.MetroStationRequest
import ru.cyber_eagle_owl.saddayappkt.clean.data.web.PlacesRequest
import ru.cyber_eagle_owl.saddayappkt.clean.domain.boundaries.repository.inputports.PlacesRepositoryInputPort
import ru.cyber_eagle_owl.saddayappkt.utils.mappers.EntityMapper
import timber.log.Timber
import javax.inject.Inject

class PlacesRepository @Inject constructor() : PlacesRepositoryInputPort {

    override fun getPlaces(): Single<ArrayList<PlaceItem>> {
        Timber.d("getPlaces(): Single<ArrayList<PlaceItem>>")

        return Observable.fromCallable {
            VK.executeSync(PlacesRequest())
        }.flatMap {
            Observable.fromIterable(it)
        }.flatMap {
            makingAdditionalRxApiCalls(it)
        }.toList().map {
            val tmpArrayList = ArrayList<PlaceItem>()
            tmpArrayList.addAll(it)
            tmpArrayList
        }
    }

    private fun makingAdditionalRxApiCalls(address: Address): ObservableSource<PlaceItem> {

        address.metro_station_id.also { metroStationId ->
            return if (metroStationId == null || metroStationId == 0L) {
                getCityById(address.city_id!!).map {city ->
                    EntityMapper.mapToPlaceItem(address, city = city)
                }
            } else Observable.zip(
                getMetroStationById(metroStationId),
                getCityById(address.city_id!!),
                BiFunction<MetroStation, City, PlaceItem> { metro, city ->
                    EntityMapper.mapToPlaceItem(address, metro, city)
                }
            )
        }

    }

    private fun getCityById(cityId: Long): Observable<City> {
        return Observable.fromCallable {
            VK.executeSync(CityRequest(cityId))
        }
    }

    private fun getMetroStationById(stationId: Long): Observable<MetroStation> {
        return Observable.fromCallable {
            VK.executeSync(MetroStationRequest(stationId))
        }
    }
}
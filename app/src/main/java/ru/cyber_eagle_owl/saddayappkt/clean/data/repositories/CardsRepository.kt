package ru.cyber_eagle_owl.saddayappkt.clean.data.repositories

import ru.cyber_eagle_owl.saddayappkt.R
import ru.cyber_eagle_owl.saddayappkt.clean.data.entities.presentation.CardItem
import ru.cyber_eagle_owl.saddayappkt.clean.domain.boundaries.repository.inputports.CardsRepositoryInputPort
import ru.cyber_eagle_owl.saddayappkt.clean.domain.boundaries.repository.outputports.CardsRepositoryOutputPort
import ru.cyber_eagle_owl.saddayappkt.utils.helpers.ResourcesHelper
import timber.log.Timber

class CardsRepository (val resources: ResourcesHelper): CardsRepositoryInputPort {

    private lateinit var interactor: CardsRepositoryOutputPort

    override fun setOutputPort(outputPort: CardsRepositoryOutputPort) {
        Timber.d("setOutputPort(outputPort: CardsRepositoryOutputPort)")

        interactor = outputPort

    }

    override fun getCards() {
        //for (a: String in resources.getStringArray(R.array.fans)) Timber.d("***a*** $a")
        val cards = listOf(

            CardItem(
                listOf(
                    R.drawable.fans1,
                    R.drawable.fans2,
                    R.drawable.fans3,
                    R.drawable.fans1,
                    R.drawable.fans2,
                    R.drawable.fans3
                ),
                resources.getStringArray(R.array.fans),
                2,
                2,
                4
            ),

            CardItem(
                listOf(
                    R.drawable.slemeri1,
                    R.drawable.slemeri2,
                    R.drawable.slemeri3,
                    R.drawable.slemeri1,
                    R.drawable.slemeri3
                ),
                resources.getStringArray(R.array.slemeri),
                3,
                2,
                5
            ),

            CardItem(
                listOf(
                    R.drawable.tancori1,
                    R.drawable.tancori2,
                    R.drawable.tancori3
                ),
                resources.getStringArray(R.array.tancori),
                4,
                2,
                4
            ),

            CardItem(
                listOf(
                    R.drawable.stagediver,
                    R.drawable.stagediver
                ),
                resources.getStringArray(R.array.stagedivers),
                5,
                2,
                2
            ),

            CardItem(
                listOf(
                    R.drawable.blogger1,
                    R.drawable.blogger2
                ),
                resources.getStringArray(R.array.blogger),
                2,
                3,
                4
            ),

            CardItem(
                listOf(
                    R.drawable.friends1,
                    R.drawable.friends2
                ),
                resources.getStringArray(R.array.friends),
                2,
                2,
                4
            ),

            CardItem(
                listOf(
                    R.drawable.kamikazi1,
                    R.drawable.kamikazi2
                ),
                resources.getStringArray(R.array.kamikazi),
                1,
                2,
                4
            ),

            CardItem(
                listOf(
                    R.drawable.programmer
                ),
                resources.getStringArray(R.array.programmer),
                2,
                -1,
                3
            ),

            CardItem(
                listOf(
                    R.drawable.konkurenti
                ),
                resources.getStringArray(R.array.konkurenti),
                2,
                2,
                5
            ),

            CardItem(
                listOf(
                    R.drawable.organizator
                ),
                resources.getStringArray(R.array.organizator),
                3,
                2,
                -1
            ),

            CardItem(
                listOf(
                    R.drawable.telochki
                ),
                resources.getStringArray(R.array.telochki),
                2,
                2,
                4
            ),

            CardItem(
                listOf(
                    R.drawable.maski
                ),
                resources.getStringArray(R.array.maskishow),
                0,
                -1,
                1
            )
        )
        interactor.onCardsHasGotten(cards)
    }

}
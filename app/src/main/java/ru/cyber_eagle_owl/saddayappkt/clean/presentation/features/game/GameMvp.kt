package ru.cyber_eagle_owl.saddayappkt.clean.presentation.features.game

import ru.cyber_eagle_owl.saddayappkt.clean.data.entities.presentation.CardItem
import ru.cyber_eagle_owl.saddayappkt.clean.presentation.mvpcore.MvpPresenter
import ru.cyber_eagle_owl.saddayappkt.clean.presentation.mvpcore.MvpView

interface GameMvp {

    interface View: MvpView {
        fun showCardsInfo(cards: List<CardItem>)
    }

    interface Presenter : MvpPresenter<View> {

        fun onViewCreated()
    }

    interface Model {

    }
}

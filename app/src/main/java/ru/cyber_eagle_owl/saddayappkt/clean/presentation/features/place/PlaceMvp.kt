package ru.cyber_eagle_owl.saddayappkt.clean.presentation.features.place

import ru.cyber_eagle_owl.saddayappkt.clean.presentation.mvpcore.MvpPresenter
import ru.cyber_eagle_owl.saddayappkt.clean.presentation.mvpcore.MvpView

interface PlaceMvp {

    interface View: MvpView {

    }

    interface Presenter : MvpPresenter<View> {

        fun onViewCreated()
    }

    interface Model {

    }
}

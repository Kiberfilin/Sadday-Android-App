package ru.cyber_eagle_owl.saddayappkt.clean.presentation.features.tickets

import ru.cyber_eagle_owl.saddayappkt.clean.mvpcore.MvpPresenter
import ru.cyber_eagle_owl.saddayappkt.clean.mvpcore.MvpView

interface TicketsMvp {

    interface View: MvpView {

    }

    interface Presenter : MvpPresenter<View> {

        fun onViewCreated()
    }

    interface Model {

    }
}

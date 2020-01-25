package ru.cyber_eagle_owl.saddayappkt.clean.presentation.features.menu

import ru.cyber_eagle_owl.saddayappkt.clean.mvpcore.MvpPresenter
import ru.cyber_eagle_owl.saddayappkt.clean.mvpcore.MvpView

interface MainMenuMvp {

    interface View: MvpView {

        fun onMenuItemClickHandled(itemTitle: String)
    }

    interface Presenter : MvpPresenter<View>{

        fun onViewCreated()
        fun onMenuItemClicked(itemTitle: String)
    }

    interface Model {

    }
}
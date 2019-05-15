package ru.cyber_eagle_owl.saddayappkt.features.menu

import ru.cyber_eagle_owl.saddayappkt.mvpcore.MvpPresenter
import ru.cyber_eagle_owl.saddayappkt.mvpcore.MvpView

interface MainMenuMvp {

    interface View: MvpView {

        fun showToast(toastText: String)
    }

    interface Presenter : MvpPresenter<View>{

        fun onViewCreated()
        fun onMenuItemClicked(stringResIdOfItemTitle: Int)

        fun startSync()
    }

    interface Model {

    }
}
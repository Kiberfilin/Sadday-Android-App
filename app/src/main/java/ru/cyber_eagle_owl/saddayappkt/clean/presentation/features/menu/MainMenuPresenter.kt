package ru.cyber_eagle_owl.saddayappkt.clean.presentation.features.menu

import ru.cyber_eagle_owl.saddayappkt.clean.presentation.mvpcore.BasePresenter
import javax.inject.Inject

class MainMenuPresenter @Inject constructor() :
    BasePresenter<MainMenuMvp.View>(),
    MainMenuMvp.Presenter {

    override fun onViewCreated() {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        startSync()
    }

    override fun onMenuItemClicked(itemTitle: String) {
        //view.showToast("кликнули на пункт меню $itemTitle")
        view.onMenuItemClickHandled(itemTitle)
    }

    private fun startSync() {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}
package ru.cyber_eagle_owl.saddayappkt.features.menu

import ru.cyber_eagle_owl.saddayappkt.mvpcore.BasePresenter
import javax.inject.Inject

class MainMenuPresenter @Inject constructor() :
    BasePresenter<MainMenuMvp.View>(),
    MainMenuMvp.Presenter {

    override fun onViewCreated() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onMenuItemClicked(stringResIdOfItemTitle: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun startSync() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}
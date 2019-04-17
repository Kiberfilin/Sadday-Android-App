package ru.cyber_eagle_owl.saddayappkt.mvpcore.activity

import ru.cyber_eagle_owl.saddayappkt.mvpcore.activity.interfaces.MvpActivityPresenter
import ru.cyber_eagle_owl.saddayappkt.mvpcore.activity.interfaces.MvpActivityView

abstract class BaseActivityPresenter<T : MvpActivityView> : MvpActivityPresenter<T> {

    protected var mvpActivityView : T? = null

    override fun onAttach(mvpActivityView: T) {
        this.mvpActivityView = mvpActivityView
    }

}
package ru.cyber_eagle_owl.saddayappkt.mvpcore.fragment

import ru.cyber_eagle_owl.saddayappkt.mvpcore.fragment.interfaces.MvpFragmentPresenter
import ru.cyber_eagle_owl.saddayappkt.mvpcore.fragment.interfaces.MvpFragmentView

abstract class BaseFragmentPresenter<T : MvpFragmentView> : MvpFragmentPresenter<T> {

    protected var mvpFragmentView : T? = null

    override fun onAttach(mvpFragmentView: T) {
        this.mvpFragmentView = mvpFragmentView
    }
}
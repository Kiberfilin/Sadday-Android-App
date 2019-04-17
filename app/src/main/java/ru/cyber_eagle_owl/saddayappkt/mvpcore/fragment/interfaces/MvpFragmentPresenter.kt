package ru.cyber_eagle_owl.saddayappkt.mvpcore.fragment.interfaces

interface MvpFragmentPresenter<T : MvpFragmentView>{

    fun onAttach(mvpFragmentView : T)
}
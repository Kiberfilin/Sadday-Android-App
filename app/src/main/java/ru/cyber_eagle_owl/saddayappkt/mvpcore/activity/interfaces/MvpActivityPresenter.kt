package ru.cyber_eagle_owl.saddayappkt.mvpcore.activity.interfaces

interface MvpActivityPresenter<T : MvpActivityView>{

    fun onAttach(mvpActivityView: T)
}
package ru.cyber_eagle_owl.saddayappkt.mvpcore

interface MvpPresenter<V : MvpView> {
    val view: V
}
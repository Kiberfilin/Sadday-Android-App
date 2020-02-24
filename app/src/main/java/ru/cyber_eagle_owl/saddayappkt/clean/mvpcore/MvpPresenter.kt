package ru.cyber_eagle_owl.saddayappkt.clean.mvpcore

interface MvpPresenter<V : MvpView> {
    val view: V
}
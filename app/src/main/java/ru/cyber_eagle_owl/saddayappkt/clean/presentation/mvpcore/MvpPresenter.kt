package ru.cyber_eagle_owl.saddayappkt.clean.presentation.mvpcore

interface MvpPresenter<V : MvpView> {
    val view: V
}
package ru.cyber_eagle_owl.saddayappkt.clean.vipercore

import android.view.View
import javax.inject.Inject

abstract class BaseView<P : ViperPresenter> : ViperView<P> {

    @Inject
    override lateinit var presenter: P

    override lateinit var viperRootView: View

    override fun setRootView(rootView: View) {
        viperRootView = rootView
    }
}
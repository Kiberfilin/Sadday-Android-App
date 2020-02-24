package ru.cyber_eagle_owl.saddayappkt.clean.vipercore

import android.view.View

interface ViperView<P : ViperPresenter> {

    val viperRootView: View

    val presenter: P

    fun setRootView(rootView: View)
}

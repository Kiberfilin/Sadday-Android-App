package ru.cyber_eagle_owl.saddayappkt.clean.presentation.features.news

import ru.cyber_eagle_owl.saddayappkt.clean.data.entities.presentation.NewsItem
import ru.cyber_eagle_owl.saddayappkt.clean.mvpcore.MvpPresenter
import ru.cyber_eagle_owl.saddayappkt.clean.mvpcore.MvpView

interface NewsMvp {

    interface View: MvpView {

        fun onNewsHasGotten(news: List<NewsItem>)
    }

    interface Presenter : MvpPresenter<View> {

        fun onViewCreated()
        fun onNewsRefreshingStarted()
    }

    interface Model {

    }
}

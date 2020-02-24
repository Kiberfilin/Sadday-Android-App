package ru.cyber_eagle_owl.saddayappkt.clean.presentation.features.news

import ru.cyber_eagle_owl.saddayappkt.clean.data.entities.presentation.NewsItem
import ru.cyber_eagle_owl.saddayappkt.clean.data.repositories.NewsRepository
import ru.cyber_eagle_owl.saddayappkt.clean.domain.boundaries.presenter.inputports.GetNewsInputPort
import ru.cyber_eagle_owl.saddayappkt.clean.domain.boundaries.presenter.outputports.GetNewsOutputPort
import ru.cyber_eagle_owl.saddayappkt.clean.domain.interactors.GetNewsInteractor
import ru.cyber_eagle_owl.saddayappkt.clean.mvpcore.BasePresenter
import timber.log.Timber
import javax.inject.Inject

class NewsPresenter @Inject constructor() : BasePresenter<NewsMvp.View>(), NewsMvp.Presenter, GetNewsOutputPort {
    private val newsRepo: NewsRepository = NewsRepository()

    private val getNews: GetNewsInputPort = GetNewsInteractor(this, newsRepo)

    override fun onViewCreated() {
        Timber.d("onViewCreated()")

        getNews.execute()
    }

    override fun onNewsRefreshingStarted() {
        getNews.execute()
    }

    override fun onNewsHasGotten(newsToShow: List<NewsItem>) {
        Timber.d("onNewsHasGotten(newsToShow: ArrayList<NewsItem>")

        view.onNewsHasGotten(newsToShow)
    }
}


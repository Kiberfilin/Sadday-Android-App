package ru.cyber_eagle_owl.saddayappkt.clean.domain.interactors

import ru.cyber_eagle_owl.saddayappkt.clean.data.entities.presentation.NewsItem
import ru.cyber_eagle_owl.saddayappkt.clean.domain.boundaries.presenter.inputports.GetNewsInputPort
import ru.cyber_eagle_owl.saddayappkt.clean.domain.boundaries.presenter.outputports.GetNewsOutputPort
import ru.cyber_eagle_owl.saddayappkt.clean.domain.boundaries.repository.inputports.NewsRepositoryInputPort
import ru.cyber_eagle_owl.saddayappkt.clean.domain.boundaries.repository.outputports.NewsRepositoryOutputPort
import timber.log.Timber

class GetNewsInteractor(
    private val presentationOutputPort: GetNewsOutputPort,
    private val dataInputPort: NewsRepositoryInputPort
) : GetNewsInputPort, NewsRepositoryOutputPort {

    init {
        Timber.d("init")

        dataInputPort.setOutputPort(this)
    }

    override fun execute() {
        Timber.d("execute()")

        dataInputPort.getNews()
    }

    override fun onNewsHasGotten(news: List<NewsItem>) {
        Timber.d("onNewsHasGotten(news: ArrayList<NewsItem>)")

        presentationOutputPort.onNewsHasGotten(news)
    }
}
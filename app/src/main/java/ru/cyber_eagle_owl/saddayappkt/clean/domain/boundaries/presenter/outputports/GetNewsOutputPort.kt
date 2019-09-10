package ru.cyber_eagle_owl.saddayappkt.clean.domain.boundaries.presenter.outputports

import ru.cyber_eagle_owl.saddayappkt.clean.data.entities.presentation.NewsItem

interface GetNewsOutputPort {

    fun onNewsHasGotten(newsToShow: List<NewsItem>)
}
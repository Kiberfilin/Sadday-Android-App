package ru.cyber_eagle_owl.saddayappkt.clean.domain.boundaries.repository.outputports

import ru.cyber_eagle_owl.saddayappkt.clean.data.entities.presentation.NewsItem

interface NewsRepositoryOutputPort {

    fun onNewsHasGotten(news: List<NewsItem>)
}
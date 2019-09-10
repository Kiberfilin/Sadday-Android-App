package ru.cyber_eagle_owl.saddayappkt.clean.domain.boundaries.repository.inputports

import ru.cyber_eagle_owl.saddayappkt.clean.domain.boundaries.repository.outputports.NewsRepositoryOutputPort

interface NewsRepositoryInputPort {

    fun setOutputPort(outputPort: NewsRepositoryOutputPort)

    fun getNews()
}
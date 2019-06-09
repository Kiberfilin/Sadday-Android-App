package ru.cyber_eagle_owl.saddayappkt.clean.domain.boundaries.repository.outputports

interface AuthorizationRepositoryOutputPort {

    fun isLoggedInResult(result: Boolean)
}
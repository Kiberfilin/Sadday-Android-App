package ru.cyber_eagle_owl.saddayappkt.clean.domain.boundaries.repository.outputports
@Deprecated("Заменить на RxKotlin")
interface AuthorizationRepositoryOutputPort {

    fun isLoggedInResult(result: Boolean)
}
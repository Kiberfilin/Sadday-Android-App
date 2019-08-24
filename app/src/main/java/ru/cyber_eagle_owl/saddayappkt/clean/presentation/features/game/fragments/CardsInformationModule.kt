package ru.cyber_eagle_owl.saddayappkt.clean.presentation.features.game.fragments

import dagger.Binds
import dagger.Module
import ru.cyber_eagle_owl.saddayappkt.clean.presentation.features.game.GameMvp
import ru.cyber_eagle_owl.saddayappkt.clean.presentation.features.game.GamePresenter
import ru.cyber_eagle_owl.saddayappkt.di.scopes.FragmentScope

@Module
abstract class CardsInformationModule {

    @Binds
    @FragmentScope
    abstract fun view(fragment: CardsInformationFragment): GameMvp.View

    @Binds
    @FragmentScope
    abstract fun presenter(presenter: GamePresenter): GameMvp.Presenter
}

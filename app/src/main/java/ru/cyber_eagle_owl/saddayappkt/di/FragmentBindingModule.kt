package ru.cyber_eagle_owl.saddayappkt.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ru.cyber_eagle_owl.saddayappkt.clean.presentation.features.game.fragments.CardsInformationFragment
import ru.cyber_eagle_owl.saddayappkt.clean.presentation.features.game.fragments.CardsInformationModule
import ru.cyber_eagle_owl.saddayappkt.clean.presentation.features.game.fragments.GameHomeFragment
import ru.cyber_eagle_owl.saddayappkt.di.scopes.FragmentScope

@Module
abstract class FragmentBindingModule {

    @FragmentScope
    @ContributesAndroidInjector //(modules = [WelcomeModule::class])
    abstract fun bindGameHomeFragment(): GameHomeFragment

    @FragmentScope
    @ContributesAndroidInjector (modules = [CardsInformationModule::class])
    abstract fun bindCardsInformationFragment(): CardsInformationFragment

}
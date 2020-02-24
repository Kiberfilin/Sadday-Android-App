package ru.cyber_eagle_owl.saddayappkt.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ru.cyber_eagle_owl.saddayappkt.clean.presentation.features.game.fragments.CardsInformationFragment
import ru.cyber_eagle_owl.saddayappkt.clean.presentation.features.game.fragments.CardsInformationModule
import ru.cyber_eagle_owl.saddayappkt.clean.presentation.features.game.fragments.GameHomeFragment
import ru.cyber_eagle_owl.saddayappkt.clean.presentation.features.place.fragments.PlaceFragmentModule
import ru.cyber_eagle_owl.saddayappkt.clean.presentation.features.place.fragments.PlacesListingFragment
import ru.cyber_eagle_owl.saddayappkt.di.scopes.FragmentScope

@Module
abstract class FragmentBindingModule {

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun bindGameHomeFragment(): GameHomeFragment

    @FragmentScope
    @ContributesAndroidInjector(modules = [CardsInformationModule::class])
    abstract fun bindCardsInformationFragment(): CardsInformationFragment

    @FragmentScope
    @ContributesAndroidInjector(modules = [PlaceFragmentModule::class])
    abstract fun bindPlacesListingFragment(): PlacesListingFragment
}
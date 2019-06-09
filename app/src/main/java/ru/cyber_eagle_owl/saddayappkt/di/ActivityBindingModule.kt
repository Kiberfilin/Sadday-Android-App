package ru.cyber_eagle_owl.saddayappkt.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ru.cyber_eagle_owl.saddayappkt.di.scopes.ActivityScope
import ru.cyber_eagle_owl.saddayappkt.clean.presentation.features.about.AboutActivity
import ru.cyber_eagle_owl.saddayappkt.clean.presentation.features.account.AccountActivity
import ru.cyber_eagle_owl.saddayappkt.clean.presentation.features.authorization.WelcomeActivity
import ru.cyber_eagle_owl.saddayappkt.clean.presentation.features.authorization.WelcomeModule
import ru.cyber_eagle_owl.saddayappkt.clean.presentation.features.fotovideo.FotoVideoActivity
import ru.cyber_eagle_owl.saddayappkt.clean.presentation.features.game.GameActivity
import ru.cyber_eagle_owl.saddayappkt.clean.presentation.features.information.InformationActivity
import ru.cyber_eagle_owl.saddayappkt.clean.presentation.features.menu.MainMenuActivity
import ru.cyber_eagle_owl.saddayappkt.clean.presentation.features.menu.MainMenuModule
import ru.cyber_eagle_owl.saddayappkt.clean.presentation.features.news.NewsActivity
import ru.cyber_eagle_owl.saddayappkt.clean.presentation.features.news.NewsModule
import ru.cyber_eagle_owl.saddayappkt.clean.presentation.features.place.PlaceActivity
import ru.cyber_eagle_owl.saddayappkt.clean.presentation.features.tickets.TicketsActivity

@Module
abstract class ActivityBindingModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [WelcomeModule::class])
    abstract fun bindWelcomeActivity(): WelcomeActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = [MainMenuModule::class])
    abstract fun bindMainMenuActivity(): MainMenuActivity

    @ActivityScope
    @ContributesAndroidInjector
    abstract fun bindAboutActivity(): AboutActivity

    @ActivityScope
    @ContributesAndroidInjector
    abstract fun bindAccountActivity(): AccountActivity

    @ActivityScope
    @ContributesAndroidInjector
    abstract fun bindFotoVideoActivity(): FotoVideoActivity

    @ActivityScope
    @ContributesAndroidInjector
    abstract fun bindGameActivity(): GameActivity

    @ActivityScope
    @ContributesAndroidInjector
    abstract fun bindInformationActivity(): InformationActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = [NewsModule::class])
    abstract fun bindNewsActivity(): NewsActivity

    @ActivityScope
    @ContributesAndroidInjector
    abstract fun bindPlaceActivity(): PlaceActivity

    @ActivityScope
    @ContributesAndroidInjector
    abstract fun bindTicketsActivity(): TicketsActivity
}
package ru.cyber_eagle_owl.saddayappkt.features.menu

import dagger.Binds
import dagger.Module
import ru.cyber_eagle_owl.saddayappkt.di.scopes.ActivityScope

@Module
abstract class MainMenuModule {

    @Binds
    @ActivityScope
    abstract fun view(activity: MainMenuActivity): MainMenuMvp.View

    @Binds
    @ActivityScope
    abstract fun presenter(presenter: MainMenuPresenter): MainMenuMvp.Presenter


}
package ru.cyber_eagle_owl.saddayappkt.clean.presentation.features.news

import dagger.Binds
import dagger.Module
import ru.cyber_eagle_owl.saddayappkt.di.scopes.ActivityScope

@Module
abstract class NewsModule {

    @Binds
    @ActivityScope
    abstract fun view(activity: NewsActivity): NewsMvp.View

    @Binds
    @ActivityScope
    abstract fun presenter(presenter: NewsPresenter): NewsMvp.Presenter
}
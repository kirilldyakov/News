package ru.today.news.di.components

import dagger.Component
import ru.today.news.di.modules.ViewHolderModule
import ru.today.news.di.modules.ViewModelModule
import ru.today.news.di.scopes.PerViewHolder
import ru.today.news.ui.main.articlesRecyclerview.ArticleViewHolder

@PerViewHolder
@Component(
    dependencies = arrayOf(ActivityComponent::class),
    modules = arrayOf(ViewHolderModule::class, ViewModelModule::class)
)
interface ActivityViewHolderComponent {
    fun inject(viewHolder: ArticleViewHolder)
}
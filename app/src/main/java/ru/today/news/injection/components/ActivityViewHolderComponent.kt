package ru.today.news.injection.components

import dagger.Component
import ru.today.news.injection.modules.ViewHolderModule
import ru.today.news.injection.modules.ViewModelModule
import ru.today.news.injection.scopes.PerViewHolder
import ru.today.news.ui.main.recyclerview.ArticleViewHolder

@PerViewHolder
@Component(dependencies = arrayOf(ActivityComponent::class), modules = arrayOf(ViewHolderModule::class, ViewModelModule::class))
interface ActivityViewHolderComponent {
    fun inject(viewHolder: ArticleViewHolder)
}
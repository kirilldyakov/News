package ru.today.news.ui.main.viewpager.allarticles

import ru.today.news.ui.base.viewmodel.AdapterMvvmViewModel
import ru.today.news.ui.main.viewpager.ArticlesView


interface IAllArticlesViewModel : AdapterMvvmViewModel<ArticlesView> {
    //fun reloadData()
    fun reloadData(category: String?)
}
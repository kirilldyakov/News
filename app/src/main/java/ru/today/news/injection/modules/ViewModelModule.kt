package ru.today.news.injection.modules

import dagger.Binds
import dagger.Module
import ru.today.news.ui.main.recyclerview.ArticleMvvm
import ru.today.news.ui.main.recyclerview.ArticleViewModel
import ru.today.news.ui.main.viewpager.allArticle.AllArticlesViewModel
import ru.today.news.ui.main.viewpager.allarticles.IAllArticlesViewModel

@Module
abstract class ViewModelModule {


    // Fragments

    @Binds
    internal abstract fun bindAllArticlesViewModel(allCountriesViewModel: AllArticlesViewModel): IAllArticlesViewModel


    // View Holders

    @Binds
    internal abstract fun bindArticleViewModel(articleViewModel: ArticleViewModel): ArticleMvvm.ViewModel

}
package ru.today.news.di.modules

import dagger.Binds
import dagger.Module
import ru.today.news.ui.main.articlesRecyclerview.ArticleMvvm
import ru.today.news.ui.main.articlesRecyclerview.ArticleViewModel
import ru.today.news.ui.main.viewpager.allArticle.AllArticlesViewModel
import ru.today.news.ui.main.viewpager.allarticles.IAllArticlesViewModel

@Module
abstract class ViewModelModule {


    // Fragments

    @Binds
    internal abstract fun bindAllArticlesViewModel(allArticlesViewModel: AllArticlesViewModel): IAllArticlesViewModel


    // View Holders

    @Binds
    internal abstract fun bindArticleViewModel(articleViewModel: ArticleViewModel): ArticleMvvm.ViewModel

}
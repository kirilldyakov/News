package ru.today.news.ui.main.recyclerview



import ru.today.news.ui.IArticleViewModel
import ru.today.news.ui.base.view.MvvmView

interface ArticleMvvm {

    interface ViewModel : IArticleViewModel<MvvmView> {
        fun onCardClick()
    }
}
package ru.today.news.ui.search.searchRecyclerView

import ru.today.news.ui.IArticleViewModel
import ru.today.news.ui.base.view.MvvmView

interface SearchMvvm {

    interface ViewModel : IArticleViewModel<MvvmView> {
        fun onCardClick()
    }
}
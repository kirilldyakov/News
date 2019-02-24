package ru.today.news.ui.main.recyclerview

import android.view.View
import ru.today.news.databinding.CardArticleBinding
import ru.today.news.ui.base.BaseActivityViewHolder
import ru.today.news.ui.base.view.MvvmView

class ArticleViewHolder(v: View) : BaseActivityViewHolder<CardArticleBinding, ArticleMvvm.ViewModel>(v), MvvmView {

    init {
        bindContentView(v)
    }
}
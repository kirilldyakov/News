package ru.today.news.ui.main.viewpager

import ru.today.news.ui.base.view.MvvmView

interface ArticlesView : MvvmView {
    fun onRefresh(success: Boolean)
}
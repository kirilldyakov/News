package ru.today.news.ui.main.recyclerview

import android.content.Context
import ru.today.news.injection.qualifier.AppContext
import ru.today.news.injection.scopes.PerViewHolder
import ru.today.news.ui.BaseArticleViewModel
import ru.today.news.ui.base.view.MvvmView
import javax.inject.Inject

@PerViewHolder
class ArticleViewModel
@Inject
constructor(@AppContext context: Context) : BaseArticleViewModel<MvvmView>(context), ArticleMvvm.ViewModel {

    override fun onCardClick() {
        //navigator.startActivity(DetailActivity::class.java) { putExtra(Navigator.EXTRA_ARG) }
    }

}
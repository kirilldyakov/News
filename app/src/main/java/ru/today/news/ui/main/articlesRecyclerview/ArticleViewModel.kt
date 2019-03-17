package ru.today.news.ui.main.articlesRecyclerview

import android.content.Context
import android.os.Bundle
import ru.today.news.di.qualifier.AppContext
import ru.today.news.di.scopes.PerViewHolder
import ru.today.news.ui.BaseArticleViewModel
import ru.today.news.ui.base.navigator.Navigator
import ru.today.news.ui.base.view.MvvmView
import ru.today.news.ui.detail.DetailActivity
import javax.inject.Inject


@PerViewHolder
class ArticleViewModel
@Inject
constructor(@AppContext context: Context, navigator: Navigator) : BaseArticleViewModel<MvvmView>(context, navigator), ArticleMvvm.ViewModel {
    override val content: String?
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.

    override fun onCardClick() {

        val bundle = Bundle()
        bundle.putString(DetailActivity.URL_TO_IMAGE, article.urlToImage)
        bundle.putString(DetailActivity.DESCRIPTION, article.description)
        bundle.putString(DetailActivity.TITLE, article.title)

        navigator.startActivity(DetailActivity::class.java) { putExtra(Navigator.EXTRA_ARG, bundle) }
    }


}
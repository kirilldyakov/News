package ru.today.news.ui.main.recyclerview

import android.content.Context
import ru.today.news.data.remote.responses.everything.ArticlesItem
import ru.today.news.injection.qualifier.AppContext
import ru.today.news.injection.scopes.PerViewHolder
import ru.today.news.ui.BaseArticleViewModel
import ru.today.news.ui.base.view.MvvmView
import timber.log.Timber
import javax.inject.Inject

@PerViewHolder
class ArticleViewModel
@Inject
constructor(@AppContext context: Context) : BaseArticleViewModel<MvvmView>(context), ArticleMvvm.ViewModel {
    override val author: String?
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
    override val urlToImage: String?
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
    override val description: String?
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
    override val title: String?
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
    override val url: String?
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
    override val content: String?
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
    override val publishedAt: String?
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.

    override fun update(article: ArticlesItem, isLast: Boolean) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    override fun onCardClick() {
        Timber.d("")
        //navigator.startActivity(DetailActivity::class.java) { putExtra(Navigator.EXTRA_ARG) }
    }


}
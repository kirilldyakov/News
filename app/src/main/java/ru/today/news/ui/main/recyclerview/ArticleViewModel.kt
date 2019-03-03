package ru.today.news.ui.main.recyclerview

import android.content.Context
import ru.today.news.data.remote.responses.everything.ArticlesItem
import ru.today.news.injection.qualifier.AppContext
import ru.today.news.injection.scopes.PerViewHolder
import ru.today.news.ui.BaseArticleViewModel
import ru.today.news.ui.base.navigator.Navigator
import ru.today.news.ui.base.view.MvvmView
import timber.log.Timber
import javax.inject.Inject

@PerViewHolder
class ArticleViewModel
@Inject
constructor(@AppContext context: Context, navigator: Navigator) : BaseArticleViewModel<MvvmView>(context, navigator), ArticleMvvm.ViewModel {
    override val content: String?
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.

    override fun onCardClick() {
        //navigator.startActivity(DetailActivity::class.java) { putExtra(Navigator.EXTRA_ARG) }
        //navigator.replaceFragment();
        Timber.d("click")
    }


}
package ru.today.news.ui.main.articlesRecyclerview

import android.content.Context
import android.content.Intent
import android.os.Bundle
import ru.today.news.di.qualifier.AppContext
import ru.today.news.di.scopes.PerViewHolder
import ru.today.news.ui.BaseArticleViewModel
import ru.today.news.ui.base.navigator.Navigator
import ru.today.news.ui.base.view.MvvmView
import ru.today.news.ui.detail.DetailActivity
import ru.today.news.ui.main.MainActivity
import javax.inject.Inject
import androidx.core.content.ContextCompat.startActivity
import ru.today.news.ui.main.MainActivity
import android.app.ActivityOptions
import android.R



@PerViewHolder
class ArticleViewModel
@Inject
constructor(@AppContext context: Context, navigator: Navigator) : BaseArticleViewModel<MvvmView>(context, navigator), ArticleMvvm.ViewModel {
    override val content: String?
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.

//    override fun onCardClick() {
//
//        val bundle = Bundle()
//        bundle.putString(MainActivity.URL_TO_IMAGE, article.urlToImage)
//        bundle.putString(MainActivity.DESCRIPTION, article.description)
//        bundle.putString(MainActivity.TITLE, article.title)
//
//        navigator.startActivity(DetailActivity::class.java) { putExtra(Navigator.EXTRA_ARG, bundle) }
//    }
    override fun onCardClick() {

        val bundle = Bundle()
        bundle.putString(MainActivity.URL_TO_IMAGE, article.urlToImage)
        bundle.putString(MainActivity.DESCRIPTION, article.description)
        bundle.putString(MainActivity.TITLE, article.title)

        navigator.startActivityTransition(DetailActivity::class.java, findV) { putExtra(Navigator.EXTRA_ARG, bundle) }


    }


}
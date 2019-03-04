package ru.today.news.ui

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.appcompat.widget.AppCompatDrawableManager
import androidx.databinding.Bindable
import ru.today.news.BR
import ru.today.news.data.remote.responses.everything.ArticlesItem
import ru.today.news.injection.qualifier.AppContext
import ru.today.news.ui.base.navigator.Navigator
import ru.today.news.ui.base.view.MvvmView
import ru.today.news.ui.base.viewmodel.BaseViewModel
import java.text.DecimalFormat
import java.util.*

abstract class BaseArticleViewModel<V : MvvmView>(@AppContext context: Context, protected val navigator: Navigator) : BaseViewModel<V>(), IArticleViewModel<V> {

    companion object {
        val DISPLAY_LOCALE = Locale("EN")
        val DECIMAL_FORMAT = DecimalFormat()
    }

    protected val ctx: Context = context.applicationContext


    lateinit var article: ArticlesItem
        protected set

    private var isLast = false


    override fun update(article: ArticlesItem, isLast: Boolean) {
        this.isLast = isLast
        this.article = article

        notifyChange()
    }


    override val publishedAt: String?
        get() {
            return publishedAt
        }
    override val urlToImage: String?
        get() {
            return article.urlToImage
        }
    override val description: String?
        get() {
            return description
        }
    override val url: String?
        get() {
            return url
        }

    override val author: String?
        get() {
            return article.author
        }

    override val title: String?
        get() {
            return article.title
        }
}
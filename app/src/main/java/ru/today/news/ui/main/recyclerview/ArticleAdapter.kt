package ru.today.news.ui.main.recyclerview

import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.simplecityapps.recyclerview_fastscroll.views.FastScrollRecyclerView
import ru.today.news.R
import ru.today.news.data.remote.responses.everything.ArticlesItem
import ru.today.news.injection.scopes.PerFragment
import ru.today.news.util.Utils
import timber.log.Timber
import javax.inject.Inject

//https://startandroid.ru/ru/courses/architecture-components/27-course/architecture-components/542-urok-14-paging-library-chast-1.html
@PerFragment
class ArticleAdapter: PagedListAdapter<ArticlesItem, ArticleViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
//@Inject
//constructor() : RecyclerView.Adapter<ArticleViewHolder>(), FastScrollRecyclerView.SectionedAdapter {
//
//    var articlesList = emptyList<ArticlesItem>()
//
//    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ArticleViewHolder {
//        return Utils.createViewHolder(viewGroup, R.layout.card_article, ::ArticleViewHolder)
//    }
//
//    override fun onBindViewHolder(articlesViewHolder: ArticleViewHolder, position: Int) {
//        articlesViewHolder.viewModel.update(articlesList[position], position == articlesList.size - 1)
//        articlesViewHolder.executePendingBindings()
//    }
//
//    override fun getItemCount(): Int {
//        return articlesList.size
//    }
//
//    override fun getSectionName(position: Int): String {
//        return articlesList[position].title!!.substring(0, 1)
//    }
//}
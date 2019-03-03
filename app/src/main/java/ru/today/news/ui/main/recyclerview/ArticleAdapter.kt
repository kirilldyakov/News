package ru.today.news.ui.main.recyclerview

import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.simplecityapps.recyclerview_fastscroll.views.FastScrollRecyclerView
import ru.today.news.R
import ru.today.news.data.remote.responses.everything.ArticlesItem
import ru.today.news.injection.scopes.PerFragment
import ru.today.news.util.Utils
import timber.log.Timber
import javax.inject.Inject


@PerFragment
class ArticleAdapter
@Inject
constructor() : RecyclerView.Adapter<ArticleViewHolder>(), FastScrollRecyclerView.SectionedAdapter {

    var articlesList = emptyList<ArticlesItem>()

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ArticleViewHolder {
        return Utils.createViewHolder(viewGroup, R.layout.card_article, ::ArticleViewHolder)
    }

    override fun onBindViewHolder(articlesViewHolder: ArticleViewHolder, position: Int) {
        articlesViewHolder.viewModel.update(articlesList[position], position == articlesList.size - 1)
        articlesViewHolder.executePendingBindings()
    }

    override fun getItemCount(): Int {
        return articlesList.size
    }

    override fun getSectionName(position: Int): String {
        return articlesList[position].title!!.substring(0, 1)
    }

    //    @BindingAdapter("android:src")
//    fun setImageUrl(view: ImageView, imageUrl: String) {
//        Glide.with(view.context)
//            .load(imageUrl)
//            .placeholder(R.drawable.ic_image_black_24dp)
//            .into(view)
//    }


}
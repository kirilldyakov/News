package ru.today.news.ui.main.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import ru.today.news.R
import ru.today.news.data.remote.responses.everything.ArticlesItem
import ru.today.news.databinding.CardArticleBinding
import ru.today.news.injection.scopes.PerFragment
import ru.today.news.util.Utils

//https://startandroid.ru/ru/courses/architecture-components/27-course/architecture-components/542-urok-14-paging-library-chast-1.html
//https://medium.com/@paulhundal/paging-library-with-android-mvvm-6a3a4d94de72
@PerFragment
class ArticleAdapter: PagedListAdapter<ArticlesItem, ArticleViewHolder>(diff_callback) {

    companion object {
        val diff_callback: DiffUtil.ItemCallback<ArticlesItem> = object : DiffUtil.ItemCallback<ArticlesItem>() {
            override fun areItemsTheSame(@NonNull oldItem: ArticlesItem, @NonNull newItem: ArticlesItem): Boolean {
                return oldItem.url === newItem.url
            }

            override fun areContentsTheSame(@NonNull oldItem: ArticlesItem, @NonNull newItem: ArticlesItem): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        return Utils.createViewHolder(parent, R.layout.card_article, ::ArticleViewHolder)
        val layoutInflater = LayoutInflater.from(parent.context)
        val viewBinding : CardArticleBinding = CardArticleBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
//        holder.viewModel.update(getItem(position))
//        holder.executePendingBindings()
        val viewHolder = holder as ViewHolder
        getItem(position)?.let {
            viewHolder.bind(it)
        }
    }

    class ViewHolder(private val binding : CardArticleBinding) : RecyclerView.ViewHolder(       binding.root) {
        fun bind(model : ArticlesItem) {
            binding.tvArticleTitle = model.title
        }
    }
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
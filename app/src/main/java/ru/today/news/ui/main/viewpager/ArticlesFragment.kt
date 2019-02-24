package ru.today.news.ui.main.viewpager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import ru.today.news.R
import ru.today.news.databinding.FragmentRecyclerviewBinding
import ru.today.news.ui.base.BaseFragment
import ru.today.news.ui.base.viewmodel.MvvmViewModel
import ru.today.news.ui.main.recyclerview.ArticleAdapter
import javax.inject.Inject

abstract class ArticlesFragment<V : MvvmViewModel<ArticlesView>> : BaseFragment<FragmentRecyclerviewBinding, V>(),
    ArticlesView {

    @Inject
    protected lateinit var adapter: ArticleAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return setAndBindContentView(inflater, container, savedInstanceState, R.layout.fragment_recyclerview)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = adapter
    }

    // View

    override fun onRefresh(success: Boolean) {
        binding.swipeRefreshLayout.isRefreshing = false
    }

}
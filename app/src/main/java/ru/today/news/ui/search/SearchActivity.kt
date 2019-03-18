package ru.today.news.ui.search

import android.os.Bundle
import ru.today.news.R
import ru.today.news.data.db.NewsDatabase
import ru.today.news.databinding.ActivityMainBinding
import ru.today.news.ui.base.BaseActivity
import ru.today.news.ui.base.view.MvvmView
import ru.today.news.ui.base.viewmodel.NoOpViewModel
import ru.today.news.ui.search.searchRecyclerView.SearchAdapter
import javax.inject.Inject


class SearchActivity : BaseActivity<ActivityMainBinding, NoOpViewModel<MvvmView>>(), MvvmView {

    @Inject
    lateinit var adapter: SearchAdapter

    @Inject
    lateinit var newsDatabase: NewsDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setAndBindContentView(savedInstanceState, R.layout.activity_search)

        setSupportActionBar(binding.toolbar)

    }
}

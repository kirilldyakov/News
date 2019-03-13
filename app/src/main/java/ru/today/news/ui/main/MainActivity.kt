package ru.today.news.ui.main

import android.os.Bundle
import ru.today.news.R
import ru.today.news.data.db.NewsDatabase
import ru.today.news.data.db.category.Category
import ru.today.news.databinding.ActivityMainBinding
import ru.today.news.ui.base.BaseActivity
import ru.today.news.ui.base.view.MvvmView
import ru.today.news.ui.base.viewmodel.NoOpViewModel
import ru.today.news.ui.main.viewpager.MainAdapter
import javax.inject.Inject


class MainActivity : BaseActivity<ActivityMainBinding, NoOpViewModel<MvvmView>>(), MvvmView {

    @Inject
    lateinit var adapter: MainAdapter

    @Inject
    lateinit var newsDatabase: NewsDatabase

    companion object {
        const val URL_TO_IMAGE = "URL_TO_IMAGE"
        const val DESCRIPTION = "DESCRIPTION"
        const val TITLE = "TITLE"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setAndBindContentView(savedInstanceState, R.layout.activity_main)

        setSupportActionBar(binding.toolbar)

        binding.viewPager.adapter = adapter
        binding.tabLayout.setupWithViewPager(binding.viewPager)

        newsDatabase.categoryDao.insert(Category("business", "бизнес",0))
        newsDatabase.categoryDao.insert(Category("entertainment", "здоровье",0))
        newsDatabase.categoryDao.insert(Category("general", "главные",0))
        newsDatabase.categoryDao.insert(Category("health", "здоровье",0))
        newsDatabase.categoryDao.insert(Category("science", "наука",0))
        newsDatabase.categoryDao.insert(Category("sports", "спорт",0))
        newsDatabase.categoryDao.insert(Category("technology", "технологии",0))
    }


}

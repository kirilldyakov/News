package ru.today.news.ui.main

import android.os.Bundle
import ru.today.news.R
import ru.today.news.databinding.ActivityMainBinding
import ru.today.news.ui.base.BaseActivity
import ru.today.news.ui.base.view.MvvmView
import ru.today.news.ui.base.viewmodel.NoOpViewModel
import ru.today.news.ui.main.viewpager.MainAdapter
import javax.inject.Inject


class MainActivity : BaseActivity<ActivityMainBinding, NoOpViewModel<MvvmView>>(), MvvmView {

    @Inject
    lateinit var adapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setAndBindContentView(savedInstanceState, R.layout.activity_main)

        setSupportActionBar(binding.toolbar)

        binding.viewPager.adapter = adapter
        binding.tabLayout.setupWithViewPager(binding.viewPager)
    }


}

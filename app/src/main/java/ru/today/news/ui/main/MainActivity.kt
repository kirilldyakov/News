package ru.today.news.ui.main

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import ru.today.news.R
import ru.today.news.data.db.NewsDatabase
import ru.today.news.data.db.category.Category
import ru.today.news.databinding.ActivityMainBinding
import ru.today.news.ui.base.BaseActivity
import ru.today.news.ui.base.navigator.Navigator
import ru.today.news.ui.base.view.MvvmView
import ru.today.news.ui.base.viewmodel.NoOpViewModel
import ru.today.news.ui.detail.DetailActivity
import ru.today.news.ui.main.viewpager.MainAdapter
import ru.today.news.ui.search.SearchActivity
import javax.inject.Inject


class MainActivity : BaseActivity<ActivityMainBinding, NoOpViewModel<MvvmView>>(), MvvmView,
    NavigationView.OnNavigationItemSelectedListener {
    override fun onNavigationItemSelected(p0: MenuItem): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    @Inject
    lateinit var adapter: MainAdapter

    @Inject
    lateinit var navigator:Navigator

    @Inject
    lateinit var newsDatabase: NewsDatabase
        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setAndBindContentView(savedInstanceState, R.layout.activity_main)

        setSupportActionBar(binding.toolbar)

        binding.viewPager.adapter = adapter
        binding.tabLayout.setupWithViewPager(binding.viewPager)

        fillupCategories()

        var toggle = ActionBarDrawerToggle(this, drawer_layout, toolbar,R.string.nav_open, R.string.nav_close  )
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.options_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId){
            R.id.menu_item_search -> {
                var intent = Intent()
                navigator.startActivity(SearchActivity::class.java) }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun fillupCategories() {
        newsDatabase.categoryDao.deleteAll()
        newsDatabase.categoryDao.insert(Category("business", "бизнес", 0))
        newsDatabase.categoryDao.insert(Category("entertainment", "развлечения", 0))
        newsDatabase.categoryDao.insert(Category("general", "главные", 0))
        newsDatabase.categoryDao.insert(Category("health", "здоровье", 0))
        newsDatabase.categoryDao.insert(Category("science", "наука", 0))
        newsDatabase.categoryDao.insert(Category("sports", "спорт", 0))
        newsDatabase.categoryDao.insert(Category("technology", "технологии", 0))
    }


}

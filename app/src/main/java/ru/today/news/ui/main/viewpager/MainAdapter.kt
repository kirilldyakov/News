package ru.today.news.ui.main.viewpager

import android.content.res.Resources
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import ru.today.news.data.db.NewsDatabase
import ru.today.news.di.qualifier.ActivityFragmentManager

import ru.today.news.di.scopes.PerActivity
import ru.today.news.ui.main.viewpager.allarticles.AllArticlesFragment

import javax.inject.Inject

@PerActivity
class MainAdapter
@Inject
constructor(@ActivityFragmentManager fm: FragmentManager, private val res: Resources, val newsDatabase: NewsDatabase) :
    FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return AllArticlesFragment(getPageKey(position) as String?)
    }

    override fun getPageTitle(position: Int): CharSequence? {
        var curCategory = newsDatabase.categoryDao.getAll()
        return curCategory[position].ruName
    }

    fun getPageKey(position: Int): CharSequence? {
        var curCategory = newsDatabase.categoryDao.getAll()
        return curCategory[position].enName
    }

    override fun getCount(): Int {
        return newsDatabase.categoryDao.getAll().count()
    }
}

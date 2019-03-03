package ru.today.news.ui.main.viewpager

import android.content.res.Resources
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import ru.today.news.R
import ru.today.news.injection.qualifier.ActivityFragmentManager

import ru.today.news.injection.scopes.PerActivity
import ru.today.news.ui.main.viewpager.allarticles.AllArticlesFragment

import javax.inject.Inject

@PerActivity
class MainAdapter
@Inject
constructor(@ActivityFragmentManager fm: FragmentManager, private val res: Resources) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when(position) {
            0 -> AllArticlesFragment()
            else -> AllArticlesFragment()
        }
    }

    override fun getPageTitle(position: Int): CharSequence {
        return res.getString(
                when(position) {
                    0 -> R.string.tab_title_all
                    else -> R.string.tab_title_russia
                }
        );
    }

    override fun getCount(): Int {
        return 2
    }
}

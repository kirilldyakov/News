package ru.today.news.ui.base.navigator

import androidx.annotation.IdRes
import androidx.fragment.app.Fragment

interface FragmentNavigator : Navigator {

    fun replaceChildFragment(@IdRes containerId: Int, fragment: Fragment, fragmentTag: String? = null)
    fun replaceChildFragmentAndAddToBackStack(@IdRes containerId: Int, fragment: Fragment, fragmentTag: String?, backstackTag: String?)
    fun popChildFragmentBackstackImmediate()

}
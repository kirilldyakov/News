package ru.today.news.ui.base.navigator

import androidx.annotation.IdRes
import androidx.fragment.app.Fragment

class ChildFragmentNavigator(private val fragment: Fragment) : ActivityNavigator(fragment.activity!!), FragmentNavigator {

    override fun replaceChildFragment(@IdRes containerId: Int, fragment: Fragment, fragmentTag: String?) {
        replaceFragmentInternal(fragment.childFragmentManager, containerId, fragment, fragmentTag, false, null)
    }

    override fun replaceChildFragmentAndAddToBackStack(@IdRes containerId: Int, fragment: Fragment, fragmentTag: String?, backstackTag: String?) {
        replaceFragmentInternal(fragment.childFragmentManager, containerId, fragment, fragmentTag, true, backstackTag)
    }

    override fun popChildFragmentBackstackImmediate() {
        fragment.childFragmentManager.popBackStackImmediate()
    }

}
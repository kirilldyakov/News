package ru.today.news.ui.base.navigator

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.annotation.IdRes
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment

interface Navigator {

    companion object {
        const val EXTRA_ARG = "_args"
    }

    fun finishActivity()
    fun finishActivityWithResult(resultCode: Int, resultIntentFun: (Intent.() -> Unit)? = null)
    fun finishAffinity()

    fun startActivity(intent: Intent)
    fun startActivity(action: String, uri: Uri? = null)
    fun startActivity(activityClass: Class<out Activity>, adaptIntentFun: (Intent.() -> Unit)? = null)

    fun startActivityForResult(activityClass: Class<out Activity>, requestCode: Int, adaptIntentFun: (Intent.() -> Unit)? = null)

    fun <T : DialogFragment> showDialogFragment(dialog: T, fragmentTag: String = dialog.javaClass.name)

    fun replaceFragment(@IdRes containerId: Int, fragment: Fragment, fragmentTag: String? = null)
    fun replaceFragmentAndAddToBackStack(@IdRes containerId: Int, fragment: Fragment, fragmentTag: String? = null, backstackTag: String? = null)
    fun popFragmentBackStackImmediate()

}
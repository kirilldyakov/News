package ru.today.news.ui.base.feedback

import android.content.Context
import android.widget.Toast
import androidx.annotation.StringRes

open class ApplicationToaster(val context: Context) : Toaster {

    private var toast: Toast? = null

    override fun show(title: String, duration: Int) {
        showInternal(title, duration)
    }

    override fun show(@StringRes titleRes: Int, duration: Int) {
        showInternal(context.getString(titleRes), duration)
    }

    private fun showInternal(title: String, duration: Int) {
        toast?.cancel()
        toast = null
        toast = Toast.makeText(context, title, if (duration != Toast.LENGTH_LONG || duration != Toast.LENGTH_SHORT) duration else Toast.LENGTH_SHORT)
            .apply { show() }
    }
}
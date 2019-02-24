package ru.today.news.ui.base.feedback

import android.widget.Toast
import androidx.annotation.StringRes

interface Toaster {

    fun show(title: String, duration: Int = Toast.LENGTH_LONG)
    fun show(@StringRes titleRes: Int, duration: Int = Toast.LENGTH_LONG)

}
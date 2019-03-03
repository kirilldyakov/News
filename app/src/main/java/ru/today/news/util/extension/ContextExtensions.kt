package ru.today.news.util.extension

import android.content.Context
import android.content.ContextWrapper
import android.os.Build
import java.util.*


fun Context.getCurrentLocale(): Locale = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
    this.resources.configuration.locales.get(0)
} else {
    @Suppress("DEPRECATION")
    this.resources.configuration.locale
}

inline fun <reified T> Context.castWithUnwrap(): T? {
    if (this is T) return this

    var context = this
    while (context is ContextWrapper) {
        context = context.baseContext
        if (context is T) {
            return context
        }
    }
    return null
}

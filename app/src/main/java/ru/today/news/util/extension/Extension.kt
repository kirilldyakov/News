package ru.today.news.util.extension

import android.os.Bundle
import ru.today.news.ui.base.view.MvvmView
import ru.today.news.ui.base.viewmodel.MvvmViewModel
import ru.today.news.ui.base.viewmodel.NoOpViewModel

// ViewModel

fun <V : MvvmView> MvvmViewModel<V>.attachViewOrThrowRuntimeException(view: MvvmView, savedInstanceState: Bundle?) {
    try {
        @Suppress("UNCHECKED_CAST")
        this.attachView(view as V, savedInstanceState)
    } catch (e: ClassCastException) {
        if (this !is NoOpViewModel<*>) {
            throw RuntimeException(javaClass.simpleName + " must implement MvvmView subclass as declared in " + this.javaClass.simpleName)
        }
    }
}
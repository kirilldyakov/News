package ru.today.news.ui.base.viewmodel

import android.os.Bundle
import androidx.annotation.CallSuper
import androidx.databinding.BaseObservable
import ru.today.news.ui.base.view.MvvmView

abstract class BaseViewModel<V : MvvmView> : BaseObservable(), MvvmViewModel<V> {

    var view: V? = null
        private set

    @CallSuper
    override fun attachView(view: V, savedInstanceState: Bundle?) {
        this.view = view
        if (savedInstanceState != null) { restoreInstanceState(savedInstanceState) }
    }

    @CallSuper
    override fun detachView() {
        view = null
    }

    protected open fun restoreInstanceState(savedInstanceState: Bundle) { }

    override fun saveInstanceState(outState: Bundle) { }

}
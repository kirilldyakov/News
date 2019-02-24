package ru.today.news.ui.viewmodel

import android.os.Bundle
import androidx.databinding.Observable
import ru.today.news.ui.view.MvvmView

interface MvvmViewModel<V : MvvmView> : Observable {
    fun attachView(view: V, savedInstanceState: Bundle?)
    fun detachView()

    fun saveInstanceState(outState: Bundle)
}
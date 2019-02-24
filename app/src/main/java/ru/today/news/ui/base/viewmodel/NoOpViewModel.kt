package ru.today.news.ui.base.viewmodel

import android.os.Bundle
import androidx.databinding.BaseObservable
import ru.today.news.ui.base.view.MvvmView
import javax.inject.Inject

class NoOpViewModel<V : MvvmView>
@Inject
constructor() : BaseObservable(), MvvmViewModel<V> {

    override fun attachView(view: V, savedInstanceState: Bundle?) {}

    override fun saveInstanceState(outState: Bundle) {}

    override fun detachView() {}

}
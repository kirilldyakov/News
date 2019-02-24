package ru.today.news.ui.base.viewmodel

import androidx.recyclerview.widget.RecyclerView
import ru.today.news.ui.base.view.MvvmView

interface AdapterMvvmViewModel<V : MvvmView> : MvvmViewModel<V> {

    val adapter: RecyclerView.Adapter<*>
}

package ru.today.news.ui.base

import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import ru.today.news.BR
import ru.today.news.injection.components.ActivityViewHolderComponent
import ru.today.news.injection.components.DaggerActivityViewHolderComponent
import ru.today.news.ui.base.view.MvvmView
import ru.today.news.ui.base.viewmodel.MvvmViewModel
import ru.today.news.util.extension.attachViewOrThrowRuntimeException
import timber.log.Timber
import javax.inject.Inject

/**
 * Базовый класс для ViewHolder.
 * Здесь происходит связывание ViewDataBinding-"мапера"(биндинга) и данных (MvvmViewModel)
 */
abstract class BaseActivityViewHolder<B : ViewDataBinding, VM : MvvmViewModel<*>>(itemView: View) : RecyclerView.ViewHolder(itemView),
    MvvmView {

    protected lateinit var binding: B
    @Inject
    lateinit var viewModel: VM
        protected set

    protected val viewHolderComponent: ActivityViewHolderComponent by lazy {
        DaggerActivityViewHolderComponent.builder()
                .activityComponent(itemView.context.castWithUnwrap<BaseActivity<*, *>>()?.activityComponent)
                .build()
    }

    protected fun bindContentView(view: View) {
        try {
            ActivityViewHolderComponent::class.java.getDeclaredMethod("inject", this::class.java).invoke(viewHolderComponent, this)
        } catch(e: NoSuchMethodException) {
            Timber.e("NoSuchMethodException")
        }

        binding = DataBindingUtil.bind(view)!!
        binding.setVariable(BR.vm, viewModel)
        viewModel.attachViewOrThrowRuntimeException(this, null)
    }

    fun executePendingBindings() {
        binding.executePendingBindings()
    }

}
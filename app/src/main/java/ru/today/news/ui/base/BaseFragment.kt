package ru.today.news.ui.base


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.CallSuper
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import ru.today.news.BR
import ru.today.news.di.components.DaggerFragmentComponent
import ru.today.news.di.components.FragmentComponent
import ru.today.news.di.modules.FragmentModule
import ru.today.news.ui.base.view.MvvmView
import ru.today.news.ui.base.viewmodel.MvvmViewModel
import ru.today.news.util.extension.attachViewOrThrowRuntimeException
import timber.log.Timber
import javax.inject.Inject


/**
 * Родительский класс для фрагмента
 * @param B : ViewDataBinding
 * @param VM : MvvmViewModel<*>
 * @property binding B
 * @property viewModel VM
 * @property fragmentComponent FragmentComponent
 */
abstract class BaseFragment<B : ViewDataBinding, VM : MvvmViewModel<*>> : Fragment(), MvvmView {

    protected lateinit var binding: B
    @Inject
    protected lateinit var viewModel: VM

    internal val fragmentComponent: FragmentComponent by lazy {
        DaggerFragmentComponent.builder()
            .fragmentModule(FragmentModule(this))
            .activityComponent((activity as BaseActivity<*, *>).activityComponent)
            .build()
    }

    @CallSuper
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        viewModel.saveInstanceState(outState)
    }

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        try {
            FragmentComponent::class.java.getDeclaredMethod("inject", this::class.java).invoke(fragmentComponent, this)
        } catch (e: NoSuchMethodException) {
            Timber.e(e)
        }
    }

    @CallSuper
    override fun onDestroyView() {
        super.onDestroyView()
        viewModel.detachView()
    }

    @CallSuper
    override fun onDestroy() {
        super.onDestroy()
    }

    protected fun setAndBindContentView(
        inflater: LayoutInflater?,
        container: ViewGroup?,
        savedInstanceState: Bundle?, @LayoutRes layoutResID: Int
    ): View {
        binding = DataBindingUtil.inflate<B>(inflater!!, layoutResID, container, false)
        binding.setVariable(BR.vm, viewModel)
        viewModel.attachViewOrThrowRuntimeException(this, savedInstanceState)
        return binding.root
    }

}
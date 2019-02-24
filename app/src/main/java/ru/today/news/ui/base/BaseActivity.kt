package ru.today.news.ui.base


import android.os.Bundle
import androidx.annotation.CallSuper
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import dagger.android.DaggerActivity
import io.reactivex.disposables.CompositeDisposable
import ru.today.news.injection.components.ActivityComponent
import ru.today.news.injection.qualifier.ActivityDisposable
import ru.today.news.ui.view.MvvmView
import ru.today.news.ui.viewmodel.MvvmViewModel
import ru.today.news.util.extension.attachViewOrThrowRuntimeException
import javax.inject.Inject

abstract class BaseActivity<B : ViewDataBinding, VM : MvvmViewModel<*>> : AppCompatActivity(), MvvmView {

    protected lateinit var binding:B
    @Inject protected lateinit var viewModel: VM

    @field:[Inject ActivityDisposable]
    lateinit var disposable: CompositeDisposable

//    val activityComponent:ActivityComponent by lazy{
//
//    }

    @CallSuper
    override fun onDestroy() {
        super.onDestroy()
        disposable.clear()
        viewModel.detachView()
    }

    protected fun setAndBindContentView(savedInstanceState: Bundle?, @LayoutRes layoutResID: Int) {
        binding = DataBindingUtil.setContentView<B>(this, layoutResID)
        //binding.setVariable(BR.vm, viewModel)
        viewModel.attachViewOrThrowRuntimeException(this, savedInstanceState)
    }
}
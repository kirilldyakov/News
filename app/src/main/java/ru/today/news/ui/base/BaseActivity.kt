package ru.today.news.ui.base


import android.os.Bundle
import androidx.annotation.CallSuper
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import io.reactivex.disposables.CompositeDisposable
import ru.today.news.BR
import ru.today.news.NewsApp
import ru.today.news.di.components.ActivityComponent
import ru.today.news.di.components.DaggerActivityComponent
import ru.today.news.di.modules.ActivityModule
import ru.today.news.di.qualifier.ActivityDisposable
import ru.today.news.ui.base.view.MvvmView
import ru.today.news.ui.base.viewmodel.MvvmViewModel
import ru.today.news.util.extension.attachViewOrThrowRuntimeException
import timber.log.Timber
import javax.inject.Inject

/**
 * Родительский класс для activity.
 * Здесь происходит связывание ViewDataBinding-"мапера"(биндинга) и данных (MvvmViewModel)
 */
abstract class BaseActivity<B : ViewDataBinding, VM : MvvmViewModel<*>> : AppCompatActivity(), MvvmView {

    protected lateinit var binding: B
    @Inject
    protected lateinit var viewModel: VM


    @field:[Inject ActivityDisposable]
    internal lateinit var disposable: CompositeDisposable

    internal val activityComponent: ActivityComponent by lazy {
        DaggerActivityComponent.builder()
            .activityModule(ActivityModule(this))
            .appComponent(NewsApp.appComponent)
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
            ActivityComponent::class.java.getDeclaredMethod("inject", this::class.java).invoke(activityComponent, this)
        } catch (e: NoSuchMethodException) {
            Timber.e(e)
        }
    }

    @CallSuper
    override fun onDestroy() {
        super.onDestroy()
        disposable.clear()
        viewModel.detachView()
    }

    protected fun setAndBindContentView(savedInstanceState: Bundle?, @LayoutRes layoutResID: Int) {
        binding = DataBindingUtil.setContentView<B>(this, layoutResID)
        binding.setVariable(BR.vm, viewModel)
        viewModel.attachViewOrThrowRuntimeException(this, savedInstanceState)
    }

}
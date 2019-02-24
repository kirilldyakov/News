package ru.today.news.ui.base


import androidx.databinding.ViewDataBinding
import ru.today.news.injection.components.AppComponent

abstract class BaseActivity<B : ViewDataBinding, VM : MvvmViewModel<*>>:AppComponent(){

//    internal val activityComponent: ActivityComponent by lazy { }
}
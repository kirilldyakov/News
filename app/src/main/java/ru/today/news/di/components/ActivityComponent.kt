package ru.today.news.di.components

import android.content.Context
import androidx.fragment.app.FragmentManager
import dagger.Component
import io.reactivex.disposables.CompositeDisposable
import ru.today.news.di.modules.ActivityModule
import ru.today.news.di.modules.ViewModelModule
import ru.today.news.di.qualifier.ActivityContext
import ru.today.news.di.qualifier.ActivityDisposable
import ru.today.news.di.qualifier.ActivityFragmentManager
import ru.today.news.di.scopes.PerActivity
import ru.today.news.ui.base.navigator.Navigator
import ru.today.news.ui.main.MainActivity

/**
 * Компонент является связующим звеном между модулями и просителями зависимостей.
 * Для внедрения зависимостей на уровне Activity
 */
@PerActivity
@Component(dependencies = [(AppComponent::class)], modules = [(ActivityModule::class), (ViewModelModule::class)])
interface ActivityComponent : ActivityComponentProvides {

    fun inject(activity: MainActivity)

}

interface ActivityComponentProvides : AppComponentProvides {
    @ActivityContext
    fun activityContext(): Context

    @ActivityFragmentManager
    fun defaultFragmentManager(): FragmentManager

    @ActivityDisposable
    fun activityDisposable(): CompositeDisposable

    fun navigator(): Navigator
//    fun snacker(): Snacker
}
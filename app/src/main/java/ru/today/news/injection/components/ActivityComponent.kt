package ru.today.news.injection.components

import android.content.Context
import androidx.fragment.app.FragmentManager
import dagger.Component
import io.reactivex.disposables.CompositeDisposable
import ru.today.news.injection.modules.ActivityModule
import ru.today.news.injection.modules.ViewModelModule
import ru.today.news.injection.qualifier.ActivityContext
import ru.today.news.injection.qualifier.ActivityDisposable
import ru.today.news.injection.qualifier.ActivityFragmentManager
import ru.today.news.injection.scopes.PerActivity
import ru.today.news.ui.main.MainActivity

@PerActivity
@Component(dependencies = [(AppComponent::class)], modules = [(ActivityModule::class), (ViewModelModule::class)])
interface ActivityComponent : ActivityComponentProvides {
    // create inject methods for your Activities here

    fun inject(activity: MainActivity)

}

interface ActivityComponentProvides : AppComponentProvides {
    @ActivityContext
    fun activityContext(): Context

    @ActivityFragmentManager
    fun defaultFragmentManager(): FragmentManager

    @ActivityDisposable
    fun activityDisposable(): CompositeDisposable

//    fun navigator(): Navigator
//    fun snacker(): Snacker
}
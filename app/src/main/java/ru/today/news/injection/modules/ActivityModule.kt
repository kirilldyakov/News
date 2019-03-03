package ru.today.news.injection.modules

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager

import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import ru.today.news.injection.qualifier.ActivityContext
import ru.today.news.injection.qualifier.ActivityDisposable
import ru.today.news.injection.qualifier.ActivityFragmentManager
import ru.today.news.injection.scopes.PerActivity
import ru.today.news.ui.base.navigator.ActivityNavigator
import ru.today.news.ui.base.navigator.Navigator

/**
 * Класс-модуль предоставляет необходимые зависимости в рамках работы в Activity
 */
@Module
class ActivityModule(private val activity: AppCompatActivity) {

    @Provides
    @PerActivity
    @ActivityContext
    internal fun provideActivityContext(): Context = activity

    @Provides
    @PerActivity
    @ActivityFragmentManager
    internal fun provideFragmentManager(): FragmentManager = activity.supportFragmentManager


    @Provides
    @PerActivity
    internal fun provideNavigator(): Navigator = ActivityNavigator(activity)

    @Provides
    @PerActivity
    @ActivityDisposable
    internal fun provideActivityCompositeDisposable(): CompositeDisposable = CompositeDisposable()
}
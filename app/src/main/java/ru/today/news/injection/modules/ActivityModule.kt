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
    @ActivityDisposable
    internal fun provideActivityCompositeDisposable(): CompositeDisposable = CompositeDisposable()
}
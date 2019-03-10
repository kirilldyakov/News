package ru.today.news.di.modules

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import ru.today.news.di.qualifier.ChildFragmentManager
import ru.today.news.di.qualifier.FragmentDisposable
import ru.today.news.di.scopes.PerFragment
import ru.today.news.ui.base.navigator.ChildFragmentNavigator
import ru.today.news.ui.base.navigator.FragmentNavigator

@Module
class FragmentModule(private val fragment: Fragment) {

    @Provides
    @PerFragment
    @ChildFragmentManager
    internal fun provideChildFragmentManager(): FragmentManager {
        return fragment.childFragmentManager
    }

    @Provides
    @PerFragment
    internal fun provideFragmentNavigator(): FragmentNavigator {
        return ChildFragmentNavigator(fragment)
    }

    @Provides
    @PerFragment
    @FragmentDisposable
    internal fun provideFragmentCompositeDisposable(): CompositeDisposable = CompositeDisposable()

}
package ru.today.news.di.components

import dagger.Component
import io.reactivex.disposables.CompositeDisposable
import ru.today.news.di.modules.FragmentModule
import ru.today.news.di.modules.ViewModelModule
import ru.today.news.di.qualifier.FragmentDisposable
import ru.today.news.di.scopes.PerFragment
import ru.today.news.ui.main.viewpager.allarticles.AllArticlesFragment

/**
 * Компонент является связующим звеном между модулями и просителями зависимостей.
 * Для внедрения зависимостей на уровне фрагмента
 */
@PerFragment
@Component(dependencies = [(ActivityComponent::class)], modules = [(FragmentModule::class), (ViewModelModule::class)])
interface FragmentComponent : FragmentComponentProvides {
    // create inject methods for your Fragments here
    fun inject(fragment: AllArticlesFragment)
}

interface FragmentComponentProvides : ActivityComponentProvides {

    @FragmentDisposable
    fun fragmentDisposable(): CompositeDisposable

}
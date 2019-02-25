package ru.today.news.injection.components

import dagger.Component
import io.reactivex.disposables.CompositeDisposable
import ru.today.news.injection.modules.FragmentModule
import ru.today.news.injection.modules.ViewModelModule
import ru.today.news.injection.qualifier.FragmentDisposable
import ru.today.news.injection.scopes.PerFragment

/**
 * Компонент является связующим звеном между модулями и просителями зависимостей.
 * Для внедрения зависимостей на уровне фрагмента
 */
@PerFragment
@Component(dependencies = [(ActivityComponent::class)], modules = [(FragmentModule::class), (ViewModelModule::class)])
interface FragmentComponent : FragmentComponentProvides {
    // create inject methods for your Fragments here

}

interface FragmentComponentProvides : ActivityComponentProvides {

    @FragmentDisposable
    fun fragmentDisposable(): CompositeDisposable

}
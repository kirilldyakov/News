package ru.today.news.injection.modules

import dagger.Binds
import dagger.Module
import ru.today.news.ui.main.MainMvvm
import ru.today.news.ui.main.MainViewModel

@Module
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindMainViewModel(viewModel: MainViewModel): MainMvvm.ViewModel

}
package ru.today.news.ui.main

import android.os.Bundle
import ru.today.news.R
import ru.today.news.databinding.ActivityMainBinding
import ru.today.news.injection.scopes.PerActivity
import ru.today.news.ui.base.BaseActivity
import ru.today.news.ui.base.view.MvvmView
import ru.today.news.ui.base.viewmodel.BaseViewModel
import ru.today.news.ui.base.viewmodel.MvvmViewModel
import javax.inject.Inject


interface MainMvvm {

    interface View : MvvmView

    interface ViewModel : MvvmViewModel<View>
}

class MainActivity : BaseActivity<ActivityMainBinding, MainMvvm.ViewModel>(), MainMvvm.View {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setAndBindContentView(savedInstanceState, R.layout.activity_main)

        setSupportActionBar(binding.toolbar)
    }
}


@PerActivity
class MainViewModel
@Inject
constructor() : BaseViewModel<MainMvvm.View>(), MainMvvm.ViewModel
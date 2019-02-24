package ru.today.news.ui.base

import android.app.Activity
import ru.today.news.injection.components.AppComponent

abstract class BaseActivity:AppComponent(){

    internal val activityComponent: ActivityComponent by lazy {  }
}
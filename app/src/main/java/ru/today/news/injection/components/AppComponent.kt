package ru.today.news.injection.components

import android.content.Context
import android.content.res.Resources
import dagger.Component
import ru.today.news.data.remote.RTApi
import ru.today.news.injection.scopes.PerApplication
import ru.today.news.injection.modules.AppModule
import ru.today.news.injection.modules.NetworkModule
import ru.today.news.injection.qualifier.AppContext
import ru.today.news.ui.base.feedback.Toaster


@PerApplication
@Component(modules = [(AppModule::class),(NetworkModule::class)])
interface AppComponent : AppComponentProvides {

}

interface AppComponentProvides {
    @AppContext
    fun appContext(): Context

    fun resources(): Resources

    fun rtApi():RTApi

    fun toaster(): Toaster
}


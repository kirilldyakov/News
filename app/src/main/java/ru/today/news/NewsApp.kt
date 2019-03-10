package ru.today.news

import android.app.Application
import android.content.res.Resources
import ru.today.news.di.components.AppComponent
import ru.today.news.di.components.DaggerAppComponent
import ru.today.news.di.modules.AppModule
import timber.log.Timber


/**
 * NewsApp - основной класс приложения
 *
 * DaggerAppComponent создаётся даггером на этапе компиляции.
 */
class NewsApp : Application() {

    companion object {

        lateinit var instance: NewsApp
            private set

        lateinit var appComponent: AppComponent
            private set

        val res: Resources
            get() = instance.resources
    }

    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree())

        instance = this

        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()


    }
}

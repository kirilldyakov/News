package ru.today.news

import android.app.Application
import android.content.res.Resources
import com.facebook.stetho.Stetho
import ru.today.news.di.components.AppComponent
import ru.today.news.di.components.DaggerAppComponent
import ru.today.news.di.modules.AppModule
import ru.today.news.di.modules.NetworkModule
import ru.today.news.di.modules.NewsDatabaseModule
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
            .networkModule(NetworkModule())
            .newsDatabaseModule(NewsDatabaseModule(this))
            .build()

        initStetho()
    }

    private fun initStetho() {
        // Create an InitializerBuilder
        val initializerBuilder = Stetho.newInitializerBuilder(this)

        // Enable Chrome DevTools
        initializerBuilder.enableWebKitInspector(
            Stetho.defaultInspectorModulesProvider(this)
        )

        // Enable command line interface
        initializerBuilder.enableDumpapp(
            Stetho.defaultDumperPluginsProvider(this)
        )

        // Use the InitializerBuilder to generate an Initializer
        val initializer = initializerBuilder.build()

        // Initialize Stetho with the Initializer
        Stetho.initialize(initializer)
    }
}

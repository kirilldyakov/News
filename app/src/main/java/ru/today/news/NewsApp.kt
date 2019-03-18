package ru.today.news

import android.content.res.Resources
import androidx.multidex.MultiDexApplication
import com.crashlytics.android.Crashlytics
import com.facebook.stetho.Stetho
import io.fabric.sdk.android.Fabric
import io.reactivex.Completable
import ru.today.news.data.db.category.Category
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
class NewsApp : MultiDexApplication() {

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

        Fabric.with(this, Crashlytics())

        Timber.plant(Timber.DebugTree())

        instance = this

        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .networkModule(NetworkModule())
            .newsDatabaseModule(NewsDatabaseModule(this))
            .build()

        if (BuildConfig.DEBUG) {
            initStetho()
        }

        fillCategories()
    }

    private fun initStetho() {
        val initializerBuilder = Stetho.newInitializerBuilder(this)
        initializerBuilder.enableWebKitInspector(
            Stetho.defaultInspectorModulesProvider(this)
        )
        initializerBuilder.enableDumpapp(
            Stetho.defaultDumperPluginsProvider(this)
        )
        val initializer = initializerBuilder.build()
        Stetho.initialize(initializer)
    }

    private fun fillCategories() {
        var newsDatabase = NewsApp.appComponent.newsDatabase()

        newsDatabase.categoryDao.deleteAll()
        Completable.fromAction {
            var categories = ArrayList<Category>()

            categories.add(Category("business", "бизнес", 0))
            categories.add(Category("entertainment", "развлечения", 0))
            categories.add(Category("general", "главные", 0))
            categories.add(Category("health", "здоровье", 0))
            categories.add(Category("science", "наука", 0))
            categories.add(Category("sports", "спорт", 0))
            categories.add(Category("technology", "технологии", 0))

            newsDatabase.categoryDao.insertAll(categories)
        }.subscribe()
    }
}

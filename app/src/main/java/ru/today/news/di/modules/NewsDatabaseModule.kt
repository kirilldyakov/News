package ru.today.news.di.modules

import android.app.Application
import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import ru.today.news.R
import ru.today.news.data.db.NewsDatabase
import ru.today.news.data.db.category.CategoryDao
import ru.today.news.di.scopes.PerApplication
import javax.inject.Inject
import javax.inject.Singleton

@Module
class NewsDatabaseModule {
    var newsDatabase: NewsDatabase
    var context: Context

    constructor(application: Application) {
        context = application
        newsDatabase = Room.databaseBuilder(
            application,
            NewsDatabase::class.java,
            context.getString(R.string.dbName)
        )
            .allowMainThreadQueries() //todo убрать
            .build()
    }

    @Provides
    @PerApplication
    fun providesNewsDatabase(): NewsDatabase {
        return newsDatabase
    }

    @Provides
    @PerApplication
    fun providesCategoryDao(newsDatabase: NewsDatabase): CategoryDao {
        return newsDatabase.categoryDao
    }
}
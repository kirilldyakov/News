package ru.today.news.di.modules

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import ru.today.news.data.db.NewsDatabase
import ru.today.news.data.db.category.CategoryDao
import ru.today.news.di.scopes.PerApplication
import javax.inject.Singleton

@Module
class NewsDatabaseModule {
    lateinit var newsDatabase: NewsDatabase

    constructor(application: Application) {
        newsDatabase = Room.databaseBuilder(application, NewsDatabase::class.java, "news-db")
            .allowMainThreadQueries()
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
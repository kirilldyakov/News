package ru.today.news.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.today.news.data.db.category.Category
import ru.today.news.data.db.category.CategoryDao

@Database(entities = [Category::class], version = NewsDatabase.VERSION)
abstract class NewsDatabase : RoomDatabase() {

    abstract val categoryDao: CategoryDao

    companion object {

        const val VERSION = 1
    }

}

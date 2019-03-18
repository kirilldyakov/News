package ru.today.news.data.db.category

import android.database.Cursor
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface CategoryDao {

    @Query("SELECT * FROM "+ Category.TABLE_NAME)
    fun getAll(): List<Category>

    @Insert
    fun insert(category: Category): Long

    @Insert
    fun insertAll(categories: List<Category>): List<Long>

    @Query("SELECT * FROM " + Category.TABLE_NAME)
    fun selectAll(): Cursor

    @Query("SELECT * FROM " + Category.TABLE_NAME + " WHERE " + Category.COLUMN_ID + " = :id")
    fun getCategoryById(id: Int): Cursor

    @Query("DELETE FROM " + Category.TABLE_NAME)
    fun deleteAll(): Int

    @Update
    fun update(category: Category): Int
}
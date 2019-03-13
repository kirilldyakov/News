package ru.today.news.data.db.category

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import ru.today.news.data.db.category.Category.Companion.TABLE_NAME


@Entity(tableName = TABLE_NAME)
class Category {

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

    @ColumnInfo(name = "enname")
    var enName: String = ""

    @ColumnInfo(name = "runame")
    var ruName: String = ""

    @ColumnInfo(name = "checked")
    var checked: Int = 0

    constructor(enName: String, ruName: String, checked: Int) {
        this.enName = enName
        this.ruName = ruName
        this.checked = checked
    }

    companion object {
        const val TABLE_NAME: String = "category"
        const val COLUMN_ID: String = "id"
    }
}


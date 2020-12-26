package com.kirtan.codingtest_openxcell.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey


@Entity(tableName = "user_table")
data class UserTable(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "_id") var _id: Int = 0,
    @ColumnInfo(name = "user_name") var userName: String,
    @ColumnInfo(name = "image_link") var imageLink: String
) {
    @Ignore
    override fun toString(): String {
        return "UserTable(_id=$_id, userName='$userName')"
    }
}
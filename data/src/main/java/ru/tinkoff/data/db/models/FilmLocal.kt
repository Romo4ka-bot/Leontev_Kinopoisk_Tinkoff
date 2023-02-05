package ru.tinkoff.data.db.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "film_table")
data class FilmLocal(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Long
)
package com.example.artsdata.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.artsdata.model.ArtPojo
import com.example.di.TypeConverterQualifier
import com.example.type_converter.ListStringTypeConverter

@Database(
    version = 1,
    entities = [ArtPojo::class],
    exportSchema = false
)
@TypeConverters(
    value = [ListStringTypeConverter::class]
)
abstract class ArtsDataBase : RoomDatabase() {

    abstract val artsListDao: ArtsListDao

    companion object {
        const val DB_NAME = "arts_db"
    }

}


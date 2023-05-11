package com.example.artsdata.db

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.artsdata.model.ArtPojo

@Dao
interface ArtsListDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(arts: List<ArtPojo>)

    @Query("SELECT * FROM ${ArtPojo.tableName}")
    fun pagingSource(): PagingSource<Int, ArtPojo>

    @Query("DELETE FROM ${ArtPojo.tableName}")
    fun clear()

}
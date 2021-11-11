package com.example.testapplication.Dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.testapplication.Entity.ContentEntity
import retrofit2.http.Query

@Dao
interface RequestDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavorite(content: ContentEntity?)
//
//    @Update
//    suspend fun upDateFavorite(content: ContentEntity?)

//    @Delete
//    suspend fun deleteFavorite(content: ContentEntity?)

    @androidx.room.Query("DELETE FROM content_table WHERE content_table.content_ID = :id")
    suspend fun deleteFromFavorite(id: Int)

    @androidx.room.Query("SELECT * FROM content_table")
    fun getAllFavorite() : LiveData<List<ContentEntity>>

    @androidx.room.Query("SELECT count(*) FROM content_table WHERE content_table.content_ID = :id ")
    suspend fun checkFavorite(id : Int): Int


}
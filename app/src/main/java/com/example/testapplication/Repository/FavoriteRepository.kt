package com.example.testapplication.Repository

import androidx.lifecycle.LiveData
import com.example.testapplication.Api.Connectivity
import com.example.testapplication.Dao.RequestDao
import com.example.testapplication.Entity.ContentEntity
import javax.inject.Inject

class FavoriteRepository @Inject constructor(private val requestDao: RequestDao) {

    suspend fun insertFavorite(contentEntity: ContentEntity){

        requestDao.insertFavorite(contentEntity)
    }

    suspend fun upDateFavorite(contentEntity: ContentEntity){

        requestDao.upDateFavorite(contentEntity)
    }

    suspend fun deleteFavorite(contentEntity: ContentEntity){

        requestDao.deleteFavorite(contentEntity)
    }

    fun getAllFavorite() : LiveData<List<ContentEntity>> {

        return requestDao.getAllFavorite()
    }

    suspend fun deleteFromFavorite(id : Int){

        requestDao.deleteFromFavorite(id)
    }

    suspend fun checkFavorite(id: Int) : Int{

       return requestDao.checkFavorite(id)

    }
}
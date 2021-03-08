package com.example.testapplication.DataBase

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.testapplication.Dao.RequestDao
import com.example.testapplication.Entity.ContentEntity

@Database(entities = [ContentEntity::class], version = 1, exportSchema = false)
abstract class RequestDataBase : RoomDatabase() {

    abstract fun getDao() : RequestDao

}
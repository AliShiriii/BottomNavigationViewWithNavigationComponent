package com.example.testapplication.di

import android.content.Context
import androidx.room.Room
import com.example.testapplication.DataBase.RequestDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

//@Module
//@InstallIn(ApplicationContext::class)
//object ModuleDataBase {
//
//    @Provides
//    @Singleton
//    fun provideFavoriteMoveDataBase(@ApplicationContext context: Context) =
//        Room.databaseBuilder(
//            context,
//            RequestDataBase::class.java,
//            "movie_db"
//        ).build()
//
//
//    @Provides
//    @Singleton
//    fun provideFavoriteMoveDao(db: RequestDataBase) = db.getDao()
//
//
//}
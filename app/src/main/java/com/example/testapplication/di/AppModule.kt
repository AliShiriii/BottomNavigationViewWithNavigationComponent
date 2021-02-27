@file:Suppress("DEPRECATION")

package com.example.testapplication.di

import android.content.Context
import androidx.room.Room
import com.example.testapplication.Api.RequestApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit =

        Retrofit.Builder()
            .baseUrl(RequestApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun provideMovieApi(retrofit: Retrofit): RequestApi =
        retrofit.create(RequestApi::class.java)

//    @Provides
//    @Singleton
//    fun provideFavoriteMoveDataBase(@ApplicationContext context: Context) =
//        Room.databaseBuilder(
//            context,
//            FavoriteMovieDataBase::class.java,
//            "movie_db"
//        ).build()
//
//
//    @Provides
//    @Singleton
//    fun provideFavoriteMoveDao(db: FavoriteMovieDataBase) = db.getFavoriteMovieDao()
}
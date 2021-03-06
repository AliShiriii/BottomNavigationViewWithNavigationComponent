@file:Suppress("DEPRECATION")

package com.example.testapplication.di

import android.content.Context
import androidx.room.Room
import com.example.testapplication.Api.Connectivity
import com.example.testapplication.Api.PrettyPrintLogger
import com.example.testapplication.Api.RequestApi
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideConnectivity(@ApplicationContext context: Context): Connectivity {
        return Connectivity(context)
    }

    @Singleton
    @Provides
    fun provideGsonBuilder(): GsonBuilder{
        return GsonBuilder()

    }

    @Singleton
    @Provides
    fun provideGson(builder: GsonBuilder): Gson{

        return builder.setLenient()
            .create()
    }

    @Singleton
    @Provides
    fun provideLogIntercept(builder: GsonBuilder): HttpLoggingInterceptor {
        val logging: HttpLoggingInterceptor
        logging = HttpLoggingInterceptor(PrettyPrintLogger(builder))
        //it is a good practice not to write logs in release
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
        return logging
    }

    @Singleton
    @Provides
    fun provideOkHttp(logging: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(logging)
            .readTimeout(8000, TimeUnit.SECONDS)
            .writeTimeout(8000, TimeUnit.SECONDS)
            .connectTimeout(1, TimeUnit.MINUTES)
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(client: OkHttpClient, gson: Gson): Retrofit =

        Retrofit.Builder()
            .client(client)
            .baseUrl(RequestApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

    @Provides
    @Singleton
    fun provideMovieApi(retrofit: Retrofit): RequestApi =
        retrofit.create(RequestApi::class.java)

}

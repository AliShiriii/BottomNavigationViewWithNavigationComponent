package com.example.testapplication.Api

import com.example.testapplication.Model.Example
import com.example.testapplication.Model.GetContent
import com.example.testapplication.Model.Request
import com.example.testapplication.Model.ResultRequest
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface RequestApi {

    companion object{

        const val BASE_URL = "https://core.gapfilm.ir/"

    }

    @POST("mobile/request.asmx/GetContent/")
    suspend fun pushBody(@Body request: Request) : Response<List<GetContent>>

}
package com.example.testapplication.Api

import com.example.testapplication.Model.RequestBody
import com.example.testapplication.Model.SendRequest
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface RequestApi {



    companion object{

        const val BASE_URL = "https://core.gapfilm.ir/mobile/request.asmx/"

    }

    @POST("GetContentList")
    suspend fun getBody(@Body sendRequest: SendRequest) : RequestBody

}
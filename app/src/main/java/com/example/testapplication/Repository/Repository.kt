package com.example.testapplication.Repository

import com.example.testapplication.Api.RequestApi
import com.example.testapplication.Model.GetContent
import com.example.testapplication.Model.Request
import com.example.testapplication.Model.ResultRequest
import retrofit2.Response
import javax.inject.Inject

class Repository @Inject constructor(private val requestApi: RequestApi) {

    suspend fun pushBody(request: Request) : Response<List<GetContent>>{

       return requestApi.pushBody(request)

    }
}
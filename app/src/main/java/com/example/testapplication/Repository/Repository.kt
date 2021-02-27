package com.example.testapplication.Repository

import com.example.testapplication.Api.RequestApi
import com.example.testapplication.Model.Request
import com.example.testapplication.Model.RequestBody
import retrofit2.Response
import javax.inject.Inject

class Repository @Inject constructor(private val requestApi: RequestApi) {

    suspend fun pushBody(request: Request) : Response<List<RequestBody>>{

       return requestApi.pushBody(request)

    }
}
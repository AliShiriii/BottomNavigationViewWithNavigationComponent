package com.example.testapplication.Api

import androidx.lifecycle.LiveData
import androidx.paging.PagingData
import com.example.testapplication.Model.GetContent
import com.example.testapplication.Model.Request
import com.example.testapplication.Model.SendRequest
import com.example.testapplication.Model.RequestBody
import com.example.testapplication.Model.Result
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import retrofit2.http.*

interface RequestApi {

    companion object{

        const val BASE_URL = "https://core.gapfilm.ir/mobile/request.asmx/"

    }

    @POST("GetContent")
    suspend fun getBody(@Body sendRequest: SendRequest) : Response<RequestBody>

}
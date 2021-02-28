package com.example.testapplication.Paging

//import androidx.paging.PagingSource
//import androidx.paging.PagingState
//import com.example.testapplication.Api.RequestApi
//import com.example.testapplication.Model.GetContent
//import com.example.testapplication.Model.Request
//import com.example.testapplication.Model.RequestBody
//import okhttp3.OkHttpClient
//import retrofit2.HttpException
//import java.io.IOException
//import javax.inject.Inject
//
//class RequestPagingSource @Inject constructor(val api: RequestApi) : PagingSource<Int, RequestBody>() {
//
//    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, RequestBody> {
//
//        val page = params.key ?: 1
//
//        return try {
//            val reques = Request(2, null, 10, 1, "createdate", "desc")
//
//            val result = api.pushBody(reques)
//
//            val response  = result
//
//            LoadResult.Page(
//
//                data = response,
//                prevKey = if (page == 1) null else page -1,
//                nextKey = if (response.isEmpty()) null else page +1
//
//            )
//
//        }catch (exception : IOException){
//
//            LoadResult.Error(exception)
//        }catch (exception : HttpException){
//
//            LoadResult.Error(exception)
//        }
//    }
//
//    override fun getRefreshKey(state: PagingState<Int, RequestBody>): Int? {
//        TODO("Not yet implemented")
//    }
//}
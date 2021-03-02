package com.example.testapplication.ViewModel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.testapplication.Model.GetContent
import com.example.testapplication.Model.SendRequest
import com.example.testapplication.Model.RequestBody
import com.example.testapplication.Model.Result
import com.example.testapplication.Repository.Repository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import retrofit2.Response

@Suppress("DEPRECATION")
class RequestViewModel @ViewModelInject constructor(private val repository: Repository) :
    ViewModel() {

    private val viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

//    private val _pushBody = MutableLiveData<Flow<PagingData<GetContent>>>()
//
//    val pushPost: LiveData<Flow<PagingData<GetContent>>>
//        get() = _pushBody

    var pushPost : Flow<PagingData<GetContent>>? = null

    fun getBody(): Flow<PagingData<GetContent>>? {

        uiScope.launch(Dispatchers.IO) {

            val request = repository.getBody().cachedIn(viewModelScope)

            pushPost = request

        }

        return pushPost

    }
}
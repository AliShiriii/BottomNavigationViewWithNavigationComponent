@file:Suppress("DEPRECATION")

package com.example.testapplication.ViewModel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagingData
import com.example.testapplication.Model.GetContent
import com.example.testapplication.Repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import javax.inject.Inject

@HiltViewModel
class RequestViewModel @Inject constructor(repository: Repository) :
    ViewModel() {

//    private val viewModelJob = Job()
//    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

//    private val _pushBody = MutableLiveData<PagingData<GetContent>>()
//
//    val pushPost: LiveData<PagingData<GetContent>>
//        get() = _pushBody

    var pushPost = repository.getBody()

//    fun getRequestBody() {
//
//        val request = repository.getBody()
//
//        _pushBody.value = request
//
//    }
}
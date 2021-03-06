@file:Suppress("DEPRECATION")

package com.example.testapplication.ViewModel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.testapplication.Model.GetContent
import com.example.testapplication.Repository.Repository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class RequestViewModel @ViewModelInject constructor(private val repository: Repository) :
    ViewModel() {

    private val viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

//    private val _pushBody = MutableLiveData<PagingData<GetContent>>()
//
//    val pushPost: LiveData<PagingData<GetContent>>
//        get() = _pushBody

    var pushPost : LiveData<PagingData<GetContent>>? = null

    fun getBody() {

            val request = repository.getBody()

            pushPost = request

    }
}
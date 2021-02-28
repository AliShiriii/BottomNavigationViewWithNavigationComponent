package com.example.testapplication.ViewModel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.testapplication.Model.Request
import com.example.testapplication.Model.RequestBody
import com.example.testapplication.Repository.Repository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import retrofit2.Response

@Suppress("DEPRECATION")
class RequestViewModel @ViewModelInject constructor(private val repository: Repository) :
    ViewModel() {

    private val viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    private val _pushBody = MutableLiveData<Response<List<RequestBody>>>()

    val pushPost: LiveData<Response<List<RequestBody>>>
        get() = _pushBody

    fun pushBody(request: Request) {

        uiScope.launch {

            val request = repository.pushBody(request)

            _pushBody.value = request

        }
    }
}
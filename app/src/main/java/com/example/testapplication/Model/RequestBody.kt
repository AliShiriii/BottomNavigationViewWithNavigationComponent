package com.example.testapplication.Model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class RequestBody(

    val message: String,

    val result: Result,

    val status: Int
)
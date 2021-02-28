package com.example.testapplication.Model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class RequestBody(
    @SerializedName("message")
    @Expose
    val message: String,

    @SerializedName("result")
    @Expose
    val result: Result,

    @SerializedName("status")
    @Expose
    val status: Int
)
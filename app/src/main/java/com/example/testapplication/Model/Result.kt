package com.example.testapplication.Model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Result(

    @SerializedName("getContentList")
    @Expose
    val getContentList: List<GetContent>,

    @SerializedName("totalPages")
    @Expose
    val totalPages: Int
)
package com.example.testapplication.Model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Result(

    val getContentList: List<GetContent>,

    val totalPages: Int
)
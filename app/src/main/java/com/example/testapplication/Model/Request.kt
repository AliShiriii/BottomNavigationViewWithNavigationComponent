package com.example.testapplication.Model

data class Request(
    val RequestType: Int,
    val RequestId: Any?,
    val PageSize: Int,
    val PageIndex: Int,
    val OrderBy: String,
    val Order: String

    )
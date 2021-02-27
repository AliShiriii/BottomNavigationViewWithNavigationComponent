package com.example.testapplication.Model

data class Request(
    val RequestType: Int,
    val RequestId: Int?,
    val PageSize: Int,
    val PageIndex: Int,
    val OrderBy: String,
    val Order: String

    )
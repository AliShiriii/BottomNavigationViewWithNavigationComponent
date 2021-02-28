package com.example.testapplication.Model

data class Request(
    val requestType: Int,
    val requestId: String?,
    val pageSize: Int,
    val pageIndex: Int,
    val orderBy: String,
    val order: String

    )
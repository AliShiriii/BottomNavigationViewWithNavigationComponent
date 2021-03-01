package com.example.testapplication.Model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Property(

    val name: String,
    val propertyId: Int,
    val value: String
)
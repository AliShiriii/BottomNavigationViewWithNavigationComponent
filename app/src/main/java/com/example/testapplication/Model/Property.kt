package com.example.testapplication.Model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Property(

    @SerializedName("name")
    @Expose
    val name: String,

    @SerializedName("propertyId")
    @Expose
    val propertyId: Int,

    @SerializedName("value")
    @Expose
    val value: String
)
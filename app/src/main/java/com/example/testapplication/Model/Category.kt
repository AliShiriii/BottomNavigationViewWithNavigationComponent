package com.example.testapplication.Model

data class Category(
    val AgeRangeId: String,
    val CategoryID: Int,
    val DefaultImage: String,
    val Image: String,
    val IsFollowed: Boolean,
    val IsSelected: Boolean,
    val ParentID: Int,
    val SectionPriority: Int,
    val Title: String,
    val ZoneID: Int
)
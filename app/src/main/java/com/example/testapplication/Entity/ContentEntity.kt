package com.example.testapplication.Entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
import java.io.Serializable
import java.util.*

@Entity(tableName = "content_table")
@Parcelize
data class ContentEntity(

    @ColumnInfo(name = "content_ID")
    val contentID : Int,

    @ColumnInfo(name = "Title")
    val Title : String,

    @ColumnInfo(name = "Summary")
    val Summary : String,

    @ColumnInfo(name = "Image")
    val Image : String

): Serializable, Parcelable {

    @PrimaryKey(autoGenerate = true)
     var id: Int = 0
}
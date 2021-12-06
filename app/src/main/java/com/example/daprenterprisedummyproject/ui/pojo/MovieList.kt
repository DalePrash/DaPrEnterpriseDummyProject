package com.example.daprenterprisedummyproject.ui.pojo

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
@Entity(tableName = "movieparts_table")
public data class MovieList(
   // @Embedded
    @SerializedName("results")
    val movies: List<Movies>
)
//@Entity(tableName = "movieparts_table")
public data class Movies(
    @SerializedName("original_title")
    val movieTitle: String,
    @SerializedName("original_language")
    val movieLanguage: String,
    @PrimaryKey
    @SerializedName("movieId")
    val id: Long
)
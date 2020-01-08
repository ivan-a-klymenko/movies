package ru.bk.klim9.movies.movies

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

/**
 * @author ivan.a.klymenko@gmail.com on 2019-12-08
 */
@Entity
data class Movie(
    @PrimaryKey
    @SerializedName("id")
    var id: Int = 0,

    @ColumnInfo(name = "poster_path")
    @SerializedName("poster_path")
    var posterPath: String? = null,

    @ColumnInfo(name = "overview")
    @SerializedName("overview")
    var overview: String? = null,

    @ColumnInfo(name = "original_title")
    @SerializedName("original_title")
    var title: String? = null,

    @ColumnInfo(name = "release_date")
    @SerializedName("release_date")
    var releasedDate: String? = null,

    @ColumnInfo(name = "vote_average")
    @SerializedName("vote_average")
    var voteAverage: Double = 0.toDouble()
)

//@Entity
//data class Movie(
//     @PrimaryKey
//     @SerializedName("id")
//     var id: Int = 0
//
//
//)
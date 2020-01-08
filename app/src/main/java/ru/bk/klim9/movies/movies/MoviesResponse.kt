package ru.bk.klim9.movies.movies

import com.google.gson.annotations.SerializedName

/**
 * @author ivan.a.klymenko@gmail.com on 2019-12-08
 */
data class MoviesResponse (
    @SerializedName("results")
    val movies: List<Movie> = arrayListOf()
)




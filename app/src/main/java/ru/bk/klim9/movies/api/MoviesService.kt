package ru.bk.klim9.movies.api

import io.reactivex.Observable
import retrofit2.http.GET
import ru.bk.klim9.movies.movies.MoviesResponse

/**
 * @author ivan.a.klymenko@gmail.com on 2019-12-08
 */
interface MoviesService {

    @GET("popular")
    fun popularMovies(): Observable<MoviesResponse>
}

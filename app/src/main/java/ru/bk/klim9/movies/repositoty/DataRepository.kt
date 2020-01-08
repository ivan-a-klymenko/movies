package ru.bk.klim9.movies.repositoty

import android.util.Log
import io.reactivex.Flowable
import io.reactivex.Observable
import ru.bk.klim9.movies.api.MoviesService
import ru.bk.klim9.movies.database.MoviesDao
import ru.bk.klim9.movies.movies.Movie

private const val TAG = "DataRepository"

class DataRepository(private val service: MoviesService, private val moviesDao: MoviesDao) {

    fun popularMovies(): Observable<List<Movie>> {
        return service.popularMovies()
            .map{ it.movies }
            .doOnNext { movies ->
                val currentMovies = moviesDao.movies()
                moviesDao.clear(currentMovies)
                moviesDao.saveAll(movies)
            }
            .onErrorResumeNext{t: Throwable ->
                Log.d(TAG, "popularMovies error: ${t.message}", t)
                val movies = moviesDao.movies()
                Observable.just(movies)
            }
    }

    fun observeMovie(movieId: Int): Flowable<Movie> {
        return moviesDao.observeMovie(movieId)
    }
}

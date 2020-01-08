package ru.bk.klim9.movies.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.reactivex.Flowable

import ru.bk.klim9.movies.movies.Movie

/**
 * @author ivan.a.klymenko@gmail.com
 */
@Dao
interface MoviesDao {

    @Query("SELECT * FROM movie")
    fun movies(): List<Movie>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveAll(movies: List<Movie>)

    @Delete
    fun clear(movies: List<Movie>)

    @Query("SELECT * FROM movie WHERE  id = :movieId")
    fun observeMovie(movieId: Int): Flowable<Movie>
}

package ru.bk.klim9.movies.database

import androidx.room.Database
import androidx.room.RoomDatabase

import ru.bk.klim9.movies.movies.Movie

/**
 * @author ivan.a.klymenko@gmail.com on 2019-12-08
 */
@Database(entities = [Movie::class], version = 1, exportSchema = false)
abstract class MoviesDatabase : RoomDatabase() {
    abstract fun moviesDao(): MoviesDao
}

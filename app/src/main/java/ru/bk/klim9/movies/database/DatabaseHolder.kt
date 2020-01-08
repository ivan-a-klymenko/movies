package ru.bk.klim9.movies.database

import android.content.Context

import androidx.annotation.MainThread
import androidx.room.Room

/**
 * @author ivan.a.klymenko@gmail.com on 2019-12-08
 */
object DatabaseHolder {

    private lateinit var database: MoviesDatabase

    @MainThread
    fun init(context: Context) {
        database = Room.databaseBuilder(
            context.applicationContext,
            MoviesDatabase::class.java,
            "movies-database"
        ).build()
    }

    fun database(): MoviesDatabase {
        return database
    }
}

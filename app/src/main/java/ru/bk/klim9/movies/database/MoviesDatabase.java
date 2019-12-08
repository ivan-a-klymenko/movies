package ru.bk.klim9.movies.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import ru.gdg.arturvasilov.popularmovies.data.database.dao.MoviesDao;
import ru.gdg.arturvasilov.popularmovies.data.movies.Movie;

/**
 * @author Artur Vasilov
 */
@Database(entities = {Movie.class}, version = 1)
public abstract class MoviesDatabase extends RoomDatabase {
    public abstract MoviesDao moviesDao();
}

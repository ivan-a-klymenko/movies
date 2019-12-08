package ru.bk.klim9.movies;

import android.app.Application;

import ru.gdg.arturvasilov.popularmovies.data.database.DatabaseHolder;

/**
 * @author Artur Vasilov
 */
public class MoviesApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        DatabaseHolder.init(this);
    }
}

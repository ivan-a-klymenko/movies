package ru.bk.klim9.movies;

import ru.bk.klim9.movies.di.ApplicationComponent;

import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;
import ru.bk.klim9.movies.database.DatabaseHolder;
import ru.bk.klim9.movies.di.DaggerApplicationComponent;

/**
 * @author ivan.a.klymenko@gmail.com on 2019-12-08
 */
public class MoviesApp extends BaseApplication {

    private static MoviesApp instance;

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        applicationComponent = DaggerApplicationComponent.builder().application(this).build();
        instance = this;
        super.onCreate();
    }

    public static MoviesApp getInstance() {
        return instance;
    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return applicationComponent;
    }

    @Override
    protected void initDataBase() {
        DatabaseHolder.INSTANCE.init(this);
    }

}

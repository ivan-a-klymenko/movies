package ru.bk.klim9.movies;


import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;

/**
 * @author Ivan
 */
abstract public class BaseApplication extends DaggerApplication {


    @Override
    public void onCreate() {
        super.onCreate();
        initDataBase();
    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return null;
    }

    protected abstract void initDataBase();
}

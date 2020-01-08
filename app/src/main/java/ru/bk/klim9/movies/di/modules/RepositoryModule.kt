package ru.bk.klim9.movies.di.modules

import dagger.Module
import dagger.Provides
import ru.bk.klim9.movies.api.ApiFactory
import ru.bk.klim9.movies.api.MoviesService
import ru.bk.klim9.movies.database.DatabaseHolder
import ru.bk.klim9.movies.database.MoviesDao
import ru.bk.klim9.movies.repositoty.DataRepository
import javax.inject.Singleton

@Suppress("unused")
@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideSiteSpecsRepository(api: MoviesService, moviesDao: MoviesDao) =
        DataRepository(api, moviesDao)

    @Singleton
    @Provides
    fun provideMoviesService() : MoviesService {
        return ApiFactory.moviesService
    }

    @Singleton
    @Provides
    fun provideMoviesDao(): MoviesDao {
        return DatabaseHolder.database().moviesDao()
    }
}
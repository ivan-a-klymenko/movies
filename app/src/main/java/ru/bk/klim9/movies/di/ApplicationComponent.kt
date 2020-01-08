package ru.bk.klim9.movies.di

import android.app.Application
import ru.bk.klim9.movies.di.modules.DaggerViewModelInjectionModule
import ru.bk.klim9.movies.di.modules.RepositoryModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import ru.bk.klim9.movies.MoviesApp
import ru.bk.klim9.movies.di.modules.DetailsModule
import ru.bk.klim9.movies.di.modules.MoviesModule
import javax.inject.Singleton

/**
 * @author Ivan
 */
@Singleton
@Component(
    modules = [AndroidSupportInjectionModule::class,
        RepositoryModule::class,
        DaggerViewModelInjectionModule::class,
        MoviesModule::class,
        DetailsModule::class]
)
interface ApplicationComponent : AndroidInjector<MoviesApp> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): ApplicationComponent
    }
}
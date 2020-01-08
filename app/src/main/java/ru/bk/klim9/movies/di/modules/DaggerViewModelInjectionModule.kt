package ru.bk.klim9.movies.di.modules

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import ru.bk.klim9.movies.di.modules.DaggerViewModelFactory

/**
 * Configures bindings to [DaggerViewModelFactory], injectable into a [ViewModelProvider.Factory].
 */
@Module
abstract class DaggerViewModelInjectionModule {
    @Binds
    abstract fun bindViewModelFactory(factory: DaggerViewModelFactory): ViewModelProvider.Factory
}
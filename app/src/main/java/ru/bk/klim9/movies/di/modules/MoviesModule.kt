package ru.bk.klim9.movies.di.modules

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import ru.bk.klim9.movies.ui.movies.MoviesFragment
import ru.bk.klim9.movies.ui.movies.MoviesViewModel

/**
 * @author ivan.a.klymenko@gmail.com on 2019-12-13
 */
@Suppress("unused")
@Module
abstract class MoviesModule {

    @ContributesAndroidInjector
    abstract fun contributesContactsFragment(): MoviesFragment

    @Binds
    @IntoMap
    @ViewModelKey(MoviesViewModel::class)
    abstract fun bindsContactsViewModel(moviesViewModel: MoviesViewModel): ViewModel
}
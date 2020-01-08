package ru.bk.klim9.movies.di.modules

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import ru.bk.klim9.movies.ui.details.DetailsFragment
import ru.bk.klim9.movies.ui.details.DetailsViewModel

/**
 * @author ivan.a.klymenko@gmail.com on 2020-01-07
 */
@Suppress("unused")
@Module
abstract class DetailsModule {

    @ContributesAndroidInjector
    abstract fun contributesDetailsFragment(): DetailsFragment

    @Binds
    @IntoMap
    @ViewModelKey(DetailsViewModel::class)
    abstract fun bindsDetailsViewModel(detailsViewModel: DetailsViewModel): ViewModel
}
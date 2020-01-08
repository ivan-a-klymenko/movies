package ru.bk.klim9.movies.ui.details

import android.util.Log
import androidx.lifecycle.MutableLiveData
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ru.bk.klim9.movies.movies.Movie
import ru.bk.klim9.movies.ui.common.BaseViewModel
import javax.inject.Inject

private const val TAG = "DetailsViewModel"

class DetailsViewModel @Inject constructor() : BaseViewModel() {

    val movieLd = MutableLiveData<Movie>()

    fun observeMovie(movieId: Int) {
        cd.add(repository.observeMovie(movieId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ m: Movie? ->
                m?.let {
                    movieLd.postValue(it)
                }
            }, {
                Log.d(TAG,"observeMovie error: ${it.message}", it)
            })
        )
    }

}

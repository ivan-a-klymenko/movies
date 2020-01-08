package ru.bk.klim9.movies.ui.movies

import android.util.Log
import androidx.lifecycle.MutableLiveData
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ru.bk.klim9.movies.movies.Movie
import ru.bk.klim9.movies.ui.common.ApiError
import ru.bk.klim9.movies.ui.common.BaseViewModel
import ru.bk.klim9.movies.ui.common.IApiErrorHandler
import javax.inject.Inject

const val TAG = "MoviesViewModel"

class MoviesViewModel @Inject constructor(): BaseViewModel(), IApiErrorHandler {

    val moviesLd = MutableLiveData<List<Movie>>()

    override fun onCleared() {
        super.onCleared()
        cd.clear()
    }

    fun getMovies(){
        cd.add(repository.popularMovies()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe{loadingLd.value = true}
            .doAfterTerminate{loadingLd.value = false}
            .subscribe({moviesLd.value = it},
                {
                    Log.d(TAG, "getMoviesLd error ${it.message}", it)
                    throwableHandle(it)
                }))
    }

    override fun getApiErrorValue(): MutableLiveData<ApiError> = apiErrorLd
}

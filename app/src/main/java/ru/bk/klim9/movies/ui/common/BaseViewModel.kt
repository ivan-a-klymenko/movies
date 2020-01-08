package ru.bk.klim9.movies.ui.common

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import ru.bk.klim9.movies.repositoty.DataRepository
import javax.inject.Inject

/**
 * @author ivan.a.klymenko@gmail.com on 2019-12-30
 */
open class BaseViewModel @Inject constructor() : ViewModel() {

    @Inject
    lateinit var repository: DataRepository
    protected open val cd = CompositeDisposable()

    open val loadingLd = MutableLiveData<Boolean>()
    open val apiErrorLd = MutableLiveData<ApiError>()

    override fun onCleared() {
        super.onCleared()
        cd.clear()
    }
}
package ru.bk.klim9.movies.ui.common

import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.Group
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import retrofit2.HttpException
import ru.bk.klim9.movies.R
import java.net.ConnectException

/**
 * @author ivan.a.klymenko@gmail.com on 2020-01-07
 */

interface IApiErrorHandler {

    fun throwableHandle(t: Throwable) {
        val apiError = when (t) {
            is ConnectException -> ApiError.API_CONNECTION_LOST
//            some logic for Throwable handling. This logic must be provided by the business part of the team
            else -> ApiError.API_ANY_ERROR
        }
        getApiErrorValue().postValue(apiError)
    }

    fun getApiErrorValue(): MutableLiveData<ApiError>
}

interface IApiErrorMessage {

    val localContext: FragmentActivity
        get() = localContext()

    fun showApiError(error: ApiError) {
        val message = localContext.getString(error.valueId)
        Toast.makeText(localContext, message, Toast.LENGTH_SHORT).show()
    }

    fun localContext(): FragmentActivity
}
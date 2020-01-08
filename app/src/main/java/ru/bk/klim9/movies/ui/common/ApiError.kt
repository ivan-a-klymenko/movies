package ru.bk.klim9.movies.ui.common

import androidx.annotation.StringRes
import ru.bk.klim9.movies.R

/**
 * @author ivan.a.klymenko@gmail.com on 2020-01-07
 */
enum class ApiError(@StringRes val valueId: Int) {
    API_CONNECTION_LOST(R.string.api_connection_lost),
    API_ANY_ERROR(R.string.api_any_error)
}
package ru.bk.klim9.movies.api

import okhttp3.Interceptor
import okhttp3.Response
import ru.bk.klim9.movies.BuildConfig
import java.io.IOException

internal class ApiKeyInterceptor : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        val url = request.url.newBuilder()
            .addQueryParameter("api_key", BuildConfig.API_KEY)
            .build()
        request = request.newBuilder().url(url).build()
        return chain.proceed(request)
    }
}

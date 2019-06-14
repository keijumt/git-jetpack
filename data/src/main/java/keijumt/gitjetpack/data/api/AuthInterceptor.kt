package keijumt.gitjetpack.data.api

import keijumt.gitjetpack.data.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor : Interceptor {

    companion object {
        private const val AUTHORIZATION_HEADER = "Authorization"
    }

    override fun intercept(chain: Interceptor.Chain): Response {
        val builder = chain.request().newBuilder()
        val apiToken = BuildConfig.API_TOKEN
        if (apiToken.isNotBlank() && apiToken != "null") {
            builder.addHeader(AUTHORIZATION_HEADER, "token $apiToken")
        }
        return chain.proceed(builder.build())
    }
}
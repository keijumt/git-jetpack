package keijumt.gitjetpack.data.di

import dagger.Module
import dagger.Provides
import keijumt.gitjetpack.data.api.GithubService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class ApiModule {

    @Singleton
    @Provides
    fun provideGithubService(
        okHttpClient: OkHttpClient,
        gsonConverterFactory: GsonConverterFactory
    ): GithubService {
        return Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .client(okHttpClient)
            .addConverterFactory(gsonConverterFactory)
            .build()
            .create(GithubService::class.java)
    }
}
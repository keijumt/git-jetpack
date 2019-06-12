package keijumt.gitjetpack.data.api

import keijumt.gitjetpack.data.response.RepoSearchResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface GithubService {

    @GET("search/repositories")
    suspend fun searchRepos(@Query("q") query: String): RepoSearchResponse
}
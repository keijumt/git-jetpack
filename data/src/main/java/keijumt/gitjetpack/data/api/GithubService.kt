package keijumt.gitjetpack.data.api

import keijumt.gitjetpack.data.response.RepoSearchResponse
import keijumt.gitjetpack.data.response.UserSearchResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface GithubService {

    @GET("search/repositories")
    suspend fun searchRepos(@Query("q") query: String): RepoSearchResponse

    @GET("search/users")
    suspend fun searchUsers(@Query("q") query: String):UserSearchResponse
}
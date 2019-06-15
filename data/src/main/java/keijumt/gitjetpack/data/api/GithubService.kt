package keijumt.gitjetpack.data.api

import keijumt.gitjetpack.data.response.RepoResponse
import keijumt.gitjetpack.data.response.ReposSearchResponse
import keijumt.gitjetpack.data.response.UserResponse
import keijumt.gitjetpack.data.response.UsersSearchResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GithubService {

    @GET("search/repositories")
    suspend fun searchReposByRepoName(@Query("q") query: String): ReposSearchResponse

    @GET("users/{userId}/repos")
    suspend fun searchReposByUserId(@Path("userId") userId: String): List<RepoResponse>

    @GET("search/users")
    suspend fun searchUsers(@Query("q") query: String): UsersSearchResponse

    @GET("users/{userId}")
    suspend fun searchUser(@Path("userId") userId: String): UserResponse
}
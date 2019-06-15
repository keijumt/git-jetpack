package keijumt.gitjetpack.data.repository

import keijumt.gitjetpack.data.api.GithubService
import keijumt.gitjetpack.data.mapper.toRepos
import keijumt.gitjetpack.data.result.Result
import keijumt.gitjetpack.model.Repo

interface RepoRepository {
    suspend fun searchByRepoName(q: String): Result<List<Repo>>
    suspend fun searchByUserId(q: String): Result<List<Repo>>
}

internal class RepoRepositoryImpl(
    private val githubService: GithubService
) : RepoRepository {
    override suspend fun searchByRepoName(q: String): Result<List<Repo>> {
        return try {
            val repos = githubService.searchReposByRepoName(q).items.toRepos()
            Result.Success(repos)
        } catch (e: Exception) {
            Result.Error(e)
        }
    }

    override suspend fun searchByUserId(q: String): Result<List<Repo>> {
        return try {
            val repos = githubService.searchReposByUserId(q).toRepos()
            Result.Success(repos)
        } catch (e: Exception) {
            println(e)
            Result.Error(e)
        }
    }
}
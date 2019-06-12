package keijumt.gitjetpack.data.repository

import keijumt.gitjetpack.data.api.GithubService
import keijumt.gitjetpack.data.mapper.toRepos
import keijumt.gitjetpack.data.result.Result
import keijumt.gitjetpack.model.Repo

interface RepoRepository {
    suspend fun search(q: String): Result<List<Repo>>
}

internal class RepoRepositoryImpl(
    private val githubService: GithubService
) : RepoRepository {
    override suspend fun search(q: String): Result<List<Repo>> {
        return try {
            val repos = githubService.searchRepos(q).items.toRepos()
            Result.Success(repos)
        } catch (e: Exception) {
            Result.Error(e)
        }
    }
}
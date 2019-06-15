package keijumt.gitjetpack.data.repository

import keijumt.gitjetpack.data.api.GithubService
import keijumt.gitjetpack.data.mapper.toOwners
import keijumt.gitjetpack.data.result.Result
import keijumt.gitjetpack.model.Owner

interface UserRepository {
    suspend fun search(q: String): Result<List<Owner>>
}

internal class UserRepositoryImpl(
    private val githubService: GithubService
) : UserRepository {
    override suspend fun search(q: String): Result<List<Owner>> {
        return try {
            val owners = githubService.searchUsers(q).items.toOwners()
            Result.Success(owners)
        } catch (e: Exception) {
            Result.Error(e)
        }
    }
}
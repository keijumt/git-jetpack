package keijumt.gitjetpack.data.repository

import keijumt.gitjetpack.data.api.GithubService
import keijumt.gitjetpack.data.mapper.toOwners
import keijumt.gitjetpack.data.mapper.toUser
import keijumt.gitjetpack.data.result.Result
import keijumt.gitjetpack.model.Owner
import keijumt.gitjetpack.model.User

interface UserRepository {
    suspend fun search(q: String): Result<List<Owner>>
    suspend fun detail(userId: String): Result<User>
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

    override suspend fun detail(userId: String): Result<User> {
        return try {
            val user = githubService.searchUser(userId).toUser()
            Result.Success(user)
        } catch (e: Exception) {
            println(e)
            Result.Error(e)
        }
    }
}
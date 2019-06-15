package keijumt.gitjetpack.data.mapper

import keijumt.gitjetpack.data.response.OwnerResponse
import keijumt.gitjetpack.data.response.UserResponse
import keijumt.gitjetpack.model.Owner
import keijumt.gitjetpack.model.User

fun UserResponse.toUser(): User {
    return User(
        userId = userId,
        name = name,
        avatarUrl = avatarUrl,
        followers = followers,
        following = following
    )
}

fun List<OwnerResponse>.toOwners(): List<Owner> {
    return map {
        Owner(
            userId = it.userId,
            url = it.url,
            avatarUrl = it.avatarUrl
        )
    }
}
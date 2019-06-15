package keijumt.gitjetpack.data.mapper

import keijumt.gitjetpack.data.response.OwnerResponse
import keijumt.gitjetpack.data.response.RepoResponse
import keijumt.gitjetpack.model.Owner
import keijumt.gitjetpack.model.Repo

fun List<RepoResponse>.toRepos(): List<Repo> {
    return map {
        Repo(
            id = it.id,
            name = it.name,
            fullName = it.fullName,
            description = it.description,
            owner = it.owner.toOwner(),
            stars = it.stars
        )
    }
}

fun OwnerResponse.toOwner(): Owner {
    return Owner(
        userId = userId,
        url = url,
        avatarUrl = avatarUrl
    )
}
package keijumt.gitjetpack.data.mapper

import keijumt.gitjetpack.data.response.OwnerResponse
import keijumt.gitjetpack.model.Owner

fun List<OwnerResponse>.toOwners(): List<Owner> {
    return map {
        Owner(
            userId = it.userId,
            url = it.url,
            avatarUrl = it.avatarUrl
        )
    }
}
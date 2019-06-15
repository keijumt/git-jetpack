package keijumt.gitjetpack.data.response

import com.google.gson.annotations.SerializedName

data class OwnerResponse(
    @SerializedName("login")
    val userId: String,
    @SerializedName("url")
    val url: String?,
    @SerializedName("avatar_url")
    val avatarUrl: String
)
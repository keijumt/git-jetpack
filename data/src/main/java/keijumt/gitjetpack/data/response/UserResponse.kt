package keijumt.gitjetpack.data.response

import com.google.gson.annotations.SerializedName

data class UserResponse(
    @SerializedName("login")
    val userId: String,
    val name: String,
    @SerializedName("avatar_url")
    val avatarUrl: String,
    val followers: Int,
    val following: Int
)
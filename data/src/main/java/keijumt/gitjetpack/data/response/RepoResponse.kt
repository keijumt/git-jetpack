package keijumt.gitjetpack.data.response

import com.google.gson.annotations.SerializedName

data class RepoResponse(
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("full_name")
    val fullName: String,
    @SerializedName("description")
    val description: String?,
    @SerializedName("owner")
    val owner: OwnerResponse,
    @SerializedName("stargazers_count")
    val stars: Int
)
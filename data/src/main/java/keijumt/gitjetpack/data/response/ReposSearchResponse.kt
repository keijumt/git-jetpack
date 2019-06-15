package keijumt.gitjetpack.data.response

import com.google.gson.annotations.SerializedName

data class ReposSearchResponse(
    @SerializedName("total_count")
    val total: Int = 0,
    @SerializedName("items")
    val items: List<RepoResponse>
)
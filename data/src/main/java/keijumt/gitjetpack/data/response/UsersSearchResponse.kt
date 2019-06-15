package keijumt.gitjetpack.data.response

import com.google.gson.annotations.SerializedName

data class UsersSearchResponse(
    @SerializedName("total_count")
    val total: Int = 0,
    @SerializedName("items")
    val items: List<OwnerResponse>
)
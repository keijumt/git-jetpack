package keijumt.gitjetpack.data.response

import com.google.gson.annotations.SerializedName

data class OwnerResponse(
    @SerializedName("login")
    val login: String,
    @SerializedName("url")
    val url: String?
)
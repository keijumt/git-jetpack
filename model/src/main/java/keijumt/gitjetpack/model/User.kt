package keijumt.gitjetpack.model

data class User(
    val userId: String,
    val name: String,
    val avatarUrl: String,
    val followers: Int,
    val following: Int
)
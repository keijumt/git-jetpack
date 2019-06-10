package keijumt.gitjetpack.ui

import androidx.annotation.IdRes

enum class PageConfiguration(
    val id: Int,
    val hasTitle: Boolean = true,
    val hideToolbar: Boolean = false,
    val displayHomeAsUpEnabled: Boolean = false,
    val hideBottomNavigation: Boolean = false
) {

    OTHER(0);

    companion object {
        fun getConfiguration(@IdRes id: Int): PageConfiguration {
            return enumValues<PageConfiguration>().firstOrNull { it.id == id } ?: OTHER
        }
    }
}
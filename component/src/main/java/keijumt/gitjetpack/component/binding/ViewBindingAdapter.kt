package keijumt.gitjetpack.component.binding

import android.view.View
import androidx.databinding.BindingAdapter

@BindingAdapter("goneUnless")
fun View.goneUnless(visible: Boolean) {
    visibility = if (visible) View.VISIBLE else View.GONE
}

@BindingAdapter("clipToCircle")
fun View.clipToCircle(clip: Boolean) {
    clipToOutline = clip
    outlineProvider = if (clip) {
        CircularOutlineProvider
    } else {
        null
    }
}
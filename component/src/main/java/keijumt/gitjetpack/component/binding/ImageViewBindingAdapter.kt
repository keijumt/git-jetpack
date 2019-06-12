package keijumt.gitjetpack.component.binding

import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.BitmapTransitionOptions

@BindingAdapter("imageUrl")
fun ImageView.imageUrl(url: String?) {
    url ?: return

    val uri = url.toUri()
    Glide.with(this.context)
        .asBitmap()
        .load(uri)
        .transition(BitmapTransitionOptions.withCrossFade())
        .into(this)
}
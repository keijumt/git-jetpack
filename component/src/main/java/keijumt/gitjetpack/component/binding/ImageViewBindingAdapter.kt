package keijumt.gitjetpack.component.binding

import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.BitmapTransitionOptions

@BindingAdapter("imageUrl", "circleCrop", requireAll = false)
fun ImageView.imageUrl(url: String?, isCircleCrop: Boolean?) {
    url ?: return

    val uri = url.toUri()
    val builder = Glide.with(this.context)
        .asBitmap()
        .let {
            if (isCircleCrop == true) {
                it.circleCrop()
            }
            it
        }

    builder.load(uri)
        .transition(BitmapTransitionOptions.withCrossFade())
        .into(this)
}
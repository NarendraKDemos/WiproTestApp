package com.techguys.wiprotestapp.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.techguys.wiprotestapp.R

val requestOptions = RequestOptions().apply {
    //placeholder(R.drawable.image_placeholder)
    diskCacheStrategy(DiskCacheStrategy.ALL)
    skipMemoryCache(false)
    //error(R.drawable.image_placeholder)
}

@BindingAdapter("imageUrl")
fun setImageUrl(view: ImageView, url: String?) {
    Glide.with(view.context)
        .setDefaultRequestOptions(requestOptions)
        .load(url)
        .into(view)
}

package com.pratik.catchywall.presentation.adapters

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners

@BindingAdapter("loadImage")
fun loadImage(imageView: ImageView, imageUrl: String) {

    imageView.let {
        Glide.with(imageView.context).load(imageUrl).into(imageView)
    }

}

@BindingAdapter("roundedLoadImage")
fun roundedLoadImage(imageView: ImageView, imageUrl: String = "") {

    imageView.let {
        Glide.with(imageView.context).load(imageUrl)
            .transform(CenterCrop(), RoundedCorners(50))
            .into(imageView)
    }

}

@BindingAdapter("loadImageWith20dp")
fun loadImageWith20dp(imageView: ImageView, imageUrl: String = "") {

    imageView.let {
        Glide.with(imageView.context).load(imageUrl)
            .transform(CenterCrop(), RoundedCorners(20))
            .into(imageView)
    }

}

package com.pratik.catchywall.presentation.adapters

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions

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

@BindingAdapter("roundImage")
fun roundImage(imageView: ImageView, imageUrl: String = "") {

    imageView.let {
        Glide.with(imageView.context).load(imageUrl).apply(RequestOptions.circleCropTransform())
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

@BindingAdapter("loadImageWith20dpAndPlaceholderColor", "placeholderColor")
fun loadImageWith20dpAndPlaceholderColor(
    imageView: ImageView,
    imageUrl: String = "",
    placeholderColor: String
) {
    imageView.let {
        Glide.with(imageView.context).load(imageUrl)
            .placeholder(
                ColorDrawable(
                    Color.parseColor(placeholderColor)
                )
            )
            .transform(CenterCrop(), RoundedCorners(20))
            .into(imageView)
    }

}


@BindingAdapter("isTextVisible")
fun isTextVisible(
    view: View,
    text: String? = ""
) {
    view.let {
        if (text == "" || text == null) {
            view.visibility = View.GONE
        } else {
            view.visibility = View.VISIBLE
        }
    }
}

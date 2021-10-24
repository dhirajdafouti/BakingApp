package com.hellofresh.task2.utils

import android.view.View
import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import com.google.android.material.snackbar.Snackbar
import com.squareup.picasso.Picasso

@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, imgUrl: String?) {
    imgUrl?.let {
        val imgUri = it.toUri().buildUpon()?.scheme("https")?.build()
        Picasso.with(imgView.context)
            .load(imgUri)
            .into(imgView)
    }
}

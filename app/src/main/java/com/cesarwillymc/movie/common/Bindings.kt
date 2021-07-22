package com.cesarwillymc.movie.common

import com.cesarwillymc.movie.R

import android.view.View
import android.widget.EditText
import android.widget.ImageView
import androidx.cardview.widget.CardView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

@set:BindingAdapter("visible")
var View.visible
    get() = visibility == View.VISIBLE
    set(value) {
        visibility = if (value) View.VISIBLE else View.GONE
    }

@BindingAdapter("app:visibilityText")
fun setVisibilty(view: View, isVisible: Boolean) {
    if (isVisible) {
        view.show()
    } else {
        view.hide()
    }
}
@BindingAdapter("app:errorText")
fun setError(tInputLayout: EditText, str: String?) {
    if (str.isNullOrEmpty()) {
        tInputLayout.error = null
    } else {
        tInputLayout.error = str

    }
}
@BindingAdapter("app:enabledView")
fun CardView.setEnabledView(enabled: Boolean) {
    this.isEnabled=enabled
    if(enabled){
        setCardBackgroundColor(context.getColor(R.color.enabled))
    }else{
        setCardBackgroundColor(context.getColor(R.color.disable))
    }
}


@BindingAdapter("imageUrl", requireAll = false)
fun ImageView.imageUrl(url: String?) {
    Glide.with(this).load("https://image.tmdb.org/t/p/w500$url").into(this)
}

@BindingAdapter("itemDecorationSpacing")
fun RecyclerView.setItemDecorationSpacing(spacingPx: Float) {
    addItemDecoration(
        RecyclerViewItemDecoration(spacingPx.toInt())
    )
}




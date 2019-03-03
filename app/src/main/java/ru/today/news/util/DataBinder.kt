package ru.today.news.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.card_article.view.*
import ru.today.news.R

object DataBinder {

    @JvmStatic
    @BindingAdapter("imageUrl")
    fun setImageUrl(imageView: ImageView, url: String?) {
        val context = imageView.context
        Glide
            .with(context)
            .load(url)
            .placeholder(R.drawable.ic_image_black_24dp)
            .into(imageView)
    }
}//NO-OP
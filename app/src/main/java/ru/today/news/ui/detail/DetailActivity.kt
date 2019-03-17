package ru.today.news.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail.*
import ru.today.news.R
import ru.today.news.ui.main.MainActivity

class DetailActivity : AppCompatActivity() {

    companion object {
        const val URL_TO_IMAGE = "URL_TO_IMAGE"
        const val DESCRIPTION = "DESCRIPTION"
        const val TITLE = "TITLE"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val bundle = intent.getBundleExtra("_args")
        val title:String? = bundle.getString(TITLE)
        val urlToImage:String? = bundle.getString(URL_TO_IMAGE)
        val description:String? = bundle.getString(DESCRIPTION)

        Glide.with(this)
            .load(urlToImage)
            .into(img_header)

        tv_detail_body.text = description
        tv_detail_title.text = title
    }
}

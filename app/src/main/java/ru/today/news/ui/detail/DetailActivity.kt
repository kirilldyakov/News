package ru.today.news.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail.*
import ru.today.news.R
import ru.today.news.ui.main.MainActivity

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        var bundle = intent.getBundleExtra("_args")
        var title:String = bundle.getString(MainActivity.TITLE)
        var urlToImage:String = bundle.getString(MainActivity.URL_TO_IMAGE)
        var description:String = bundle.getString(MainActivity.DESCRIPTION)

        Glide.with(this)
            .load(urlToImage)
            .into(img_header)

        tv_detail_body.text = description
        tv_detail_title.text = title

    }
}

package ru.today.news.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil.setContentView
import retrofit2.Retrofit
import ru.today.news.R
import ru.today.news.data.remote.RTApi
import ru.today.news.ui.base.BaseActivity
import javax.inject.Inject




class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }
}

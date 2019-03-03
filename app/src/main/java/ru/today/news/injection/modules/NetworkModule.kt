package ru.today.news.injection.modules

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import ru.today.news.data.remote.RTApi
import ru.today.news.injection.scopes.PerApplication
import java.util.concurrent.TimeUnit

/**
 * Модуль для организации работы с сетевыми запросами
 */
@Module
class NetworkModule {

    private val baseUrl = "https://newsapi.org/"
    private val authKeyValue = "316663a2285f472b95de0a7f73cf2046"

    //Ковертер Json в объекты
    @Provides
    @PerApplication
    fun provideGson(): Gson {
        return GsonBuilder().create()
    }

    //Настройка работы с сетью
    @Provides
    @PerApplication
    fun provideOkHttpClient(): OkHttpClient {

        val builder = OkHttpClient.Builder()
        builder.connectTimeout(30, TimeUnit.SECONDS)
        builder.readTimeout(30, TimeUnit.SECONDS)
        builder.writeTimeout(30, TimeUnit.SECONDS)
        builder.addInterceptor { chain ->
            val newRequest = chain.request().newBuilder()
                .addHeader("Authorization", authKeyValue).build()
            chain.proceed(newRequest)
        }
        return OkHttpClient()
    }


    /**
     * Класс RTApi - доступ с API сервису с помощью HTTP клиента Retrofit.
     */
    @Provides
    @PerApplication
    fun providesRTApi(gson: Gson, okHttpClient: OkHttpClient): RTApi {
        val httpClientBuilder = okHttpClient.newBuilder()

        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .callFactory(httpClientBuilder.build())
            .build().create(RTApi::class.java)
    }

}
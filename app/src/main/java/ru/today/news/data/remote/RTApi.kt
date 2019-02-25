package ru.today.news.data.remote

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query
import ru.today.news.data.remote.responses.everything.EverythingModel
import ru.today.news.data.remote.responses.sources.SourcesModel
import ru.today.news.data.remote.responses.topheadlines.TopHeadlinesModel

/**
 * Интерфейс для работы Retrofit
 */
interface RTApi {

    @GET("/v2/top-headlines")
    fun getTopHeadlines(
        @Header("X-Api-Key") apiKey: String,
        @Query("country") country: String,
        @Query("category") category: String,
        @Query("sources") sources: String,
        @Query("q") query: String,
        @Query("pageSize") pagesize: Int,
        @Query("page") page: Int
    ): Single<TopHeadlinesModel>

    @GET("/v2/everything")
    fun everything(
        @Header("X-Api-Key") apiKey: String,
        @Query("q") query: String?
    ): Single<EverythingModel>

    @GET("/v2/everything")
    fun everything(
        @Header("X-Api-Key") apiKey: String,
        @Query("q") query: String?,
        @Query("sources") sources: String?,
        @Query("domains") domains: String?,
        @Query("excludeDomains") excludeDomains: String?,
        @Query("from") fromDate: String?,
        @Query("to") toDate: String?,
        @Query("language") language: String?,
        @Query("sortBy") sortby: String?,
        @Query("pageSize") pagesize: Int?,
        @Query("page") page: Int?
    ): Single<EverythingModel>

    //https://newsapi.org/docs/endpoints/sources
    @GET("/v2/sources")
    fun getSources(
        @Header("X-Api-Key") apiKey: String,
        @Query("category") category: String,
        @Query("language") language: String,
        @Query("country") country: String
    ): Single<SourcesModel>
}
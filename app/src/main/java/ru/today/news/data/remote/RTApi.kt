package ru.today.news.data.remote

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query
import ru.today.news.data.remote.responses.articles.ArticlesModel
import ru.today.news.data.remote.responses.sources.SourcesModel

/**
 * Интерфейс для работы Retrofit
 */
interface RTApi {
    /**
     * Top headlines.
     * This endpoint provides live top and breaking
     * headlines for a country, specific category in a country, single source,
     * or multiple sources. You can also search with keywords. Articles are sorted by the
     * earliest date published first.
     */
    @GET("/v2/top-headlines")
    fun getTopHeadlines(
        @Header("X-Api-Key") apiKey: String,
        @Query("country") country: String? = null,
        @Query("category") category: String? = null,
        @Query("sources") sources: String? = null,
        @Query("q") query: String? = null,
        @Query("pageSize") pageSize: Int? = null,
        @Query("page") page: Int? = null
    ): Single<ArticlesModel>


    /**
     * Everything.
     * Search through millions of articles from over 30,000 large and small news
     * sources and blogs. This includes breaking news as well as lesser articles.
     */
    @GET("/v2/everything")
    fun everything(
        @Header("X-Api-Key") apiKey: String,
        @Query("q") query: String?
    ): Single<ArticlesModel>

    @GET("/v2/everything")
    fun everythingByCategory(
        @Header("X-Api-Key") apiKey: String,
        @Query("category") category: String?
    ): Single<ArticlesModel>

    @GET("/v2/everything")
    fun everything(
        @Header("X-Api-Key") apiKey: String
    ): Single<ArticlesModel>

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
    ): Single<ArticlesModel>

    /**
     * Sources.
     * This endpoint returns the subset of news publishers that
     * top headlines (/v2/top-headlines) are available from.
     * It's mainly a convenience endpoint that you can use to keep track of
     * the publishers available on the API, and you can pipe it straight through to your users.
     */
    @GET("/v2/sources")
    fun getSources(
        @Header("X-Api-Key") apiKey: String,
        @Query("category") category: String,
        @Query("language") language: String,
        @Query("country") country: String
    ): Single<SourcesModel>
}
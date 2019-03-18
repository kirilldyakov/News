package ru.today.news.data.remote.responses.articles

data class ArticlesModel(
	val totalResults: Int? = null,
	val articles: List<ArticlesItem?>? = null,
	val status: String? = null
)

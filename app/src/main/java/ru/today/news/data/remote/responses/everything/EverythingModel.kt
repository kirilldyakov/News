package ru.today.news.data.remote.responses.everything

data class EverythingModel(
	val totalResults: Int? = null,
	val articles: List<ArticlesItem?>? = null,
	val status: String? = null
)

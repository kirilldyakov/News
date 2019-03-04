package ru.today.news.ui.main.viewpager.allArticle

import android.os.Bundle
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import ru.today.news.data.remote.RTApi
import ru.today.news.data.remote.responses.everything.ArticlesItem
import ru.today.news.injection.scopes.PerFragment
import ru.today.news.ui.base.viewmodel.BaseViewModel
import ru.today.news.ui.main.recyclerview.ArticleAdapter
import ru.today.news.ui.main.viewpager.ArticlesView
import ru.today.news.ui.main.viewpager.allarticles.IAllArticlesViewModel
import timber.log.Timber
import java.util.*
import javax.inject.Inject

@PerFragment
class AllArticlesViewModel
@Inject
constructor(override val adapter: ArticleAdapter, private val rtApi: RTApi) : BaseViewModel<ArticlesView>(),
    IAllArticlesViewModel {

    private val compositeDisposable = CompositeDisposable()

    override fun attachView(view: ArticlesView, savedInstanceState: Bundle?) {
        super.attachView(view, savedInstanceState)

    }

    override fun detachView() {
        super.detachView()
        compositeDisposable.clear()
    }

    override fun reloadData() {
        compositeDisposable.add(
            rtApi.everything("316663a2285f472b95de0a7f73cf2046","Москва")
                .doOnSuccess({ Timber.d("Collections.sort(it)") })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnError(Consumer {t ->  Timber.e(t) })
                .subscribe({ it ->
                    adapter.articlesList = it.articles as List<ArticlesItem>
                    adapter.notifyDataSetChanged()
                    view?.onRefresh(true)
                }, {
                    Timber.e(it, "Could not load Articles")
                    view?.onRefresh(false)
                })
        )
    }
}
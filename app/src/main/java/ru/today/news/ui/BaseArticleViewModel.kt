package ru.today.news.ui

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.appcompat.widget.AppCompatDrawableManager
import androidx.databinding.Bindable
import ru.today.news.BR
import ru.today.news.data.remote.responses.everything.ArticlesItem
import ru.today.news.injection.qualifier.AppContext
import ru.today.news.ui.base.view.MvvmView
import ru.today.news.ui.base.viewmodel.BaseViewModel
import java.text.DecimalFormat
import java.util.*

abstract class BaseArticleViewModel<V : MvvmView>(@AppContext context: Context) : BaseViewModel<V>(), IArticleViewModel<V> {

    companion object {
        val DISPLAY_LOCALE = Locale("EN")
        val DECIMAL_FORMAT = DecimalFormat()
    }

    protected val ctx: Context = context.applicationContext
//    protected val mapsAvailable: Boolean


    lateinit var article: ArticlesItem
        protected set

    private var isLast = false

//    init {
//        var mapsAvailable = false
//
//        try {
//            context.packageManager.getPackageInfo("com.google.android.apps.maps", 0)
//            mapsAvailable = true
//        } catch (ignore: PackageManager.NameNotFoundException) { }
//
//        this.mapsAvailable = mapsAvailable
//    }
//
//    override fun onMapClick() {
//        val gmmIntentUri = Uri.parse("geo:" + country.lat + "," + country.lng + "?q=" + country.name + "&z=2")
//        navigator.startActivity(Intent.ACTION_VIEW, gmmIntentUri)
//    }
//
//    override fun onBookmarkClick() {
//        val realmCountry = countryRepo.getByField("alpha2Code", country.alpha2Code, false)
//
//        if (realmCountry == null) {
//            countryRepo.save(country)
//        } else {
//            country = countryRepo.detach(realmCountry)
//            countryRepo.delete(realmCountry)
//        }
//
//        notifyPropertyChanged(BR.bookmarkDrawable)
//    }
//
    override fun update(article: ArticlesItem, isLast: Boolean) {
        this.isLast = isLast
        this.article = article

        notifyChange()
    }


    override val publishedAt: String?
        get() {
            return publishedAt
        }
    override val urlToImage: String?
        get() {
            return article.urlToImage
        }
    override val description: String?
        get() {
            return description
        }
    override val url: String?
        get() {
            return url
        }

    override val author: String?
        get() {
            return article.author
        }

    override val title: String?
        get() {
            return article.title
        }
//
//    override val name: String
//        get() {
//            var nameInfo = country.name + " (" + country.alpha2Code
//            if (country.name != country.nativeName) {
//                nameInfo += ", " + country.nativeName
//            }
//            return nameInfo + ")"
//        }
//
//    override val region: CharSequence
//        get() = SpannableStringBuilder(ctx.getText(R.string.country_region))
//                .append(country.region)
//
//    override val isCapitalVisible: Boolean
//        get() = !TextUtils.isEmpty(country.capital)
//
//    override val capital: CharSequence
//        get() = SpannableStringBuilder(ctx.getText(R.string.country_capital))
//                .append(country.capital)
//
//    override val population: CharSequence
//        get() = SpannableStringBuilder(ctx.getText(R.string.country_population))
//                .append(DECIMAL_FORMAT.format(country.population))
//
//    override val isLocationVisible: Boolean
//        get() = country.lat != null && country.lng != null
//
//    override val location: CharSequence
//        get() {
//            if (isLocationVisible) {
//                return SpannableStringBuilder(ctx.getText(R.string.country_location))
//                        .append(DECIMAL_FORMAT.format(country.lat))
//                        .append(", ")
//                        .append(DECIMAL_FORMAT.format(country.lng))
//            } else {
//                return ""
//            }
//        }
//
//    override val bookmarkDrawable: Drawable
//        @Bindable
//        get() = AppCompatDrawableManager.get().getDrawable(ctx, if (countryRepo.getByField("alpha2Code", country.alpha2Code!!, false) != null) R.drawable.ic_bookmark_black else R.drawable.ic_bookmark_border_black)
//
//    override val isMapVisible: Boolean
//        get() = mapsAvailable && country.lat != null && country.lng != null
//
//    override val cardBottomMargin: Int
//        get() = if (isLast) ctx.resources.getDimension(R.dimen.card_outer_padding).toInt() else 0
}
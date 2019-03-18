package ru.today.news.di.modules

import android.app.Application
import android.content.Context
import android.content.res.Resources
import dagger.Module
import dagger.Provides
import ru.today.news.di.qualifier.AppContext
import ru.today.news.di.scopes.PerApplication
import ru.today.news.ui.base.feedback.ApplicationToaster
import ru.today.news.ui.base.feedback.Toaster

/**
 * Модуль – это фабрика объектов, разрешающая наши зависимости.
 * Разрешает зависимости на уровне приложения
 */
@Module
class AppModule(private val app: Application) {

    //Доступ к контексту приложения
    @Provides
    @PerApplication
    @AppContext
    internal fun provideAppContext(): Context = app

    //Доступ к ресурсам приложения
    @Provides
    @PerApplication
    internal fun provideResources(): Resources = app.resources

    //Доступ к элементу Toast, отображающему сообщения
    @Provides
    @PerApplication
    internal fun provideToaster(): Toaster = ApplicationToaster(app)
}

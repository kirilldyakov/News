package ru.today.news.injection.modules

import android.app.Application
import android.content.Context
import android.content.res.Resources
import dagger.Module
import dagger.Provides
import ru.today.news.injection.qualifier.AppContext
import ru.today.news.injection.scopes.PerApplication
import ru.today.news.ui.base.feedback.ApplicationToaster
import ru.today.news.ui.base.feedback.Toaster

@Module
class AppModule(private  val app: Application) {

    @Provides
    @PerApplication
    @AppContext
    internal fun provideAppContext(): Context = app

    @Provides
    @PerApplication
    internal fun provideResources(): Resources = app.resources

    @Provides
    @PerApplication
    internal fun provideToaster(): Toaster = ApplicationToaster(app)
}

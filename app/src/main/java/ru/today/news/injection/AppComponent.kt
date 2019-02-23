package ru.today.news.injection

import dagger.Component
import ru.today.news.injection.scopes.PerApplication
import ru.today.news.injection.modules.AppModule

class AppComponent {

    @PerApplication
    @Component(modules = [(AppModule::class)])
    interface AppComponent : AppComponentProvides {

    }
}

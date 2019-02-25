package ru.today.news.injection.scopes

import javax.inject.Scope

/**
 * Область видимости - Activity
 *
 */
@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class PerActivity
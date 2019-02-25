package ru.today.news.injection.scopes

import javax.inject.Scope

/**
 * Область видимости - приложение
 *
 */
@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class PerApplication
package ru.today.news.di.scopes

import javax.inject.Scope

/**
 * Область видимости - приложение
 *
 */
@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class PerApplication
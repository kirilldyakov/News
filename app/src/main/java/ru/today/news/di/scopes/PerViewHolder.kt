package ru.today.news.di.scopes

import javax.inject.Scope

/**
 * Область видимости - элемент списка
 *
 */
@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class PerViewHolder

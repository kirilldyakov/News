package ru.today.news.injection.scopes

import javax.inject.Scope

/**
 * Область видимости - элемент списка
 *
 */
@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class PerViewHolder

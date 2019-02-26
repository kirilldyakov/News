/* Copyright 2016 Patrick Löwenstein
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * FILE MODIFIED 2017 Tailored Media GmbH */

package ru.today.news.ui

import ru.today.news.data.remote.responses.everything.ArticlesItem
import ru.today.news.ui.base.view.MvvmView
import ru.today.news.ui.base.viewmodel.MvvmViewModel

interface IArticleViewModel<V : MvvmView> : MvvmViewModel<V> {

//    fun onMapClick()
    //fun onBookmarkClick()
    fun update(article: ArticlesItem, isLast: Boolean)

    // Properties

    val publishedAt: String?
    val author: String?
    val urlToImage: String?
    val description: String?
    val title: String?
    val url: String?
    val content: String?
}

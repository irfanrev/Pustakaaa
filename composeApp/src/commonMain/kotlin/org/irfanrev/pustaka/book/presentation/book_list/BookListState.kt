package org.irfanrev.pustaka.book.presentation.book_list

import org.irfanrev.pustaka.book.domain.Book
import org.irfanrev.pustaka.core.presentation.UiText

data class BookListState(

    val searchQuery: String = "Kotlin",
    val searchResults: List<Book> = emptyList(),
    val favoriteBooks: List<Book> = emptyList(),
    val isLoading: Boolean = false,
    val selectedTabIndex: Int = 0,
    val errorMessage: UiText? = null

)

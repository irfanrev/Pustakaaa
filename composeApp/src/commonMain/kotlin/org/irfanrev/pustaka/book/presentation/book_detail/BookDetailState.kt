package org.irfanrev.pustaka.book.presentation.book_detail

import org.irfanrev.pustaka.book.domain.Book

data class BookDetailState (
    val isLoading: Boolean = false,
    val isFavorite: Boolean = false,
    val book: Book? = null
)



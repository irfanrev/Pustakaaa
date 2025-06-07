package org.irfanrev.pustaka.book.presentation.book_detail

import org.irfanrev.pustaka.book.domain.Book

sealed interface BookDetailAction {

    data object OnBookClick: BookDetailAction
    data object OnFavofiteClick: BookDetailAction
    data class OnSelectedBookChange(val book: Book): BookDetailAction

}
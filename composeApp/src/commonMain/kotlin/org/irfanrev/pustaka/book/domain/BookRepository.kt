package org.irfanrev.pustaka.book.domain

import org.irfanrev.pustaka.core.domain.DataError
import org.irfanrev.pustaka.core.domain.Result

interface BookRepository {

    suspend fun searchBooks(query: String): Result<List<Book>, DataError.Remote>

}
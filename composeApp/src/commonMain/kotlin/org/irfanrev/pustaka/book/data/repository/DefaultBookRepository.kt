package org.irfanrev.pustaka.book.data.repository

import org.irfanrev.pustaka.book.data.mappers.toBook
import org.irfanrev.pustaka.book.domain.Book
import org.irfanrev.pustaka.book.domain.BookRepository
import org.irfanrev.pustaka.book.domain.RemoteBookDataSource
import org.irfanrev.pustaka.core.domain.DataError
import org.irfanrev.pustaka.core.domain.Result
import org.irfanrev.pustaka.core.domain.map

class DefaultBookRepository(
    private val remoteBookDataSource: RemoteBookDataSource
) : BookRepository {

    override suspend fun searchBooks(query: String) : Result<List<Book>, DataError.Remote> {
        return remoteBookDataSource
            .searchBooks(query)
            .map { dto ->
                dto.results.map { it.toBook() }
            }
    }

}
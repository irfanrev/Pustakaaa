package org.irfanrev.pustaka.book.domain

import org.irfanrev.pustaka.book.data.dto.SearchResponseDto
import org.irfanrev.pustaka.core.domain.DataError
import org.irfanrev.pustaka.core.domain.Result

interface RemoteBookDataSource {

    suspend fun searchBooks(
        query: String,
        resultLimit: Int? = null
    ): Result<SearchResponseDto, DataError.Remote>

}
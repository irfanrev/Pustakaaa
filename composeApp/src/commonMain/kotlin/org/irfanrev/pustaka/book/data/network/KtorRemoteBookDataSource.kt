package org.irfanrev.pustaka.book.data.network

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import org.irfanrev.pustaka.book.data.dto.SearchResponseDto
import org.irfanrev.pustaka.book.domain.Book
import org.irfanrev.pustaka.book.domain.RemoteBookDataSource
import org.irfanrev.pustaka.core.data.safeCall
import org.irfanrev.pustaka.core.domain.DataError
import org.irfanrev.pustaka.core.domain.Result

private const val BASE_URL = "https://openlibrary.org"

class KtorRemoteBookDataSource(
    private val httpClient: HttpClient
) : RemoteBookDataSource {

    override suspend fun searchBooks(
        query: String,
        resultLimit: Int?
    ): Result<SearchResponseDto, DataError.Remote> {
        return safeCall {
            httpClient.get(
                urlString = "$BASE_URL/search.json"
            ) {
                parameter("q", query)
                parameter("limit", resultLimit)
                parameter("language", "eng")
                parameter("fields", "key,title,languages,cover_id,author_key,author_name,cover_edition_key,first_publish_year,ratings_average,ratings_count,number_of_pages_median,edition_count")
            }
        }
    }
}
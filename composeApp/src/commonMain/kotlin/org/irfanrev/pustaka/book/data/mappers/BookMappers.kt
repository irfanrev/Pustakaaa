package org.irfanrev.pustaka.book.data.mappers

import org.irfanrev.pustaka.book.data.dto.SearchedBookDto
import org.irfanrev.pustaka.book.domain.Book

fun SearchedBookDto.toBook(): Book {
    return Book(
        id = id.substringAfterLast("/"),
        title = title,
        imageUrl =  if (coverKey != null)
        {
            "https://covers.openlibrary.org/b/id/${coverKey}-L.jpg"
        } else {
            "https://covers.openlibrary.org/b/id/${coverAlternativeKey}-L.jpg"
        },
        authors = authorNames ?: emptyList(),
        description = null,
        languages = languages ?: emptyList(),
        firstPublishYear = firstPublishYear.toString(),
        averageRating = ratingAverage,
        ratingsCount = ratingCount,
        numPages = numPagesMedian,
        numEditions = numEdition ?: 0

        )
}
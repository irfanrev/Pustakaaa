package org.irfanrev.pustaka

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import org.irfanrev.pustaka.book.domain.Book
import org.irfanrev.pustaka.book.presentation.book_list.BookListScreen
import org.irfanrev.pustaka.book.presentation.book_list.BookListState
import org.irfanrev.pustaka.book.presentation.book_list.components.BookSearchBar

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            App()
        }
    }
}

//@Preview
@Composable
fun AppAndroidPreview() {
    Box(modifier = Modifier
        .fillMaxWidth()
        .background(Color.White)
    ) {
        BookSearchBar(searchQuery = "", onSearchQueryChange = {}, onImeSearch = { /*TODO*/ })
    }

}

private val books = (1..100).map {
    Book(
        id = it.toString(),
    title = "Book $it",
    imageUrl = "https://picsum.photos/200/300?random=$it",
    authors = listOf("Author $it"), 
        description = "Description $it",
    launguages = listOf("ID"),
            firstPublishYear = "2020",
        averageRating =4.0,
        ratingsCount = 100,
    numPages = 100,
    numEditions = 10
    )
}

@Preview
@Composable
fun ListViewPreview() {

    BookListScreen(
        state = BookListState(
            searchResults = books
        ),
        onAction = {
        }
    )

}
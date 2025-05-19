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
import org.irfanrev.pustaka.book.presentation.book_list.components.BookSearchBar

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            App()
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    Box(modifier = Modifier
        .fillMaxWidth()
        .background(Color.White)
    ) {
        BookSearchBar(searchQuery = "", onSearchQueryChange = {}, onImeSearch = { /*TODO*/ })
    }

}
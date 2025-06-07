package org.irfanrev.pustaka

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import io.ktor.client.engine.HttpClientEngine
import org.irfanrev.pustaka.book.data.network.KtorRemoteBookDataSource
import org.irfanrev.pustaka.book.data.repository.DefaultBookRepository
import org.irfanrev.pustaka.book.presentation.book_list.BookListScreenRoot
import org.irfanrev.pustaka.book.presentation.book_list.BookListViewModel
import org.irfanrev.pustaka.core.data.HttpClientFactory
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import pustaka.composeapp.generated.resources.Res
import pustaka.composeapp.generated.resources.compose_multiplatform

@Composable
@Preview
fun App(engine: HttpClientEngine) {
    BookListScreenRoot(
        viewModel = remember { BookListViewModel(
            bookRepository = DefaultBookRepository(
                remoteBookDataSource = KtorRemoteBookDataSource(
                    httpClient = HttpClientFactory.create(engine)
                )
            )
        ) },
        onBookClick = {

        }
    )
}
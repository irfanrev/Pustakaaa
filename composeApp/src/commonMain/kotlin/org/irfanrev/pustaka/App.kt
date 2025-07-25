package org.irfanrev.pustaka

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.irfanrev.pustaka.app.Routes
import org.irfanrev.pustaka.book.presentation.SelectedBookViewModel
import org.irfanrev.pustaka.book.presentation.book_list.BookListScreenRoot
import org.irfanrev.pustaka.book.presentation.book_list.BookListViewModel
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel

@Composable
@Preview
fun App() {

    MaterialTheme {

        val navController = rememberNavController()

        NavHost(
            navController = navController,
            startDestination = Routes.BookGraph
        ) {
            composable<Routes.BookList>() {
                val viewModel = koinViewModel<BookListViewModel>()
                val selectedBookViewModel = it.sharedKoinViewModel<SelectedBookViewModel>(navController)

                LaunchedEffect(true) {
                    selectedBookViewModel.onSelectedBook(null)
                }

                BookListScreenRoot(
                    viewModel = viewModel,
                    onBookClick = { book ->
                        selectedBookViewModel.onSelectedBook(book)
                        navController.navigate(
                            Routes.BookDetail(book.id)
                        )
                    }
                )
            }
            composable<Routes.BookDetail> {

                val selectedBookViewModel = it.sharedKoinViewModel<SelectedBookViewModel>(navController)
                val selectedBook by selectedBookViewModel.selectedBook.collectAsStateWithLifecycle()
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text("Book Detail: ${selectedBook}")
                }
            }
        }

        val viewModel = koinViewModel<BookListViewModel>()
        BookListScreenRoot(
            viewModel = viewModel,
            onBookClick = {

            }
        )
    }

}

@Composable
private inline fun <reified T: ViewModel> NavBackStackEntry.sharedKoinViewModel(
    navController: NavController,

): T {

    val navgraphRoute = destination.parent?.route ?: return koinViewModel<T>()
    val parrentEntry = remember(this) {
        navController.getBackStackEntry(navgraphRoute)
    }
    return koinViewModel(
        viewModelStoreOwner = parrentEntry
    )
}
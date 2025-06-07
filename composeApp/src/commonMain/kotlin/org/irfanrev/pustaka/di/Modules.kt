package org.irfanrev.pustaka.di

import io.ktor.client.HttpClient
import org.irfanrev.pustaka.book.data.network.KtorRemoteBookDataSource
import org.irfanrev.pustaka.book.data.repository.DefaultBookRepository
import org.irfanrev.pustaka.book.domain.BookRepository
import org.irfanrev.pustaka.book.domain.RemoteBookDataSource
import org.irfanrev.pustaka.book.presentation.book_list.BookListViewModel
import org.irfanrev.pustaka.core.data.HttpClientFactory
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module

expect val platformModule: Module

val sharedModule = module {

    // need engine (android/ios/desktop)
    single {
        HttpClientFactory.create(get())
    }

    singleOf(::KtorRemoteBookDataSource).bind<RemoteBookDataSource>()

    singleOf(::DefaultBookRepository).bind<BookRepository>()

    viewModelOf(::BookListViewModel)
}
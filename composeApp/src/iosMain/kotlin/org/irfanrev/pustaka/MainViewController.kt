package org.irfanrev.pustaka

import androidx.compose.runtime.remember
import androidx.compose.ui.window.ComposeUIViewController
import io.ktor.client.engine.darwin.Darwin
import org.irfanrev.pustaka.di.initKoin

fun MainViewController() = ComposeUIViewController(
    configure = {
        initKoin()
    }
) { App() }
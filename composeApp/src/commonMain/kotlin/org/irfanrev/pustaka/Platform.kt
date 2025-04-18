package org.irfanrev.pustaka

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
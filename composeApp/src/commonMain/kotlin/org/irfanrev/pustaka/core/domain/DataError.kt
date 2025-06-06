package org.irfanrev.pustaka.core.domain


sealed interface DataError: Error {

    enum class Remote: DataError {
        REQUEST_TIMOUT,
        TOO_MANY_REQUEST,
        NO_INTERNET,
        SERVER,
        SERIALIZATION,
        UNKNOWN
    }

    enum class Local: DataError {
        DISK_FULL,
        UNKNOWN
    }


}
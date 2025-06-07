package org.irfanrev.pustaka.core.presentation

import org.irfanrev.pustaka.core.domain.DataError
import pustaka.composeapp.generated.resources.Res
import pustaka.composeapp.generated.resources.error_disk_full
import pustaka.composeapp.generated.resources.error_no_internet
import pustaka.composeapp.generated.resources.error_request_timeout
import pustaka.composeapp.generated.resources.error_serialization
import pustaka.composeapp.generated.resources.error_too_many_requests
import pustaka.composeapp.generated.resources.error_unknown

fun DataError.toUiText(): UiText {
    val stringRes = when(this) {
        DataError.Local.DISK_FULL -> Res.string.error_disk_full
        DataError.Local.UNKNOWN -> Res.string.error_unknown
        DataError.Remote.REQUEST_TIMOUT -> Res.string.error_request_timeout
        DataError.Remote.TOO_MANY_REQUEST -> Res.string.error_too_many_requests
        DataError.Remote.NO_INTERNET -> Res.string.error_no_internet
        DataError.Remote.SERVER -> Res.string.error_unknown
        DataError.Remote.SERIALIZATION -> Res.string.error_serialization
        DataError.Remote.UNKNOWN -> Res.string.error_unknown
    }

    return UiText.StringResourceId(stringRes)
}
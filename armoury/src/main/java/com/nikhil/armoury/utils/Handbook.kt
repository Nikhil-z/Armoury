package com.nikhil.armoury.utils

object Error {
    const val UNEXPECTED =
        "We're very sorry, but something unexpected has happened. \n The details of this problem have been logged !!"
    const val FAILED_REQUEST = "That was something unexpected !"
    const val UNHANDLED_API_STATUS = "An unexpected api status code has been received"
    const val UNEXPECTED_API_PAYLOAD = "Unexpected payload/response"
    const val VPN_CONNECTED = "Please make sure you are not connected to a VPN."
}

enum class Environment {
    PRODUCTION, STAGING, DEVELOPMENT, TESTING
}

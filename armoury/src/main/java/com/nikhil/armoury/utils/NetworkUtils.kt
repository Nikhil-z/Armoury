package com.nikhil.armoury.utils

import java.io.IOException

object NetworkUtils {

    fun isNetworkAvailable1(): Boolean {
        val runtime = Runtime.getRuntime()
        try {
            val ipProcess = runtime.exec("/system/bin/ping -c 1 8.8.8.8")
            val exitValue = ipProcess.waitFor()
            return exitValue == 0
        } catch (e: IOException) {
            e.printStackTrace()
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
        return false
    }

    internal fun checkNetworkError(message: String): String {

        return when {
            message.contains("No address associated with hostname") -> {
                " The internet connection appears to be offline !"
            }

            message.contains("Chain validation failed") -> {
                " Please check your device time is update"
            }

            message.contains("Failed to connect to") -> {
                " Gulp !! That wasn't something we expected.. Try again"
            }

            message.contains("timeout") -> {
                " You may be experiencing a poor internet connectivity or something unexpected has happened!!"
            }

            message.contains("Certificate pinning failure") -> {
                "You are either on a VPN network or an unauthorised access detected"
            }

            else -> message
        }


    }


}
package com.nikhil.armoury.utils

import com.nikhil.armoury.BaseUrls

internal object OtherUtils {

    fun BaseUrls.select(environment: Environment): String {
        when (environment) {
            Environment.PRODUCTION -> {
                return this.production
            }

            Environment.STAGING -> {
                return this.stage
            }

            Environment.TESTING -> {
                return this.test
            }

            Environment.DEVELOPMENT -> {
                return this.development
            }
        }
    }

    fun validateBaseUrl(baseUrls: BaseUrls) {
        if (baseUrls.production == "" && baseUrls.stage == "" && baseUrls.test == "" && baseUrls.development == "")
            throw ArmouryInitializerException("The base URL must not be left empty.")
    }
}
/*
 * *
 *  * Created by Nikhil-z on 22/06/23, 11:45 am
 *  * Copyright (c) 2023 . All rights reserved.
 *  * Last modified 22/06/23, 11:45 am
 *
 */

package com.nikhil.armoury.secure

import android.content.Context
import android.util.Base64
import android.util.Base64.encodeToString
import com.nikhil.armoury.utils.ArmouryAuthException
import timber.log.Timber


internal object Integrity {

    fun verify(context: Context): Boolean {
        val isAuthorized = when (context.packageName) {
            "com.nikhil.armourysample", "com.digital.signage", "com.silly.tv", "com.android.tv.sample" -> {
                Timber.d("Armoury access successful")
                Timber.d("Authorized for " + getAuthenticator(context.packageName))
                true
            }

            else -> {
                Timber.d("Integrity check has failed!! Authorization denied for Armoury access")

                false
            }
        }

        if (!isAuthorized) {
            throw ArmouryAuthException(req = getAuthenticator(context.packageName))
        }

        return isAuthorized
    }

    private fun getAuthenticator(input: String): String {
        val encoded = encodeToString(input.toByteArray(), Base64.NO_WRAP)
        return encoded ?: "Tm8gdmFsaWQgcGFja2FnZSBuYW1lIGZvdW5k"
    }
}

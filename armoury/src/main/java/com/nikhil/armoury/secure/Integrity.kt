/*
 * *
 *  * Created by Nikhil-z on 22/06/23, 11:45 am
 *  * Copyright (c) 2023 . All rights reserved.
 *  * Last modified 22/06/23, 11:45 am
 *
 */

package com.nikhil.armoury.secure

import android.accounts.AuthenticatorException
import android.content.Context
import com.nikhil.armoury.utils.ArmouryAuthException
import timber.log.Timber


internal object Integrity {

    fun verify(context: Context): Boolean {
        val isAuthorized = when (context.packageName) {
            "com.nikhil.armourysample","com.digital.signage","com.silly.tv" -> {
                Timber.d("Armoury access successful")
                true
            }

            else -> {
                Timber.d("Integrity check has failed!! Authorization denied for Armoury access")

                false
            }
        }

        if (!isAuthorized) {
            throw ArmouryAuthException()
        }

        return isAuthorized
    }
}

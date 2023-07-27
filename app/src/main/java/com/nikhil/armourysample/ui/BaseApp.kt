/*
 * *
 *  * Created by Nikhil-z on 22/06/23, 4:06 pm
 *  * Copyright (c) 2023 . All rights reserved.
 *  * Last modified 22/06/23, 4:06 pm
 *
 */

package com.nikhil.armourysample.ui

import android.app.Application
import com.nikhil.armoury.ArmouryBuilder
import com.nikhil.armoury.BaseUrls
import com.nikhil.armoury.utils.Environment
import com.nikhil.armourysample.ui.network.prepareUrls

class BaseApp : Application() {

    override fun onCreate() {
        super.onCreate()

        ArmouryBuilder()
            .enableDebugMode()
            .setEnvironment(Environment.PRODUCTION)
            .setBaseUrls(prepareUrls())
            .build()


    }


}
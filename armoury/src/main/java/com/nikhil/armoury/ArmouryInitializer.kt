/*
 * *
 *  * Created by Nikhil-z on 22/06/23, 11:39 am
 *  * Copyright (c) 2023 . All rights reserved.
 *  * Last modified 22/06/23, 11:39 am
 *
 */

package com.nikhil.armoury

import android.content.Context
import android.util.Log
import androidx.startup.Initializer
import com.nikhil.armoury.secure.Integrity
import timber.log.Timber
import timber.log.Timber.Forest.plant

class ArmouryInitializer : Initializer<ArmouryInitializer.Invoke> {

    override fun create(context: Context): Invoke {
        if (Timber.treeCount == 0) { // Issue fixed Timber logs multiple time
           /* if (BuildConfig.DEBUG) {
                plant(Timber.DebugTree())
            } else {
                plant(CrashReportingTree(context.packageName))
            }*/
        }

        Integrity.verify(context)

        return Invoke(context)
    }

    override fun dependencies(): List<Class<out Initializer<*>>> {
        return emptyList()
    }


    class Invoke(myContext: Context) {

        /*  init {
              database = AppDatabase.getInstance(myContext)
              sharedPreferences = AppPref.create(myContext)

          }

          companion object {
              lateinit var database: AppDatabase
              lateinit var sharedPreferences: SharedPreferences
          }*/
    }

    /** A tree which logs important information for crash reporting.  */
    private class CrashReportingTree(val packageName: String) : Timber.Tree() {
        override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
            if (priority == Log.VERBOSE || priority == Log.DEBUG) {
                return
            }
           /* InHouseHealthMonitor.log(priority, tag, message)
            if (t != null) {
                if (priority == Log.ERROR) {
                    InHouseHealthMonitor.logError(t, packageName)
                } else if (priority == Log.WARN) {
                    InHouseHealthMonitor.logWarning(t, packageName)
                }
            }*/
        }
    }
}

/*
 * *
 *  * Created by Nikhil-z on 22/06/23, 11:38 am
 *  * Copyright (c) 2023 . All rights reserved.
 *  * Last modified 22/06/23, 11:37 am
 *
 */

package com.nikhil.armoury

import com.nikhil.armoury.network.Network

object Armoury {


    fun getBaseUrl(): String {
        return ArmouryHouse.config().baseUrl()
    }

    /** pass base url for API*/
    fun <S> pickFight(serviceClass: Class<S>): S {
        return Network.retrofitClient(serviceClass)
    }

    /** pass base url and API service class*/
    fun <S> pickFight(baseUrl: String, serviceClass: Class<S>): S {
        return Network.retrofitClient(serviceClass)
    }
}
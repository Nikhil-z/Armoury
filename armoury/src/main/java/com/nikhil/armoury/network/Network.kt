/*
 * *
 *  * Created by Nikhil-z on 22/06/23, 5:24 pm
 *  * Copyright (c) 2023 . All rights reserved.
 *  * Last modified 22/06/23, 5:24 pm
 *
 */

package com.nikhil.armoury.network

import com.nikhil.armoury.ArmouryHouse

internal object Network {

    fun <S> retrofitClient(withUrl: String, serviceClass: Class<S>): S {
        return RetrofitFactory.retrofit(withUrl).create(serviceClass)
    }

    fun <S> retrofitClient(serviceClass: Class<S>): S {
        return RetrofitFactory.retrofit(ArmouryHouse.config().baseUrl()).create(serviceClass)
    }

}
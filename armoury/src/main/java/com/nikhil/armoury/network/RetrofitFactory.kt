/*
 * *
 *  * Created by Nikhil-z on 22/06/23, 12:08 pm
 *  * Copyright (c) 2023 . All rights reserved.
 *  * Last modified 22/06/23, 12:08 pm
 *
 */

package com.nikhil.armoury.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.nikhil.armoury.ArmouryHouse
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

internal object RetrofitFactory {

    fun retrofit(baseUrl: String): Retrofit = Retrofit.Builder()
        .client(OkHttpClient().newBuilder().addInterceptor(loggingInterceptor).build())
        .baseUrl(baseUrl)
        //.addConverterFactory(MoshiConverterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()

    private val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = if (ArmouryHouse.config().isDebugMode()) {
            HttpLoggingInterceptor.Level.BODY
        } else {
            HttpLoggingInterceptor.Level.NONE
        }
    }


}
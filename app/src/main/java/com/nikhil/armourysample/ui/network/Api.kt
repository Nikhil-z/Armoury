package com.nikhil.armourysample.ui.network

import com.nikhil.armourysample.ui.home.model.SignageModel
import com.nikhil.armourysample.ui.network.model.DeviceConfigModel
import retrofit2.Response
import retrofit2.http.GET

interface Api {
    @GET("config")
    suspend fun getDeviceConfiguration(): Response<DeviceConfigModel>

    @GET("assets")
    suspend fun getSign(): Response<SignageModel>
}
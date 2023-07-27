package com.nikhil.armourysample.ui.network.repo

import com.nikhil.armoury.utils.base.BaseRepository
import com.nikhil.armoury.utils.callback.Resource
import com.nikhil.armourysample.ui.network.ApiClient
import com.nikhil.armourysample.ui.network.model.DeviceConfigModel

class SampleRepo : BaseRepository() {


    suspend fun getDeviceConfig(): Resource<DeviceConfigModel> =
        armourGuard { ApiClient.get().getDeviceConfiguration() }

}
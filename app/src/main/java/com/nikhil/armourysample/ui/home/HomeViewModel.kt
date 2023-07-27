package com.nikhil.armourysample.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nikhil.armoury.utils.callback.Resource
import com.nikhil.armourysample.ui.network.model.DeviceConfigModel
import com.nikhil.armourysample.ui.network.repo.SampleRepo
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {


    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text


    private val _deviceConfiguration = MutableLiveData<Resource<DeviceConfigModel>>()
    val deviceConfiguration: LiveData<Resource<DeviceConfigModel>> = _deviceConfiguration

    init {
        getDeviceConfig()
    }

    private fun getDeviceConfig() = viewModelScope.launch {
        _deviceConfiguration.postValue(Resource.Loading())
        _deviceConfiguration.postValue(SampleRepo().getDeviceConfig())
    }
}
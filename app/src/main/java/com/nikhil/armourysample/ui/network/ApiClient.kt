package com.nikhil.armourysample.ui.network

import com.nikhil.armoury.Armoury

object ApiClient {
    fun get() = Armoury.pickFight(Api::class.java)
}
package com.nikhil.armourysample.ui.network.model

data class Maintenance(
    val active: Boolean,
    val backIn: String,
    val message: String,
    val support: Support
)
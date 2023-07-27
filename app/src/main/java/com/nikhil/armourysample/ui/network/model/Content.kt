package com.nikhil.armourysample.ui.network.model

data class Content(
    val app: App,
    val maintenance: Maintenance,
    val servers: List<Server>
)
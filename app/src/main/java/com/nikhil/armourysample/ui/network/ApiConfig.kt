package com.nikhil.armourysample.ui.network

import com.nikhil.armoury.BaseUrls


 fun prepareUrls(): BaseUrls {

    return BaseUrls(
        production = "https://demo1888968.mockable.io/",
        stage = "https://demo1888968.mockable.io/",
        test = "https://demo1888968.mockable.io/",
        development = "https://demo1888968.mockable.io/"
    )
}
package com.nikhil.armourysample.ui.network

import com.nikhil.armoury.BaseUrls


 fun prepareUrls(): BaseUrls {

    return BaseUrls(
        production = "https://demo2569847.mockable.io/digitalSignage/",
        stage = "https://demo1888968.mockable.io/",
        test = "https://demo1888968.mockable.io/",
        development = "https://demo1888968.mockable.io/"
    )
}
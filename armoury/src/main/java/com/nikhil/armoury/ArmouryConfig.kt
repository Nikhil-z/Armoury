/*
 * *
 *  * Created by Nikhil-z on 22/06/23, 3:06 pm
 *  * Copyright (c) 2023 . All rights reserved.
 *  * Last modified 22/06/23, 3:06 pm
 *
 */

package com.nikhil.armoury

import com.nikhil.armoury.utils.ArmouryInitializerException
import com.nikhil.armoury.utils.Environment
import com.nikhil.armoury.utils.OtherUtils.select
import com.nikhil.armoury.utils.OtherUtils.validateBaseUrl


open class ArmouryBuilder {

    private var debug: Boolean = false
    private var baseUrl: String = ""
    private var baseUrls = BaseUrls()
    private var environment: Environment = Environment.DEVELOPMENT


    /** Make sure to remove this before going production*/
    fun enableDebugMode(): ArmouryBuilder {
        this.debug = true
        return this
    }

    /** Pass single of multiple base urls*/
    fun setBaseUrls(baseUrls: BaseUrls): ArmouryBuilder {
        validateBaseUrl(baseUrls)
        this.baseUrls = baseUrls
        return this
    }

    private fun setBaseUrl(baseUrl: String): ArmouryBuilder {
        this.baseUrl = baseUrl
        return this
    }

    /** Default environment will be PRODUCTION*/
    fun setEnvironment(environment: Environment): ArmouryBuilder {
        this.environment = environment
        return this
    }

    fun build() {
        setBaseUrl(baseUrls.select(this.environment))
        ArmouryHouse.setConfig(this)
    }


    internal fun isDebugMode() = debug
    internal fun baseUrl() = baseUrl
    internal fun environment() = environment


}


internal object ArmouryHouse {

    private var builder: ArmouryBuilder = ArmouryBuilder()

    fun setConfig(armouryBuilder: ArmouryBuilder) {
        this.builder = armouryBuilder
    }

    internal fun config() = builder

}

data class BaseUrls(
    var production: String = "",
    var stage: String = "",
    var test: String = "",
    var development: String = ""
)
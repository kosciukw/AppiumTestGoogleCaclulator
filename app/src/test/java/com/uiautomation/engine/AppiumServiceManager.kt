package com.uiautomation.engine

import io.appium.java_client.service.local.AppiumDriverLocalService
import io.appium.java_client.service.local.AppiumServiceBuilder
import java.lang.IllegalStateException

object AppiumServiceManager {

    private var service: AppiumDriverLocalService? = null

    fun startService(portNumer: Int) {

        if(service != null && service!!.isRunning) {
            return
        }

        service = AppiumDriverLocalService.buildService(
            AppiumServiceBuilder().usingPort(portNumer)
        )

        service!!.start()
    }

    fun stopService() {
        service?.stop()
        service = null
    }

    fun getUrl() = service?.url ?: throw IllegalStateException("Service not running")
}
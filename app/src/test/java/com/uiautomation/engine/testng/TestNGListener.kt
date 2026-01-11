package com.uiautomation.engine.testng

import com.uiautomation.engine.appium.AppiumServiceManager
import com.uiautomation.engine.driver.DriverConfigProvider
import com.uiautomation.engine.driver.DriverManager
import org.testng.ITestContext
import org.testng.ITestListener

class TestNGListener : ITestListener {

    override fun onStart(context: ITestContext?) {
        super.onStart(context)

        if (context == null) throw IllegalStateException("Could not start framework")

        val driverConfig = DriverConfigProvider.getDriverConfig(context)

        AppiumServiceManager.startService(portNumer = driverConfig.appiumPort)

        DriverManager.initializeDriver(
            serviceUrl = AppiumServiceManager.getUrl(),
            driverConfig = driverConfig
        )
    }

    override fun onFinish(context: ITestContext?) {
        super.onFinish(context)

        DriverManager.quitDriver()
        AppiumServiceManager.stopService()
    }
}
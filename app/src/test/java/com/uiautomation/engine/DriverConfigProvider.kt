package com.uiautomation.engine

import org.testng.ITestContext

object DriverConfigProvider {

    fun getDriverConfig(context: ITestContext) = DriverConfig(
        platformName = context.currentXmlTest.getParameter(AppiumParameters.PLATFORM_NAME) ?: "Android",
        deviceName = context.currentXmlTest.getParameter(AppiumParameters.DEVICE_NAME) ?: "emulator-554454",
        appPackage = context.currentXmlTest.getParameter(AppiumParameters.APP_PACKAGE) ?: "com.google.android.calculator",
        appActivity = context.currentXmlTest.getParameter(AppiumParameters.APP_ACTIVITY) ?: "com.android.calculator2.Calculator",
        noReset = context.currentXmlTest.getParameter(AppiumParameters.NO_RESET)?.toBoolean() ?: false,
        appiumPort = context.currentXmlTest.getParameter(AppiumParameters.APPIUM_PORT)?.toInt() ?: 4725
    )
}
package com.uiautomation.page.base

import com.uiautomation.util.DriverUtil
import io.appium.java_client.AppiumDriver
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.android.options.UiAutomator2Options
import io.appium.java_client.service.local.AppiumDriverLocalService
import io.appium.java_client.service.local.AppiumServiceBuilder
import org.testng.annotations.AfterTest
import org.testng.annotations.BeforeTest

abstract class BaseTest {

    private lateinit var service: AppiumDriverLocalService
    private lateinit var driver: AppiumDriver
    private lateinit var driverUtil: DriverUtil

    protected fun <T : BasePage> createPage(factory: (DriverUtil) -> T): T {
        return factory(driverUtil)
    }

    @BeforeTest
    open fun setup() {
        service = AppiumDriverLocalService.buildService(
            AppiumServiceBuilder().usingPort(4725)
        )

        val options = UiAutomator2Options()
            .setPlatformName("Android")
            .setDeviceName("emulator-5554")
            .setAppPackage("com.google.android.calculator")
            .setAppActivity("com.android.calculator2.Calculator")
            .setNoReset(false)

        driver = AndroidDriver(options)

        driverUtil = DriverUtil(driver)
    }

    @AfterTest
    fun teardown() {
        driver.quit()
        service.stop()
    }
}
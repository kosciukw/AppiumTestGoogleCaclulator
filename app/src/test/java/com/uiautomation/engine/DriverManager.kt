package com.uiautomation.engine

import com.uiautomation.util.MobileInteractor
import io.appium.java_client.AppiumDriver
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.android.options.UiAutomator2Options
import org.testng.ITestContext
import java.net.URL

object DriverManager {

    private var mobileInteractor: MobileInteractor? = null
    private var driver: AppiumDriver? = null

    fun initializeDriver(
        serviceUrl: URL,
        driverConfig: DriverConfig
    ) {
        if (driver != null) return

        val options = with(driverConfig) {
            UiAutomator2Options()
                .setPlatformName(platformName)
                .setDeviceName(deviceName)
                .setAppPackage(appPackage)
                .setAppActivity(appActivity)
                .setNoReset(noReset)
        }

        driver = AndroidDriver(serviceUrl, options)
    }

    fun getDriver(): AppiumDriver {
        return driver ?: throw IllegalStateException("Driver has not been initialized.")
    }

    fun getMobileInteractor(): MobileInteractor {
        if (mobileInteractor == null) {
            mobileInteractor = MobileInteractor(driver = getDriver())
        }
        return mobileInteractor!!
    }

    fun quitDriver() {
        driver?.quit()
        driver = null
        mobileInteractor = null
    }
}
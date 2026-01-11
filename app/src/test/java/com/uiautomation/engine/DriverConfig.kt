package com.uiautomation.engine

data class DriverConfig(
    val platformName: String,
    val deviceName: String,
    val appPackage: String,
    val appActivity: String,
    val noReset: Boolean,
    val appiumPort: Int
)
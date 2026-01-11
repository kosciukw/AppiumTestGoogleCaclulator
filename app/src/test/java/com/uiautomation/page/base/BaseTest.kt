package com.uiautomation.page.base

import com.uiautomation.engine.DriverManager
import com.uiautomation.util.MobileInteractor

abstract class BaseTest {

    protected fun <T : BasePage> createPage(factory: (MobileInteractor) -> T): T {
        return factory(DriverManager.getMobileInteractor())
    }
}
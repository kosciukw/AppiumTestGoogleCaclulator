package com.uiautomation.steps

import com.uiautomation.engine.driver.DriverManager
import com.uiautomation.page.base.BasePage
import com.uiautomation.util.MobileInteractor

abstract class BaseStep {

    protected fun <T : BasePage> createPage(factory: (MobileInteractor) -> T): T {
        return factory(DriverManager.getMobileInteractor())
    }
}
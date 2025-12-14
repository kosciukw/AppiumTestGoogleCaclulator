/*

package com.uiautomation.page.base

import com.uiautomation.util.DriverUtil
import org.openqa.selenium.By

abstract class BasePage(
    private val driverUtil: DriverUtil
) {

    abstract val container: By

    fun isPageDisplayed(): Boolean {
        return runCatching {
            val element = driverUtil.getElement(container)
            element.isDisplayed
        }.getOrElse { exception ->
            if (exception is NoSuchElementException) false
            else throw exception
        }
    }
}
 */
package com.uiautomation.page.base

import com.uiautomation.util.MobileInteractor
import org.openqa.selenium.By

abstract class BasePage(
    private val mobileInteractor: MobileInteractor
) {

    abstract val container: By

    fun isPageDisplayed(): Boolean {
        return runCatching {
            val element = mobileInteractor.getElement(container)
            element.isDisplayed
        }.getOrElse { exception ->
            if (exception is NoSuchElementException) false
            else throw exception
        }
    }
}
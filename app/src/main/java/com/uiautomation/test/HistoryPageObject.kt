/*
package com.uiautomation.page

import com.uiautomation.page.base.BasePage
import com.uiautomation.util.DriverUtil
import io.appium.java_client.AppiumBy
import org.openqa.selenium.By

class HistoryPageObject(driverUtil: DriverUtil): BasePage(driverUtil) {

    override val container: By = AppiumBy.id(CONTAINER_ID)

    val historyList = AppiumBy.id(HISTORY_LIST_ID)
    val formula = AppiumBy.id(HISTORY_FORMULA_ID)

    companion object {
        private const val CONTAINER_ID = "com.google.android.calculator:id/history_layout"
        private const val HISTORY_LIST_ID = "com.google.android.calculator:id/history_recycler_view"
        private const val HISTORY_FORMULA_ID = "com.google.android.calculator:id/history_formula"
    }
}
 */
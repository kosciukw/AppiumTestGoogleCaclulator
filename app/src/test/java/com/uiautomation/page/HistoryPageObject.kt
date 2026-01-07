package com.uiautomation.page

import com.uiautomation.page.base.BasePage
import com.uiautomation.util.MobileInteractor
import io.appium.java_client.AppiumBy
import org.openqa.selenium.By
import org.openqa.selenium.WebElement

class HistoryPageObject(private val mobileInteractor: MobileInteractor) : BasePage(mobileInteractor) {

    override val container: By = AppiumBy.id(CONTAINER_ID)

    private val listView: By = AppiumBy.id(HISTORY_RECYCLER_VIEW_ID)
    private val formulaId: By = AppiumBy.id(FORMULA_ID)

    private val navigateUpClassName: By = AppiumBy.className(NAVIGATE_UP_IMAGE_BUTTON_CLASS_NAME)
    private val toolbarId: By = AppiumBy.id(TOOLBAR_ID)

    fun getCalculationHistory() = mobileInteractor.getElements(formulaId)

    fun navigateUp() {
        val toolbar = mobileInteractor.getElement(toolbarId)
        val navigateUpButton = toolbar.findElement(navigateUpClassName)

        navigateUpButton.click()
    }

    fun dragToFormula(predicate: (WebElement) -> Boolean): WebElement? {
        return mobileInteractor.dragToElement(
            elementsLocator = formulaId,
            predicate = predicate
        )
    }

    fun scrollToFormula(formulaText: String): WebElement? {
        return mobileInteractor.scrollToElement(
            scrollableResourceId = HISTORY_RECYCLER_VIEW_ID,
            targetResourceId = FORMULA_ID,
            textToFind = formulaText
        )
    }

    companion object {
        private const val CONTAINER_ID = "com.google.android.calculator:id/history_layout"
        private const val FORMULA_ID = "com.google.android.calculator:id/history_formula"
        private const val TOOLBAR_ID = "com.google.android.calculator:id/history_toolbar"
        private const val NAVIGATE_UP_IMAGE_BUTTON_CLASS_NAME = "android.widget.ImageButton"
        private const val HISTORY_RECYCLER_VIEW_ID =
            "com.google.android.calculator:id/history_recycler_view"
    }
}
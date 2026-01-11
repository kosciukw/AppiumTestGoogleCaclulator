package com.uiautomation.page

import com.uiautomation.page.base.BasePage
import com.uiautomation.util.MobileInteractor
import io.appium.java_client.AppiumBy
import org.openqa.selenium.By

class CalculatorPageObject(private val mobileInteractor: MobileInteractor) : BasePage(mobileInteractor) {

    override val container: By = AppiumBy.id(CONTAINER_ID)

    fun swipeDownExpression() {
        mobileInteractor.dragScreenVertical(
            startPercent = 0.25,
            endPercent = 0.9
        )
    }

    fun clickButtonZero() {
        mobileInteractor.getElement(buttonZeroId).click()
    }

    fun clickButtonOne() {
        mobileInteractor.getElement(buttonOneId).click()
    }

    fun clickButtonTwo() {
        mobileInteractor.getElement(buttonTwoId).click()
    }

    fun clickButtonSeven() {
        mobileInteractor.getElement(buttonSevenId).click()
    }

    fun clickButtonAdd() {
        mobileInteractor.getElement(buttonAddId).click()
    }

    fun clickButtonSubtract() {
        mobileInteractor.getElement(buttonSubtractId).click()
    }

    fun clickButtonEquals() {
        mobileInteractor.getElement(buttonEqualsId).click()
    }

    fun clickButtonClear() {
        mobileInteractor.getElement(buttonClearId).click()
    }

    fun getFormulaText() = mobileInteractor.getElement(formulaFieldId).text

    fun getResultFinalText() = mobileInteractor.getElement(resultFinalFieldId).text


    // Digits
    private val buttonZeroId = AppiumBy.id(BUTTON_ZERO_ID)
    private val buttonOneId = AppiumBy.id(BUTTON_ONE_ID)
    private val buttonTwoId = AppiumBy.id(BUTTON_TWO_ID)
    private val buttonSevenId = AppiumBy.id(BUTTON_SEVEN_ID)

    // Operations
    private val buttonAddId = AppiumBy.id(BUTTON_ADD_ID)
    private val buttonEqualsId = AppiumBy.id(BUTTON_EQUALS_ID)
    private val buttonSubtractId = AppiumBy.id(BUTTON_SUBTRACT_ID)

    // Fields
    private val formulaFieldId = AppiumBy.id(FORMULA_FIELD_ID)
    private val resultFinalFieldId = AppiumBy.id(RESULT_FINAL_FIELD_ID)

    private val buttonClearId = AppiumBy.id(BUTTON_CLEAR_ID)

    companion object {
        private const val BUTTON_ZERO_ID = "com.google.android.calculator:id/digit_0"
        private const val BUTTON_ONE_ID = "com.google.android.calculator:id/digit_1"
        private const val BUTTON_TWO_ID = "com.google.android.calculator:id/digit_2"
        private const val BUTTON_SEVEN_ID = "com.google.android.calculator:id/digit_7"
        private const val BUTTON_EQUALS_ID = "com.google.android.calculator:id/eq"
        private const val BUTTON_ADD_ID = "com.google.android.calculator:id/op_add"
        private const val BUTTON_SUBTRACT_ID = "com.google.android.calculator:id/op_sub"
        private const val BUTTON_CLEAR_ID = "com.google.android.calculator:id/clr"
        private const val FORMULA_FIELD_ID = "com.google.android.calculator:id/formula"
        private const val RESULT_FINAL_FIELD_ID = "com.google.android.calculator:id/result_final"
        private const val CONTAINER_ID = "com.google.android.calculator:id/main_calculator"
    }
}
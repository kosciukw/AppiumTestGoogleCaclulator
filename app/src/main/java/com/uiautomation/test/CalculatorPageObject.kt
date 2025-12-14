/*
package com.uiautomation.page

import com.uiautomation.page.base.BasePage
import com.uiautomation.util.DriverUtil
import io.appium.java_client.AppiumBy
import org.openqa.selenium.By

class CalculatorPageObject(private val driverUtil: DriverUtil) : BasePage(driverUtil) {

    override val container: By = AppiumBy.id(CONTAINER_ID)

    fun swipeDownFormula() {
        driverUtil.dragScreenVertical(
            startPercent = 0.25,
            endPercent = 0.9
        )
    }

    fun clickButtonZero() = driverUtil.getElement(buttonZeroId).click()
    fun clickButtonOne() = driverUtil.getElement(buttonOneId).click()
    fun clickButtonTwo() = driverUtil.getElement(buttonTwoId).click()
    fun clickButtonFour() = driverUtil.getElement(buttonFourId).click()
    fun clickButtonSeven() = driverUtil.getElement(buttonSevenId).click()

    // Generic digit click (convenience method)
    fun clickDigit(digit: Int) {
        when (digit) {
            0 -> clickButtonZero()
            1 -> clickButtonOne()
            2 -> clickButtonTwo()
            4 -> clickButtonFour()
            7 -> clickButtonSeven()
            else -> throw IllegalArgumentException("Digit $digit is not supported")
        }
    }

    fun clickDivision() = driverUtil.getElement(buttonDivisionId).click()
    fun clickMultiply() = driverUtil.getElement(buttonMultiplyId).click()
    fun clickAdd() = driverUtil.getElement(buttonAddId).click()
    fun clickEquals() = driverUtil.getElement(buttonEqualsId).click()
    fun clickSubtract() = driverUtil.getElement(buttonSubtractId).click()
    fun clickClear() = driverUtil.getElement(buttonClearId).click()

    // ==================== Field Getters ====================

    fun getFormulaText(): String = driverUtil.getElement(formulaFieldId).text
    fun getResultText(): String = driverUtil.getElement(resultFinalFieldId).text

    // ==================== Field Verifications ====================

    fun isFormulaDisplayed(): Boolean = runCatching {
        driverUtil.getElement(formulaFieldId).isDisplayed
    }.getOrDefault(false)

    fun isResultDisplayed(): Boolean = runCatching {
        driverUtil.getElement(resultFinalFieldId).isDisplayed
    }.getOrDefault(false)

    // ==================== High-Level Actions ====================

    fun performCalculation(num1: Int, operation: String, num2: Int): String {
        clickDigit(num1)
        when (operation) {
            "+" -> clickAdd()
            "-" -> clickSubtract()
            "*", "×" -> clickMultiply()
            "/", "÷" -> clickDivision()
            else -> throw IllegalArgumentException("Operation $operation is not supported")
        }
        clickDigit(num2)
        clickEquals()
        return getResultText()
    }

    fun clearAndPerformCalculation(num1: Int, operation: String, num2: Int): String {
        clickClear()
        return performCalculation(num1, operation, num2)
    }

    fun enterNumber(number: Int) {
        number.toString().forEach { digit ->
            clickDigit(digit.toString().toInt())
        }
    }

    // Digits
    private val buttonZeroId = AppiumBy.id(BUTTON_ZERO_ID)
    private val buttonOneId = AppiumBy.id(BUTTON_ONE_ID)
    private val buttonTwoId = AppiumBy.id(BUTTON_TWO_ID)
    private val buttonFourId = AppiumBy.id(BUTTON_FOUR_ID)
    private val buttonSevenId = AppiumBy.id(BUTTON_SEVEN_ID)

    // Operations
    private val buttonDivisionId = AppiumBy.id(BUTTON_DIVISION_ID)
    private val buttonMultiplyId = AppiumBy.id(BUTTON_MULTIPLY_ID)
    private val buttonAddId = AppiumBy.id(BUTTON_ADD_ID)
    private val buttonEqualsId = AppiumBy.id(BUTTON_EQUALS_ID)
    private val buttonSubtractId = AppiumBy.id(BUTTON_SUBTRACT_ID)
    private val buttonClearId = AppiumBy.id(BUTTON_CLEAR_ID)

    // Fields
    private val formulaFieldId = AppiumBy.id(FORMULA_FIELD_ID)
    private val resultFinalFieldId = AppiumBy.id(RESULT_FINAL_FIELD_ID)

    companion object {
        private const val CONTAINER_ID = "com.google.android.calculator:id/main_calculator"
        private const val BUTTON_ZERO_ID = "com.google.android.calculator:id/digit_0"
        private const val BUTTON_ONE_ID = "com.google.android.calculator:id/digit_1"
        private const val BUTTON_TWO_ID = "com.google.android.calculator:id/digit_2"
        private const val BUTTON_FOUR_ID = "com.google.android.calculator:id/digit_4"
        private const val BUTTON_SEVEN_ID = "com.google.android.calculator:id/digit_7"
        private const val BUTTON_EQUALS_ID = "com.google.android.calculator:id/eq"
        private const val BUTTON_ADD_ID = "com.google.android.calculator:id/op_add"
        private const val BUTTON_DIVISION_ID = "com.google.android.calculator:id/op_div"
        private const val BUTTON_MULTIPLY_ID = "com.google.android.calculator:id/op_mul"
        private const val BUTTON_SUBTRACT_ID = "com.google.android.calculator:id/op_sub"
        private const val BUTTON_CLEAR_ID = "com.google.android.calculator:id/clr"
        private const val FORMULA_FIELD_ID = "com.google.android.calculator:id/formula"
        private const val RESULT_FINAL_FIELD_ID = "com.google.android.calculator:id/result_final"
    }
}

//class CalculatorPageObject(private val driverUtil: DriverUtil) : BasePage(driverUtil) {
//
//    override val container: By = AppiumBy.id(CONTAINER_ID)
//
//    fun swipeDownFormula() {
//        driverUtil.dragScreenVertical(
//            startPercent = 0.25,
//            endPercent = 0.9
//        )
//    }
//
//    // Digits
//    val buttonZeroId = AppiumBy.id(BUTTON_ZERO_ID)
//    val buttonOneId = AppiumBy.id(BUTTON_ONE_ID)
//    val buttonTwoId = AppiumBy.id(BUTTON_TWO_ID)
//    val buttonFourId = AppiumBy.id(BUTTON_FOUR_ID)
//    val buttonSevenId = AppiumBy.id(BUTTON_SEVEN_ID)
//
//    // Operations
//    val buttonDivisionId = AppiumBy.id(BUTTON_DIVISION_ID)
//    val buttonMultiplyId = AppiumBy.id(BUTTON_MULTIPLY_ID)
//    val buttonAddId = AppiumBy.id(BUTTON_ADD_ID)
//    val buttonEqualsId = AppiumBy.id(BUTTON_EQUALS_ID)
//    val buttonSubtractId = AppiumBy.id(BUTTON_SUBTRACT_ID)
//    val buttonClearId = AppiumBy.id(BUTTON_CLEAR_ID)
//
//    // Fields
//    val formulaFieldId = AppiumBy.id(FORMULA_FIELD_ID)
//    val resultFinalFieldId = AppiumBy.id(RESULT_FINAL_FIELD_ID)
//
//    companion object {
//        private val CONTAINER_ID = "com.google.android.calculator:id/main_calculator"
//        private const val BUTTON_ZERO_ID = "com.google.android.calculator:id/digit_0"
//        private const val BUTTON_ONE_ID = "com.google.android.calculator:id/digit_1"
//        private const val BUTTON_TWO_ID = "com.google.android.calculator:id/digit_2"
//        private const val BUTTON_FOUR_ID = "com.google.android.calculator:id/digit_4"
//        private const val BUTTON_SEVEN_ID = "com.google.android.calculator:id/digit_7"
//        private const val BUTTON_EQUALS_ID = "com.google.android.calculator:id/eq"
//        private const val BUTTON_ADD_ID = "com.google.android.calculator:id/op_add"
//        private const val BUTTON_DIVISION_ID = "com.google.android.calculator:id/op_div"
//        private const val BUTTON_MULTIPLY_ID = "com.google.android.calculator:id/op_mul"
//        private const val BUTTON_SUBTRACT_ID = "com.google.android.calculator:id/op_sub"
//        private const val BUTTON_CLEAR_ID = "com.google.android.calculator:id/clr"
//        private const val FORMULA_FIELD_ID = "com.google.android.calculator:id/formula"
//        private const val RESULT_FINAL_FIELD_ID = "com.google.android.calculator:id/result_final"
//    }
//}
 */
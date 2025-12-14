package com.uiautomation.test

import com.uiautomation.page.CalculatorPageObject
import com.uiautomation.page.HistoryPageObject
import com.uiautomation.page.base.BaseTest
import org.junit.Assert
import org.testng.annotations.AfterMethod
import org.testng.annotations.BeforeClass
import org.testng.annotations.BeforeMethod
import org.testng.annotations.Test

class CalculationHistoryTest : BaseTest() {

    private val calculatorPageObject: CalculatorPageObject by lazy {
        createPage(::CalculatorPageObject)
    }

    private val historyPageObject: HistoryPageObject by lazy {
        createPage(::HistoryPageObject)
    }

    @BeforeClass
    fun `Prepare calculation history with entries`() {

        // Clicking 10+12
        calculatorPageObject.clickButtonOne()
        calculatorPageObject.clickButtonZero()
        calculatorPageObject.clickButtonAdd()
        calculatorPageObject.clickButtonOne()
        calculatorPageObject.clickButtonTwo()
        calculatorPageObject.clickButtonEquals()

        repeat(5) { i ->
            calculatorPageObject.clickButtonOne()

            if (i % 2 == 0) calculatorPageObject.clickButtonAdd()
            else calculatorPageObject.clickButtonSubtract()

            calculatorPageObject.clickButtonTwo()

            calculatorPageObject.clickButtonAdd()
            calculatorPageObject.clickButtonEquals()
        }
    }

    @BeforeMethod
    fun `Clear input`() {
        calculatorPageObject.clickButtonClear()
    }


    @AfterMethod
    fun tearDown() {
        if (historyPageObject.isPageDisplayed()) {
            historyPageObject.navigateUp()
        }
    }

    @Test
    fun `When clicking 10+12 formula Then it should use that expression as current`() {

        // Given
        calculatorPageObject.swipeDownExpression()
        Assert.assertTrue(historyPageObject.isPageDisplayed())


        // When
        val targetFormula = historyPageObject.dragToFormula { formula ->
            formula.text.contains("10") && formula.text.contains("+") && formula.text.contains("12")
        }

        Assert.assertNotNull("Target formula should not be null", targetFormula)

        targetFormula!!.click()

        // Then
        val currentExpression = calculatorPageObject.getFormulaText()
        Assert.assertTrue(
            currentExpression.contains("10") && currentExpression.contains("+") && currentExpression.contains(
                "12"
            )
        )
    }

    @Test
    fun `When clicking 10+12 formula Then it should use that expression as current, using AndroidUiAutomator`() {

        // Given
        calculatorPageObject.swipeDownExpression()
        Assert.assertTrue(historyPageObject.isPageDisplayed())

        // When
        val targetFormula = historyPageObject.scrollToFormula("10+12")

        Assert.assertNotNull("Target formula should not be null", targetFormula)

        targetFormula!!.click()

        // Then
        val currentExpression = calculatorPageObject.getFormulaText()
        Assert.assertTrue(
            currentExpression.contains("10") && currentExpression.contains("+") && currentExpression.contains(
                "12"
            )
        )
    }
}
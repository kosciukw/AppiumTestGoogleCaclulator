package com.uiautomation.test

import com.uiautomation.page.CalculatorPageObject
import com.uiautomation.page.HistoryPageObject
import com.uiautomation.page.base.BaseTest
import org.testng.Assert
import org.testng.annotations.AfterMethod
import org.testng.annotations.BeforeMethod
import org.testng.annotations.Test

class CalculatorTest : BaseTest() {

    private val calculatorPageObject: CalculatorPageObject by lazy {
        createPage(::CalculatorPageObject)
    }

    private val historyPageObject: HistoryPageObject by lazy {
        createPage(::HistoryPageObject)
    }

    @BeforeMethod
    fun `Clear input`() {
        calculatorPageObject.clickButtonClear()
    }

    @Test
    fun `When adding 10 and 12 Then the outcome should be 22`() {

        // Given
        val expectedResult = "22"

        // When

        // 10
        calculatorPageObject.clickButtonOne()
        calculatorPageObject.clickButtonZero()

        // Add
        calculatorPageObject.clickButtonAdd()

        // Input 12

        calculatorPageObject.clickButtonOne()
        calculatorPageObject.clickButtonTwo()

        // Equals
        calculatorPageObject.clickButtonEquals()

        // Then
        val result = calculatorPageObject.getResultFinalText()

        Assert.assertEquals(result, expectedResult)
    }

    @Test
    fun `When subtracting 10 and 7 Then the outcome should be 3`() {

        // Given
        val expectedResult = "3"

        // When

        // 10
        calculatorPageObject.clickButtonOne()
        calculatorPageObject.clickButtonZero()

        // Subtract
        calculatorPageObject.clickButtonSubtract()

        // 7
        calculatorPageObject.clickButtonSeven()

        // Equals
        calculatorPageObject.clickButtonEquals()

        // Then
        val result = calculatorPageObject.getResultFinalText()

        Assert.assertEquals(result, expectedResult)
    }

    @Test
    fun `When swiping down Then it should show history`() {

        // Given
        Assert.assertTrue(calculatorPageObject.isPageDisplayed())

        // When
        calculatorPageObject.swipeDownExpression()


        // Then
        val isHistoryPageDisplayed = historyPageObject.isPageDisplayed()
        Assert.assertEquals(isHistoryPageDisplayed, true)

    }
}
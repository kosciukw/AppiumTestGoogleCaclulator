/*
package com.uiautomation.test

import com.uiautomation.page.CalculatorPageObject
import com.uiautomation.page.HistoryPageObject
import com.uiautomation.test.base.BaseTest
import org.testng.Assert
import org.testng.annotations.BeforeMethod
import org.testng.annotations.Test

class CalculatorTest : BaseTest() {

    private val calculatorPageObject: CalculatorPageObject by lazy {
        createPage(::CalculatorPageObject)
    }

//    private val historyPageObject: HistoryPageObject by lazy {
//        createPage(::HistoryPageObject)
//    }

    @BeforeMethod
    fun `Clear input`() {
        calculatorPageObject.clickClear()
    }


    @Test
    fun `When dividing 4 by 2 Then the outcome should be 2`() {

        // Given
        val expectedResult = "2"

        // When

        // Input 4
        calculatorPageObject.clickButtonFour()

        // Divide
        calculatorPageObject.clickDivision()

        // Input 2

        calculatorPageObject.clickButtonTwo()

        // Equals
        calculatorPageObject.clickEquals()

        // Then
        val result = calculatorPageObject.getResultText()

        Assert.assertEquals(result, expectedResult)
    }

//
//    @Test
//    fun `When multiplying 4 and 2 Then the outcome should be 8`() {
//
//        // Given
//        val expectedResult = "8"
//
//        // When
//
//        // Input 4
//        driverUtil.getElement(calculatorPageObject.buttonFourId).click()
//
//        // Add
//        driverUtil.getElement(calculatorPageObject.buttonMultiplyId).click()
//
//        // Input 2
//
//        driverUtil.getElement(calculatorPageObject.buttonTwoId).click()
//
//        // Equals
//        driverUtil.getElement(calculatorPageObject.buttonEqualsId).click()
//
//        // Then
//        val result = driverUtil.getElement(calculatorPageObject.resultFinalFieldId).text
//
//        Assert.assertEquals(result, expectedResult)
//    }
//
//
//    @Test
//    fun `When adding 10 and 12 Then the outcome should be 22`() {
//
//        // Given
//        val expectedResult = "22"
//
//        // When
//
//        // Input 10
//        driverUtil.getElement(calculatorPageObject.buttonOneId).click() // 1
//        driverUtil.getElement(calculatorPageObject.buttonZeroId).click() // 0
//
//        // Add
//        driverUtil.getElement(calculatorPageObject.buttonAddId).click() // +
//
//        // Input 12
//
//        driverUtil.getElement(calculatorPageObject.buttonOneId).click() // 1
//        driverUtil.getElement(calculatorPageObject.buttonTwoId).click() // 2
//
//        // Equals
//        driverUtil.getElement(calculatorPageObject.buttonEqualsId).click()
//
//        // Then
//        val result = driverUtil.getElement(calculatorPageObject.resultFinalFieldId).text
//
//        Assert.assertEquals(result, expectedResult)
//    }
//
//    @Test
//    fun `When subtracting 10 and 7 Then the outcome should be 3`() {
//
//        // Given
//        val expectedResult = "3"
//
//        // When
//
//        // 10
//        driverUtil.getElement(calculatorPageObject.buttonOneId).click()
//        driverUtil.getElement(calculatorPageObject.buttonZeroId).click()
//
//        // Subtract
//        driverUtil.getElement(calculatorPageObject.buttonSubtractId).click()
//
//        // 7
//        driverUtil.getElement(calculatorPageObject.buttonSevenId).click()
//
//        // Equals
//        driverUtil.getElement(calculatorPageObject.buttonEqualsId).click()
//
//        //Then
//        val result = driverUtil.getElement(calculatorPageObject.resultFinalFieldId).text
//        Assert.assertEquals(result, expectedResult)
//    }
//
//    @Test
//    fun `When swiping down Then it should show history`() {
//
//        // Given
//        Assert.assertEquals(calculatorPageObject.isPageDisplayed(), true)
//
//
//        // When
//        calculatorPageObject.swipeDownFormula()
//
//        // Then
//
//        val isHistoryPageDisplayed = historyPageObject.isPageDisplayed()
//
//        Assert.assertEquals(isHistoryPageDisplayed, true)
//    }
//
//    @Test
//    fun `When clicking 4 x 2 formula Then it should navigate to the calculator with that expression`() {
//
//        // Given
//        calculatorPageObject.swipeDownFormula()
//        Assert.assertEquals(historyPageObject.isPageDisplayed(), true)
//
//        // WARNING, development only!
//        val historyFormulas = driverUtil.getElements(historyPageObject.formula)
//
//        println("TEST_TAG Found items: ${historyFormulas.size}")
//
//        val targetFormula = historyFormulas.first { formula ->
//            formula.text.contains("4") && formula.text.contains("×") && formula.text.contains("2")
//        }
//
//        // When
//        targetFormula.click()
//
//        // Then
//        val currentExpression = driverUtil.getElement(calculatorPageObject.formulaFieldId).text
//        Assert.assertTrue(
//            currentExpression.contains("4") && currentExpression.contains("×") && currentExpression.contains(
//                "2"
//            )
//        )
//    }
}

//class CalculatorTest : BaseTest() {
//
//    private val calculatorPageObject: CalculatorPageObject by lazy {
//        CalculatorPageObject(driverUtil)
//    }
//
//    private val historyPageObject: HistoryPageObject by lazy {
//        HistoryPageObject(driverUtil)
//    }
//
//    @BeforeMethod
//    fun `Clear input`() {
//        driverUtil.getElement(calculatorPageObject.buttonClearId).click()
//    }
//
//
//    @Test
//    fun `When dividing 4 by 2 Then the outcome should be 2`() {
//
//        // Given
//        val expectedResult = "2"
//
//        // When
//
//        // Input 4
//        driverUtil.getElement(calculatorPageObject.buttonFourId).click()
//
//        // Add
//        driverUtil.getElement(calculatorPageObject.buttonDivisionId).click()
//
//        // Input 2
//
//        driverUtil.getElement(calculatorPageObject.buttonTwoId).click()
//
//        // Equals
//        driverUtil.getElement(calculatorPageObject.buttonEqualsId).click()
//
//        // Then
//        val result = driverUtil.getElement(calculatorPageObject.resultFinalFieldId).text
//
//        Assert.assertEquals(result, expectedResult)
//    }
//
//
//    @Test
//    fun `When multiplying 4 and 2 Then the outcome should be 8`() {
//
//        // Given
//        val expectedResult = "8"
//
//        // When
//
//        // Input 4
//        driverUtil.getElement(calculatorPageObject.buttonFourId).click()
//
//        // Add
//        driverUtil.getElement(calculatorPageObject.buttonMultiplyId).click()
//
//        // Input 2
//
//        driverUtil.getElement(calculatorPageObject.buttonTwoId).click()
//
//        // Equals
//        driverUtil.getElement(calculatorPageObject.buttonEqualsId).click()
//
//        // Then
//        val result = driverUtil.getElement(calculatorPageObject.resultFinalFieldId).text
//
//        Assert.assertEquals(result, expectedResult)
//    }
//
//
//    @Test
//    fun `When adding 10 and 12 Then the outcome should be 22`() {
//
//        // Given
//        val expectedResult = "22"
//
//        // When
//
//        // Input 10
//        driverUtil.getElement(calculatorPageObject.buttonOneId).click() // 1
//        driverUtil.getElement(calculatorPageObject.buttonZeroId).click() // 0
//
//        // Add
//        driverUtil.getElement(calculatorPageObject.buttonAddId).click() // +
//
//        // Input 12
//
//        driverUtil.getElement(calculatorPageObject.buttonOneId).click() // 1
//        driverUtil.getElement(calculatorPageObject.buttonTwoId).click() // 2
//
//        // Equals
//        driverUtil.getElement(calculatorPageObject.buttonEqualsId).click()
//
//        // Then
//        val result = driverUtil.getElement(calculatorPageObject.resultFinalFieldId).text
//
//        Assert.assertEquals(result, expectedResult)
//    }
//
//    @Test
//    fun `When subtracting 10 and 7 Then the outcome should be 3`() {
//
//        // Given
//        val expectedResult = "3"
//
//        // When
//
//        // 10
//        driverUtil.getElement(calculatorPageObject.buttonOneId).click()
//        driverUtil.getElement(calculatorPageObject.buttonZeroId).click()
//
//        // Subtract
//        driverUtil.getElement(calculatorPageObject.buttonSubtractId).click()
//
//        // 7
//        driverUtil.getElement(calculatorPageObject.buttonSevenId).click()
//
//        // Equals
//        driverUtil.getElement(calculatorPageObject.buttonEqualsId).click()
//
//        //Then
//        val result = driverUtil.getElement(calculatorPageObject.resultFinalFieldId).text
//        Assert.assertEquals(result, expectedResult)
//    }
//
//    @Test
//    fun `When swiping down Then it should show history`() {
//
//        // Given
//        Assert.assertEquals(calculatorPageObject.isPageDisplayed(), true)
//
//
//        // When
//        calculatorPageObject.swipeDownFormula()
//
//        // Then
//
//        val isHistoryPageDisplayed = historyPageObject.isPageDisplayed()
//
//        Assert.assertEquals(isHistoryPageDisplayed, true)
//    }
//
//    @Test
//    fun `When clicking 4 x 2 formula Then it should navigate to the calculator with that expression`() {
//
//        // Given
//        calculatorPageObject.swipeDownFormula()
//        Assert.assertEquals(historyPageObject.isPageDisplayed(), true)
//
//        // WARNING, development only!
//        val historyFormulas = driverUtil.getElements(historyPageObject.formula)
//
//        println("TEST_TAG Found items: ${historyFormulas.size}")
//
//        val targetFormula = historyFormulas.first { formula ->
//            formula.text.contains("4") && formula.text.contains("×") && formula.text.contains("2")
//        }
//
//        // When
//        targetFormula.click()
//
//        // Then
//        val currentExpression = driverUtil.getElement(calculatorPageObject.formulaFieldId).text
//        Assert.assertTrue(
//            currentExpression.contains("4") && currentExpression.contains("×") && currentExpression.contains(
//                "2"
//            )
//        )
//    }
//}
 */
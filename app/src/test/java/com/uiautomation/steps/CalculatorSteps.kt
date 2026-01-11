package com.uiautomation.steps

import com.uiautomation.page.CalculatorPageObject
import io.cucumber.java.en.When
import io.cucumber.java.en.Then
import junit.framework.TestCase.assertTrue

@Suppress("unused")
class CalculatorSteps : BaseStep() {

    private val calculatorPageObject: CalculatorPageObject by lazy {
        createPage(::CalculatorPageObject)
    }

    @When("Clear input")
    fun cleaInput() {
        calculatorPageObject.clickButtonClear()
    }

    @When("Click button zero")
    fun clickZero() {
        calculatorPageObject.clickButtonZero()
    }

    @When("Click button one")
    fun clickOne() {
        calculatorPageObject.clickButtonOne()
    }

    @When("Click button two")
    fun clickTwo() {
        calculatorPageObject.clickButtonTwo()
    }

    @When("Click button seven")
    fun clickSeven() {
        calculatorPageObject.clickButtonSeven()
    }

    @When("Click button add")
    fun clickAdd() {
        calculatorPageObject.clickButtonAdd()
    }

    @When("Click button subtract")
    fun clickSubtract() {
        calculatorPageObject.clickButtonSubtract()
    }

    @When("Click button equals")
    fun clickEquals() {
        calculatorPageObject.clickButtonEquals()
    }

    @When("Click button clear")
    fun clickClear() {
        calculatorPageObject.clickButtonClear()
    }

    @Then("The formula should be {string}")
    fun checkFormula(expected: String) {
        assertTrue(calculatorPageObject.getFormulaText() == expected)
    }

    @Then("The result should be {string}")
    fun checkResult(expected: String) {
        assertTrue(calculatorPageObject.getResultFinalText() == expected)
    }

    @Then("Calculator Page displayed")
    fun checkHistoryPageDisplayed() {
        assertTrue(calculatorPageObject.isPageDisplayed())
    }
}
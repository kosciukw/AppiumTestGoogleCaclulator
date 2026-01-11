package com.uiautomation.steps

import com.uiautomation.page.CalculatorPageObject
import com.uiautomation.page.HistoryPageObject
import io.cucumber.java.After
import io.cucumber.java.en.Given
import io.cucumber.java.en.When
import io.cucumber.java.en.Then
import junit.framework.TestCase.assertTrue

@Suppress("unused")
class HistorySteps : BaseStep() {

    private val calculatorPageObject: CalculatorPageObject by lazy {
        createPage(::CalculatorPageObject)
    }

    private val historyPageObject: HistoryPageObject by lazy {
        createPage(::HistoryPageObject)
    }

    @Given("Calculator has previous entries")
    fun prepareCalculationHistory() {
        calculatorPageObject.clickButtonClear()

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
            calculatorPageObject.clickButtonClear()
        }
    }

    @Then("Close History Page")
    fun closeHistoryPage() {
        if (historyPageObject.isPageDisplayed()) {
            historyPageObject.navigateUp()
        }
    }

    @When("Swipe down expression")
    fun swipeDown() = calculatorPageObject.swipeDownExpression()

    @Then("History Page displayed")
    fun checkHistoryPageDisplayed() {
        assertTrue(historyPageObject.isPageDisplayed())
    }

    @When("Click formula containing {string}")
    fun clickFormulaContaining(target: String) {
        val formula = historyPageObject.dragToFormula { it.text.contains(target) }
        assertTrue("Target formula should not be null", formula != null)
        formula!!.click()
    }

    @When("Scroll to formula {string}")
    fun scrollToFormula(target: String) {
        val formula = historyPageObject.scrollToFormula(target)
        assertTrue("Target formula should not be null", formula != null)
        formula!!.click()
    }

    @Then("Current expression should contain {string}")
    fun checkCurrentExpression(target: String) {
        val currentExpression = calculatorPageObject.getFormulaText()
        assertTrue(
            "Current expression should contain $target",
            currentExpression.contains(target)
        )
    }
}

package com.uiautomation.util

import io.appium.java_client.AppiumBy
import io.appium.java_client.AppiumDriver
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.interactions.PointerInput
import org.openqa.selenium.interactions.Sequence
import java.time.Duration

class MobileInteractor(private val driver: AppiumDriver) {

    fun dragToElement(
        elementsLocator: By,
        predicate: (WebElement) -> Boolean,
        startPercent: Double = 0.3,
        endPercent: Double = 0.7,
        maxAttempts: Int = 10
    ): WebElement? {
        var targetElement: WebElement? = null
        var attempts = 0

        while (targetElement == null && attempts < maxAttempts) {
            val currentElements = getElements(elementsLocator)

            targetElement = currentElements.firstOrNull(predicate)

            if (targetElement == null) {
                dragScreenVertical(
                    startPercent = startPercent,
                    endPercent = endPercent
                )
                attempts++
            }
        }

        return targetElement
    }

    fun scrollToElement(
        scrollableResourceId: String,
        targetResourceId: String,
        textToFind: String,
        maxAttempts: Int = 10
    ): WebElement? {
        val elementsLocator = AppiumBy.id(targetResourceId)

        repeat(maxAttempts) {
            getElements(elementsLocator)
                .firstOrNull { it.text == textToFind }
                ?.let { return it }

            runCatching {
                getElement(
                    AppiumBy.androidUIAutomator(
                        "new UiScrollable(new UiSelector().resourceId(\"$scrollableResourceId\"))" +
                                ".setAsVerticalList()" +
                                ".scrollIntoView(new UiSelector().resourceId(\"$targetResourceId\").text(\"$textToFind\"))"
                    )
                )
            }
        }

        return null
    }

    fun dragScreenVertical(
        startPercent: Double,
        endPercent: Double,
        durationMs: Long = 500
    ) {
        val finger = PointerInput(PointerInput.Kind.TOUCH, "finger")
        val size = driver.manage().window().size

        val startX = size.width / 2
        val startY = (size.height * startPercent).toInt()
        val endY = (size.height * endPercent).toInt()

        val swipe = Sequence(finger, 1)

        swipe.addAction(
            finger.createPointerMove(
                Duration.ZERO,
                PointerInput.Origin.viewport(),
                startX,
                startY
            )
        )

        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))

        swipe.addAction(
            finger.createPointerMove(
                Duration.ofMillis(durationMs),
                PointerInput.Origin.viewport(),
                startX,
                endY
            )
        )

        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()))

        driver.perform(listOf(swipe))
    }


    fun getElement(id: By): WebElement = runCatching {
        driver.findElement(id)
    }.getOrElse { exception ->
        println("TEST_TAG An element was not found: $id, exception: $exception")
        throw exception
    }

    fun getElements(id: By): List<WebElement> = runCatching {
        driver.findElements(id)
    }.getOrElse { exception ->
        println("TEST_TAG An elements was not found: $id, exception: $exception")
        throw exception
    }
}
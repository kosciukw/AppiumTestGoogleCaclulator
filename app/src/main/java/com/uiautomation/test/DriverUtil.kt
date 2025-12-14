/*
package com.uiautomation.util

import io.appium.java_client.AppiumDriver
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.interactions.PointerInput
import org.openqa.selenium.interactions.Sequence
import java.time.Duration

class DriverUtil(private val driver: AppiumDriver) {

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
        println("TEST_TAG An element was not found: $id, exception: $exception")
        throw exception
    }
}
 */
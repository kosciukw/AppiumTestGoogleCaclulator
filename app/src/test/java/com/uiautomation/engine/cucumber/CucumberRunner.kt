package com.uiautomation.engine.cucumber

import com.uiautomation.engine.testng.TestNGListener
import io.cucumber.testng.AbstractTestNGCucumberTests
import io.cucumber.testng.CucumberOptions
import org.testng.annotations.Listeners

@Listeners(TestNGListener::class)
@CucumberOptions(
    features = ["src/test/java/com/uiautomation/test/features"],
    glue = ["com.uiautomation.steps"]
)
class CucumberRunner : AbstractTestNGCucumberTests()

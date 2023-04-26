package cucumber;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features="src/test/java/cucumber", glue="shettyacademy.stepDefinitions",
monochrome=true)
public class TestNGTestRunner extends AbstractTestNGCucumberTests {


}

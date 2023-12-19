package testRunner;

import org.testng.annotations.Listeners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import stepDefinition.ListenersReporting;

@Listeners(ListenersReporting.class)
@CucumberOptions(plugin = { "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" }, features = {
		"Features" }, glue = { "stepDefinition" } )
class TestRunner extends AbstractTestNGCucumberTests {

}

// plugin = {"testng","html:target/cucumber-report.html"}
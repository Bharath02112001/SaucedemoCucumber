package com.testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "@target/failed_scenarios.txt", glue = { "com.stepDefinitions",
		"com.hooksClass" }, plugin = { "pretty", "html:target/rerun-report.html" })
public class FailedTestRunner extends AbstractTestNGCucumberTests {

}
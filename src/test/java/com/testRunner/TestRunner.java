package com.testRunner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "classpath:com.feature", glue = { "com.stepDefinitions",
		"com.hooksClass" }, plugin = { "pretty", "summary", "html:target/CucumberReport.html",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
				"rerun:target/failed_scenarios.txt" }, publish = true)
public class TestRunner extends AbstractTestNGCucumberTests {

//	@BeforeClass
//	@Parameters("browser")
//	public void setBrowser(String browser) {
//
//		System.out.println("Thread: " + Thread.currentThread().getId() + " | Browser: " + browser);
//
//		BrowserContext.setBrowser(browser);
//	}

//	@Override
//	@DataProvider(parallel = true)
//	public Object[][] scenarios() {
//		return super.scenarios();
//	}
}
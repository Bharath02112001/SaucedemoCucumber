package com.hooksClass;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.driverFactory.DriverFactory;
import com.utilities.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class MyHooks {

	private DriverFactory driverFactory;

	@Before(order = 0)
	public void loadConfig() {

		new ConfigReader().initializeProperties();

	}

	@Before(order = 1)
	public void launchBrowser() {

		String browser = ConfigReader.getProperty("browser");
		// String browser = BrowserContext.getBrowser();
		System.out.println("Thread: " + Thread.currentThread().getId() + " | Browser: " + browser);
		driverFactory = new DriverFactory();
		driverFactory.initializeBrowser(ConfigReader.getProperty("browser"));
		DriverFactory.getDriver().get(ConfigReader.getProperty("qaurl"));

	}

	@After
	public void tearDown(Scenario scenario) {

		WebDriver driver = DriverFactory.getDriver();

		if (scenario.isFailed() && driver != null) {

			byte[] screenshotAs = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

			scenario.attach(screenshotAs, "image/png", "Failed Screenhot");

		}

		if (driver != null) {
			driver.quit();
			DriverFactory.unload();
		}

	}

}

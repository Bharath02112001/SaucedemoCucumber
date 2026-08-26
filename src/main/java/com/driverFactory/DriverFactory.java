package com.driverFactory;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.utilities.ConstantUtiles;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	private static final ThreadLocal<WebDriver> tldriver = new ThreadLocal<WebDriver>();

	/**
	 * Initialize browser based on the browser name
	 * 
	 * @param browser
	 * @return
	 */
	public WebDriver initializeBrowser(String browser) {

		if (browser == null || browser.isBlank()) {
			throw new IllegalArgumentException("Browser name cannot be null or empty");
		}

		if ("Chrome".equalsIgnoreCase(browser)) {

			WebDriverManager.chromedriver().setup();
			ChromeOptions options = chromeOptionsSetup();
			tldriver.set(new ChromeDriver(options));

		} else if ("Firefox".equalsIgnoreCase(browser)) {

			WebDriverManager.firefoxdriver().setup();
			tldriver.set(new FirefoxDriver());

		} else if ("Edge".equalsIgnoreCase(browser)) {

			WebDriverManager.edgedriver().setup();
			tldriver.set(new EdgeDriver());

		} else {

			System.out.println("Incorrect Browser... Check your Browser Name");
			throw new IllegalArgumentException("Unexpected browser: " + browser);

		}

		configBrowser();
		return getDriver();
	}

	/**
	 * Get current thread's webdriver
	 * 
	 * @return It will return the thread webdriver
	 */
	public static WebDriver getDriver() {
		return tldriver.get();

	}

	/**
	 * Browser Configuration
	 */
	public void configBrowser() {

		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(ConstantUtiles.IMPLICIT_WAIT_TIME));
		getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(ConstantUtiles.PAGE_LOAD_TIME));

	}

	/**
	 * Chrome Options Configuration
	 */
	public ChromeOptions chromeOptionsSetup() {

		ChromeOptions options = new ChromeOptions();

		Map<String, Object> prefs = new HashMap<>();

		// ==========================================
		// PASSWORD SETTINGS
		// ==========================================

		// Disable Save Password popup
		prefs.put("credentials_enable_service", false);
		prefs.put("profile.password_manager_enabled", false);

		// Disable Password Leak Detection popup
		prefs.put("profile.password_manager_leak_detection", false);

		// ==========================================
		// NOTIFICATION SETTINGS
		// ==========================================

		// Disable browser notifications
		prefs.put("profile.default_content_setting_values.notifications", 2);

		// ==========================================
		// PERMISSION SETTINGS
		// ==========================================

		// Disable Location permission popup
		prefs.put("profile.default_content_setting_values.geolocation", 2);

		// Disable Camera permission popup
		prefs.put("profile.default_content_setting_values.media_stream_camera", 2);

		// Disable Microphone permission popup
		prefs.put("profile.default_content_setting_values.media_stream_mic", 2);

		// ==========================================
		// DOWNLOAD SETTINGS
		// ==========================================

		// Disable download confirmation popup
		prefs.put("download.prompt_for_download", false);

		// Allow multiple downloads
		prefs.put("profile.default_content_settings.popups", 0);

		// Set preferences
		options.setExperimentalOption("prefs", prefs);

		// ==========================================
		// CHROME UI SETTINGS
		// ==========================================

		// Disable "Chrome is being controlled by automated test software"
		options.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });

		// ==========================================
		// CHROME ARGUMENTS
		// ==========================================

		// Disable notifications
		options.addArguments("--disable-notifications");

		// Disable popup blocking
		options.addArguments("--disable-popup-blocking");

		// Disable infobars
		options.addArguments("--disable-infobars");

		// Disable extensions
		options.addArguments("--disable-extensions");

		// Start maximized
		options.addArguments("--start-maximized");

		return options;
	}

	/**
	 * Remove webdriver from thread local
	 */
	public static void unload() {
		tldriver.remove();
	}
}

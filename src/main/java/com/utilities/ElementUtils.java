package com.utilities;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtils {

	private final WebDriver driver;
	private final WebDriverWait wait;

	public ElementUtils(WebDriver driver) {

		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(ConstantUtiles.EXPLICIT_WAIT_TIME));
	}

	/**
	 * All Wait Methods
	 * 
	 * @param element
	 * @param durationInSeconds
	 * @return It returns wait
	 */
	public WebElement waitForElementToBeClickable(WebElement element) {

		return wait.until(ExpectedConditions.elementToBeClickable(element));

	}

	public WebElement waitForVisibilityOfElement(WebElement element) {

		return wait.until(ExpectedConditions.visibilityOf(element));
	}

	public List<WebElement> waitForVisibilityOfAllElements(List<WebElement> element) {

		return wait.until(ExpectedConditions.visibilityOfAllElements(element));
	}

	public Alert waitForAlertIsPresent() {

		return wait.until(ExpectedConditions.alertIsPresent());
	}

	/**
	 * All Selenium Methods
	 * 
	 * @param element
	 * @param durationInSeconds
	 */
	public void clickOnElement(WebElement element) {

		WebElement webElement = waitForElementToBeClickable(element);

		webElement.click();
	}

	public void typeTextIntoElement(WebElement element, String textToBeTyped) {

		WebElement webElement = waitForVisibilityOfElement(element);

		webElement.click();
		webElement.clear();
		webElement.sendKeys(textToBeTyped);
	}

	public void acceptTheAlert() {

		Alert alert = waitForAlertIsPresent();
		alert.accept();

	}

	public void dismissTheAlert() {

		Alert alert = waitForAlertIsPresent();
		alert.dismiss();

	}

	public boolean elementIsDisplayed(WebElement element) {

		WebElement webElement = waitForVisibilityOfElement(element);
		return webElement.isDisplayed();

	}

	public int getSizeOfTheListOfWebelements(List<WebElement> elements) {

		List<WebElement> webElements = waitForVisibilityOfAllElements(elements);
		return webElements.size();

	}

	public String getTextOfTheElement(WebElement element) {

		WebElement webElement = waitForVisibilityOfElement(element);
		return webElement.getText();

	}
}

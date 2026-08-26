package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.driverFactory.DriverFactory;
import com.utilities.ElementUtils;

public class CheckOutPage {

	private WebDriver driver;
	private ElementUtils elementUtils;

	public CheckOutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(DriverFactory.getDriver());
	}

	@FindBy(xpath = "//*[@class=\"title\"]")
	private WebElement CheckoutPageTitle;

	@FindBy(id = "first-name")
	private WebElement FirstName;

	@FindBy(id = "last-name")
	private WebElement LastName;

	@FindBy(id = "postal-code")
	private WebElement PostalCode;

	@FindBy(id = "continue")
	private WebElement ContinueButton;

	@FindBy(id = "finish")
	private WebElement FinishButton;

	@FindBy(xpath = "//h2[@class=\"complete-header\"]")
	private WebElement OrderSuccessMessage;

	public boolean CheckoutPageTitleIsDisplayed() {

		return elementUtils.elementIsDisplayed(CheckoutPageTitle);
		// return CheckoutPageTitle.isDisplayed();
	}

	public void fillCheckoutInfo(String firstName, String lastName, String postal) {

		elementUtils.typeTextIntoElement(FirstName, firstName);
		elementUtils.typeTextIntoElement(LastName, lastName);
		elementUtils.typeTextIntoElement(PostalCode, postal);
		elementUtils.clickOnElement(ContinueButton);

//		FirstName.sendKeys(firstName);
//		LastName.sendKeys(lastName);
//		PostalCode.sendKeys(postal);
//		ContinueButton.click();
	}

	public void clickOnFinishButton() {

		elementUtils.clickOnElement(FinishButton);
		// FinishButton.click();
	}
	
	
	public boolean orderSuccessMessageIsDisplayed() {

		return elementUtils.elementIsDisplayed(OrderSuccessMessage);
		// return OrderSuccessMessage.isDisplayed();
	}
}

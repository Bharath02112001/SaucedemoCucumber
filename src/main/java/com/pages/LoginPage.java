package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.driverFactory.DriverFactory;
import com.utilities.ElementUtils;

public class LoginPage {

	private final WebDriver driver;
	private ElementUtils elementUtils;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
	}

	@FindBy(id = "user-name")
	private WebElement userNameField;

	@FindBy(id = "password")
	private WebElement passwordField;

	@FindBy(id = "login-button")
	private WebElement loginButton;

	// Actions
	public void enterUserName(String userName) {

		elementUtils.typeTextIntoElement(userNameField, userName);
		// userNameField.sendKeys(userName);
	}

	public void enterPassword(String password) {

		elementUtils.typeTextIntoElement(passwordField, password);
		// passwordField.sendKeys(password);
	}

	public HomePage clickOnLoginButton() {

		elementUtils.clickOnElement(loginButton);
		return new HomePage(driver);
	}

	public HomePage doLogin(String userName, String password) {

		elementUtils.typeTextIntoElement(userNameField, userName);
		elementUtils.typeTextIntoElement(passwordField, password);
		elementUtils.clickOnElement(loginButton);

//		 userNameField.sendKeys(userName); 
//		 passwordField.sendKeys(password);
//		 loginButton.click();
		return new HomePage(driver);

	}
}

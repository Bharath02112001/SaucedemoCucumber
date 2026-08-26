package com.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.driverFactory.DriverFactory;
import com.utilities.ElementUtils;

public class CartPage {

	private WebDriver driver;
	private ElementUtils elementUtils;

	public CartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(DriverFactory.getDriver());
	}

	@FindBy(xpath = "//*[text()=\"Your Cart\"]")
	private WebElement CartPageTitle;

	@FindBy(xpath = "//div[@class=\"cart_item\"]")
	private List<WebElement> CartCount;

	@FindBy(id = "checkout")
	private WebElement Checkout;

	public boolean cartPageTitleIsDisplay() {

		return elementUtils.elementIsDisplayed(CartPageTitle);
		// return CartPageTitle.isDisplayed();
	}

	public CheckOutPage clickOnCheckoutButton() {

		elementUtils.clickOnElement(Checkout);
		// Checkout.click();
		return new CheckOutPage(driver);
	}

	public int productCountInTheCart() {

		return elementUtils.getSizeOfTheListOfWebelements(CartCount);
		// return CartCount.size();

	}
}

package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.driverFactory.DriverFactory;
import com.utilities.ElementUtils;

public class HomePage {

	private final WebDriver driver;
	private ElementUtils elementUtils;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(DriverFactory.getDriver());
	}

	@FindBy(xpath = "//*[text()=\"Products\"]")
	private WebElement homePageTitle;

	@FindBy(xpath = "//select[@class=\"product_sort_container\"]")
	private WebElement filterButton;

	@FindBy(xpath = "//a[@class=\"shopping_cart_link\"]")
	private WebElement CartIcon;

	@FindBy(xpath = "(//button[text()=\"Add to cart\"])[1]")
	private WebElement AddToCartButton;

	public boolean homePageTitleIsDisplay() {
		
		return elementUtils.elementIsDisplayed(homePageTitle);
		// return homePageTitle.isDisplayed();
	}

	public String getFilterName() {
		
		return elementUtils.getTextOfTheElement(filterButton);
		//return filterButton.getText();
	}

	public FilterPage clickOnFilterButton() {
		
		elementUtils.clickOnElement(filterButton);
		//filterButton.click();
		return new FilterPage(driver);
	}

	public CartPage clickOnCartIcon() {
		
		elementUtils.clickOnElement(CartIcon);
		//CartIcon.click();
		return new CartPage(driver);
	}

	public void clickOnAddToCartButton() {
		
		elementUtils.clickOnElement(AddToCartButton);
		//AddToCartButton.click();

	}

}

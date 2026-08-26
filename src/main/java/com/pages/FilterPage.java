package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.driverFactory.DriverFactory;
import com.utilities.ElementUtils;

public class FilterPage {
	
	private final WebDriver driver;
	private ElementUtils elementUtils;
	
	public FilterPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(DriverFactory.getDriver());
	}
	
	@FindBy(xpath = "//select[@class=\"product_sort_container\"]")
	private WebElement filterButton;
	
	public String getFilterName() {
		
		return elementUtils.getTextOfTheElement(filterButton);
		// return filterButton.getText();
	}

	public void selectByVisibleText(String visibleText) {
		Select select = new Select(filterButton);
		select.selectByVisibleText(visibleText);
	}
}

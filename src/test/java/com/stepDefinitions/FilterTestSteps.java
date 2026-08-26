package com.stepDefinitions;

import org.testng.Assert;

import com.driverFactory.DriverFactory;
import com.pages.FilterPage;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.utilities.ConstantUtiles;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FilterTestSteps {

	private HomePage homePage;
	private FilterPage filterPage;

	@Given("user login with valid credentials")
	public void user_login_with_valid_credentials() {

		LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
		homePage = loginPage.doLogin(ConstantUtiles.USERNAME, ConstantUtiles.PASSWORD);

	}

	@And("user click the filter button")
	public void user_click_the_filter_button() {

		filterPage = homePage.clickOnFilterButton();

	}

	@When("user select the Name \\(Z to A) filter")
	public void user_select_the_name_z_to_a_filter() {

		filterPage.selectByVisibleText("Name (Z to A)");

	}

	@Then("all product will change into descending order")
	public void all_product_will_change_into_descending_order() {

		Assert.assertTrue(homePage.getFilterName().contains("Name (Z to A)"));
		System.out.println("Order Changed");

	}

	@When("user select the Price \\(Low to High) filter")
	public void user_select_the_price_low_to_high_filter() {

		filterPage.selectByVisibleText("Price (low to high)");

	}

	@Then("all product's price will change into low to high")
	public void all_product_s_price_will_change_into_low_to_high() {

		Assert.assertTrue(homePage.getFilterName().contains("Price (low to high)"));
		System.out.println("Order Changed");

	}

	@When("user select the Price \\(High to Low) filter")
	public void user_select_the_price_high_to_low_filter() {

		filterPage.selectByVisibleText("Price (high to low)");

	}

	@Then("all product's price will change into high to low")
	public void all_product_s_price_will_change_into_high_to_low() {

		Assert.assertTrue(homePage.getFilterName().contains("Price (high to low)"));
		System.out.println("Order Changed");

	}

	@When("user select the Name \\(A to Z) filter")
	public void user_select_the_name_a_to_z_filter() {

		filterPage.selectByVisibleText("Name (A to Z)");

	}

	@Then("all product will change into Ascending order")
	public void all_product_will_change_into_ascending_order() {

		Assert.assertTrue(homePage.getFilterName().contains("Name (A to Z)"));
		System.out.println("Order Changed");

	}
}

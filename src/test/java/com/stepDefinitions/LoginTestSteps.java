package com.stepDefinitions;

import org.testng.Assert;

import com.driverFactory.DriverFactory;
import com.pages.HomePage;
import com.pages.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginTestSteps {

	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	private HomePage homePage;

	@Given("user navigates to login page")
	public void user_navigates_to_login_page() {

		Assert.assertTrue(DriverFactory.getDriver().getCurrentUrl().contains("saucedemo"));
		System.out.println(DriverFactory.getDriver().getCurrentUrl());
		System.out.println("Application Launched Successfully");

	}

	@Given("user enters valid email address {string} into email field")
	public void user_enters_valid_email_address_into_email_field(String username) {

		loginPage.enterUserName(username);

	}

	@Given("user enters valid password {string} into password field")
	public void user_enters_valid_password_into_password_field(String password) {

		loginPage.enterPassword(password);

	}

	@When("user click the login button")
	public void user_click_the_login_button() {

		homePage = loginPage.clickOnLoginButton();

	}

	@Then("user should get the result")
	public void user_should_get_the_result() {

		Assert.assertTrue(homePage.homePageTitleIsDisplay());

	}
}

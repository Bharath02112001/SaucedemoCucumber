package com.stepDefinitions;

import org.testng.Assert;

import com.driverFactory.DriverFactory;
import com.pages.CartPage;
import com.pages.CheckOutPage;
import com.pages.HomePage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CartTestSteps {

	private CartPage cartPage;
	private CheckOutPage checkoutButton;

	@Given("user adds Backpack")
	public void user_adds_backpack() {

		HomePage homePage = new HomePage(DriverFactory.getDriver());
		homePage.clickOnAddToCartButton();
		cartPage = homePage.clickOnCartIcon();
		Assert.assertTrue(cartPage.cartPageTitleIsDisplay());

	}

	@Then("cart count should be {int}")
	public void cart_count_should_be(Integer int1) {

		int productCountInTheCart = cartPage.productCountInTheCart();
		Assert.assertTrue(productCountInTheCart == 1);
		System.out.println(productCountInTheCart);

	}

	@When("user proceeds to checkout")
	public void user_proceeds_to_checkout() {

		checkoutButton = cartPage.clickOnCheckoutButton();
		Assert.assertTrue(checkoutButton.CheckoutPageTitleIsDisplayed());
		checkoutButton.fillCheckoutInfo("Bharath", "Kumar", "624001");

	}

	@Then("order should be placed successfully")
	public void order_should_be_placed_successfully() {

		checkoutButton.clickOnFinishButton();
		Assert.assertTrue(checkoutButton.orderSuccessMessageIsDisplayed());

	}
}

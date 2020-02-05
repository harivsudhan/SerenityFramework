package com.taf.steps;

import org.junit.Assert;

import com.taf.pages.HomePage;
import com.taf.pages.ProductPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CheckoutCartStep {
	HomePage shopHomePage;
	ProductPage productPage;

	@Given("^I navigate to the login page$")
	public void i_navigate_to_the_login_page() throws Throwable  {
		shopHomePage.waitUntilPageIsLoaded();
	}

	@When("^I submit username and password$")
	public void i_submit_username_and_password() {
		shopHomePage.loginPage();
	}

	@Then("^I should be logged in to \"([^\"]*)\"$")
	public void i_should_be_logged_in(String accountLink) {
		String Title = shopHomePage.waitUntilMyDetailsAppear();
		Assert.assertTrue("MyAccount is not logged in correctly", Title.trim().contains(accountLink));
	}

	@Given("^User search for \"([^\"]*)\" product$")
	public void user_search_for_product(String searchRequest) {
		productPage.searchForProduct(searchRequest);

	}

	@When("^User selects the \"([^\"]*)\" Shirt \"([^\"]*)\" color and \"([^\"]*)\" size to the cart$")
	public void user_selects_the_Shirt_color_and_size_to_the_cart(String productName, String color, String size) {
		productPage.clickProduct(productName);
		productPage.selectColordropdown(color);
		productPage.selectSizedropdown(size);
		productPage.addToCart();
	}

	@Then("^User cart should display with added item \"([^\"]*)\"$")
	public void user_cart_should_display_with_added_item(String productName) {
		productPage.addToCart();
		String Title = shopHomePage.waitUntilMyDetailsAppear();
		Assert.assertTrue("Wrong Product is added to the cart", Title.trim().contains(productName));
	}

}

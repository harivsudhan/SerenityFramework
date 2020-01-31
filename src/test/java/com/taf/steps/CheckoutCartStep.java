package com.taf.steps;

import com.taf.actions.HomePageActions;
import com.taf.actions.ProductPageActions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class CheckoutCartStep {
	@Steps
	HomePageActions homePageActions;
	@Steps
	ProductPageActions productPageActions;

	@Given("^I navigate to the login page$")
	public void i_navigate_to_the_login_page() throws Throwable  {
		homePageActions.openShopCartPage();
	}

	@When("^I submit username and password$")
	public void i_submit_username_and_password() {
		homePageActions.loginShopCartPage("harivsudhan", "Welcometoshop", "shirt");
	}

	@Then("^I should be logged in to \"([^\"]*)\"$")
	public void i_should_be_logged_in(String accountLink) {
		homePageActions.verifyLoginPAge(accountLink);
	}

	@Given("^User search for \"([^\"]*)\" product$")
	public void user_search_for_product(String searchRequest) {
		productPageActions.searchtheProduct(searchRequest);

	}

	@When("^User selects the \"([^\"]*)\" Shirt \"([^\"]*)\" color and \"([^\"]*)\" size to the cart$")
	public void user_selects_the_Shirt_color_and_size_to_the_cart(String productName, String color, String size) {
		productPageActions.selecttheProductWithColorAndSize(productName, color, size);
		productPageActions.addProducttotheCart();
	}

	@Then("^User cart should display with added item \"([^\"]*)\"$")
	public void user_cart_should_display_with_added_item(String productName) {
		productPageActions.verifySelectedProduct(productName);
	}

}

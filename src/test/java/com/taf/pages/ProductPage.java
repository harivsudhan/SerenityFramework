package com.taf.pages;

import com.taf.core.BasePageObject;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class ProductPage extends BasePageObject {

	@FindBy(xpath = "//a[@class = 'noo-search']")
	WebElementFacade searchButton;

	@FindBy(name = "s")
	WebElementFacade searchField;

	@FindBy(xpath = "//a[contains(text() , 'blue denim super oversized')]")
	WebElementFacade denimProductLink;

	@FindBy(id = "pa_color")
	WebElementFacade productColorDropdown;

	@FindBy(id = "pa_size")
	WebElementFacade productSizeDropdown;

	@FindBy(xpath = "//button[contains(@class, 'single_add_to_cart_button')]")
	WebElementFacade addToCart;

	public void searchForProduct(String searchRequest) {
		searchButton.waitUntilVisible().click();
		clearSendKeysEnter(searchField, searchRequest);
	}

	public void clickProduct(String productName) {
		denimProductLink.waitUntilEnabled();
		moveToElement(denimProductLink);
		denimProductLink.click();
		waitForTextToAppear(productName);
	}

	public void selectColordropdown(String productColor) {
		productColorDropdown.waitUntilEnabled();
		element(productColorDropdown).selectByValue(productColor);
	}

	public void selectSizedropdown(String productSize) {
		productSizeDropdown.waitUntilEnabled();
		element(productSizeDropdown).selectByValue(productSize);
	}

	public void addToCart() {
		addToCart.waitUntilEnabled().click();
	}

}

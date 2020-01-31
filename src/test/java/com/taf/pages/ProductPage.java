package com.taf.pages;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class ProductPage extends PageObject {

	@FindBy(xpath = "//a[@class = 'noo-search']")
	WebElementFacade searchButton;
	
	@FindBy(name = "s")
	WebElementFacade searchField;
	
	@FindBy(xpath = "//a[contains(text() , 'blue denim super oversized')]")
	WebElementFacade productLink;
	
	@FindBy(id = "pa_color")
	WebElementFacade productColorDropdown;
	
	@FindBy(id = "pa_size")
	WebElementFacade productSizeDropdown;
	
	@FindBy(xpath = "//button[contains(@class, 'single_add_to_cart_button')]")
	WebElementFacade addToCart;
	
	private Actions actions;
	
	
	public void searchForProduct(String searchRequest) {
		searchButton.waitUntilVisible().click();
		searchField.waitUntilEnabled().sendKeys(searchRequest);
		searchField.submit();
	}
	
	public void clickProduct(String productName) {
		productLink.waitUntilEnabled();
		actions = new Actions(getDriver());
		actions.moveToElement(productLink);
		actions.perform();
		productLink.click();	
		waitForTextToAppear(productName);
	}
	
	public void selectColordropdown(String productColor) {
		productColorDropdown.waitUntilEnabled();
		Select color = new Select(productColorDropdown);
		color.selectByValue(productColor);
	}
	
	public void selectSizedropdown(String productSize) {
		productSizeDropdown.waitUntilEnabled();
		element(productSizeDropdown).selectByValue(productSize);
	}
	
	public void addToCart() {
		addToCart.waitUntilEnabled().click();
	}


}

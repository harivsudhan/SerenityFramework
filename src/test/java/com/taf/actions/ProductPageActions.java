package com.taf.actions;

import org.junit.Assert;

import com.taf.pages.HomePage;
import com.taf.pages.ProductPage;

import net.thucydides.core.annotations.Step;

public class ProductPageActions {
	ProductPage productPage;
	HomePage homePage;

	@Step
	public void searchtheProduct(String searchRequest) {
		productPage.searchForProduct(searchRequest);
	}

	@Step
	public void selecttheProductWithColorAndSize(String productName, String Color, String Size) {
		productPage.clickProduct(productName);
		productPage.selectColordropdown(Color);
		productPage.selectSizedropdown(Size);
	}

	@Step
	public void addProducttotheCart() {
		productPage.addToCart();
	}

	@Step
	public void verifySelectedProduct(String productName) {
		productPage.addToCart();
		String Title = homePage.waitUntilMyDetailsAppear();
		Assert.assertTrue("Wrong Product is added to the cart", Title.trim().contains(productName));
	}
}

package com.taf.actions;

import com.taf.pages.HomePage;
import org.junit.Assert;

import net.thucydides.core.annotations.Step;

public class HomePageActions {
	HomePage homePage;
	
	@Step
	public void openShopCartPage() {
		homePage.open();
		homePage.waitUntilPageIsLoaded();
	}

	@Step
	public void loginShopCartPage(String userName, String password, String searchRequest) {
		homePage.loginPage(userName, password);
	}
	
	@Step
	public void verifyLoginPAge(String accountLink) {
		String Title = homePage.waitUntilMyDetailsAppear();
		Assert.assertTrue("MyAccount is not logged in correctly", Title.trim().contains(accountLink));
	}
}

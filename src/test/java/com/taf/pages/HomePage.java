package com.taf.pages;

import org.openqa.selenium.By;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http://shop.demoqa.com")
public class HomePage extends PageObject {

	private By shopHomePage = By.id("noo-site");
	
	@FindBy(linkText = "My Account")
	WebElementFacade myAccountLink;

	@FindBy(id = "username")
	WebElementFacade shopUsername;

	@FindBy(id = "password")
	WebElementFacade shopPassword;

	@FindBy(name = "login")
	WebElementFacade loginButton;

	@FindBy(xpath = "//a[@class = 'noo-search']")
	WebElementFacade searchButton;
	
	@FindBy(name = "s")
	WebElementFacade searchField;
	
	public void waitUntilPageIsLoaded() {
		getDriver().manage().window().maximize();
		this.open();
		waitForRenderedElementsToBePresent(shopHomePage);
		System.out.println($(shopHomePage).getText());
		getJavascriptExecutorFacade().executeScript("window.scrollBy(0,200)");
	}

	public void loginPage(String userName, String password) {
		myAccountLink.waitUntilClickable().click();
		shopUsername.waitUntilVisible().sendKeys(userName);
		shopPassword.waitUntilEnabled().sendKeys(password);
		loginButton.waitUntilEnabled().click();
	}
	
	public String waitUntilMyDetailsAppear() {
		return getDriver().getTitle();
	}

}

package com.taf.pages;

import org.openqa.selenium.WebDriver;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.WhenPageOpens;

@DefaultUrl("http://shop.demoqa.com")
public class HomePage extends PageObject {

	@Managed
    public WebDriver webdriver;
	
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
	
	@WhenPageOpens
	public void waitUntilPageIsLoaded() {
		getDriver().manage().window().maximize();
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

package com.taf.pages;

import org.openqa.selenium.By;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.WhenPageOpens;

@DefaultUrl("https://brandstory.in/")
public class BrandStoryHomePage extends PageObject {

	@FindBy(linkText = "CONTACT US")
	WebElementFacade contactUsLink;

	@FindBy(xpath = "//a[contains(text(), 'DEVELOPMENT')]")
	WebElementFacade developmentLink;

	@FindBy(linkText = "WEBSITE")
	WebElementFacade websiteLink;

	private String projectLink = "//*[text() = 'ProjectLink']";

	@FindBy(xpath = "//*[@class = 'footer']//a[contains(@href , 'mailto')]")
	WebElementFacade mailTo;

	@WhenPageOpens
	public void waitUntilBrandStoryLoads() {
		getDriver().manage().window().maximize();
		contactUsLink.waitUntilEnabled();
	}

	public String getMailID() {
		mailTo.waitUntilPresent();
		getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView(true);", mailTo);
		return mailTo.getText();
	}

	public void navigateToWebsite() {
		developmentLink.waitUntilEnabled().click();
		websiteLink.waitUntilVisible().click();
	}

	public void selectProject(String projectName) {
		projectLink = projectLink.replace("ProjectLink", projectName);
		System.out.println("The project link is " + projectLink);
		WebElementFacade projectLinkElement = element(By.xpath(projectLink));
		projectLinkElement.waitUntilVisible().click();

	}
	
	public String waitUntilMyDetailsAppear() {
		return getDriver().getTitle();
	}
}

package com.taf.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://brandstory.in/")
public class BrandStoryHomePage extends PageObject {

	@FindBy(tagName = "body")
	WebElementFacade brandHomePage;

	@FindBy(xpath = "//*[@href = 'contact-us']")
	WebElementFacade contactUsLink;

	@FindBy(xpath = "//a[contains(text(), 'DEVELOPMENT')]")
	WebElementFacade developmentLink;

	@FindBy(linkText = "WEBSITE")
	WebElementFacade websiteLink;

	@FindBy(xpath = "//*[@class = 'footer']//a[contains(@href , 'mailto')]")
	WebElementFacade mailTo;

	@FindBy(xpath = "//img[@alt = 'Digital Marketing Company in Bangalore']")
	WebElementFacade imageLink;
	
	private String projectLink = "//*[text() = 'ProjectLink']";

	public void waitUntilBrandStoryLoads() {
		getDriver().manage().window().maximize();
		this.open();
		waitForCondition().until(ExpectedConditions.visibilityOfAllElements(brandHomePage));
		waitForCondition().until(ExpectedConditions.visibilityOf(contactUsLink));
	}

	public String getMailID() {
		mailTo.waitUntilPresent();
		return mailTo.getText();
	}

	public void navigateToWebsite() {
		developmentLink.waitUntilEnabled().click();
		Serenity.takeScreenshot();
		websiteLink.waitUntilVisible().click();
	}

	public void selectProject(String projectName) {
		projectLink = projectLink.replace("ProjectLink", projectName);
		System.out.println("The project link is " + projectLink);
		WebElementFacade projectLinkElement = element(By.xpath(projectLink));
		getJavascriptExecutorFacade().executeScript("scroll(0, 2000);");
		waitForCondition().until(ExpectedConditions.visibilityOf(projectLinkElement));
		Serenity.takeScreenshot();
		projectLinkElement.click();
	}

	public String waitUntilMyDetailsAppear() {
		waitForCondition().until(ExpectedConditions.visibilityOf(imageLink));
		return getDriver().getTitle();
	}
}

package com.taf.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.taf.utils.BasePageObject;
import com.taf.utils.ConfigProperties;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http://rwa-ota-raboweblogin.rabobank.nl/")
public class BMHCookiePage extends BasePageObject {

	@FindBy(tagName = "b")
	WebElementFacade loggedinText;

	@FindBy(xpath = "//a[contains(text(), 'DEVELOPMENT')]")
	WebElementFacade developmentLink;

	@FindBy(linkText = "WEBSITE")
	WebElementFacade websiteLink;

	@FindBy(xpath = "//*[@class = 'footer']//a[contains(@href , 'mailto')]")
	WebElementFacade mailTo;

	@FindBy(xpath = "//img[@alt = 'Digital Marketing Company in Bangalore']")
	WebElementFacade imageLink;

	private String projectLink = "//*[text() = 'ProjectLink']";

	public void loadCookies(String cookieUrl) {
		this.maximizeWindow();
		switch (cookieUrl) {

		case "PrivateCookieUrl1":
			getDriver().get(ConfigProperties.getInstance().getCookieUrl1());
			waitForTextToAppear(loggedinText, "Gebruiker LB\\3052.BMRC-particulie is succesvol ingelogd.");
			break;

		case "BusinesssCookieUrl":
			getDriver().navigate().to(ConfigProperties.getInstance().getCookieUrl2());
			waitForTextToAppear(loggedinText, "Gebruiker LB\\3052.BOB52LBBMRC004 is succesvol ingelogd.");
			break;

		case "PrivateCookieUrl2":
			getDriver().navigate().to(ConfigProperties.getInstance().getCookieUrl3());
			waitForTextToAppear(loggedinText, "Gebruiker LB\\3052.BMRC-particuli2 is succesvol ingelogd.");
			break;

		}

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
		scrollDown(2000);
		waitForCondition().until(ExpectedConditions.visibilityOf(projectLinkElement));
		Serenity.takeScreenshot();
		projectLinkElement.click();
	}

	public String waitUntilMyDetailsAppear() {
		waitForCondition().until(ExpectedConditions.visibilityOf(imageLink));
		return getDriver().getTitle();
	}
}

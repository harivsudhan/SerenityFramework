package com.taf.actions;

import org.junit.Assert;

import com.taf.pages.BrandStoryHomePage;

import net.thucydides.core.annotations.Step;

public class BrandStoryHomeActions {
	BrandStoryHomePage brandStoryHomePage;

	@Step
	public void openBrandStoryPage() {
		brandStoryHomePage.open();
	}

	@Step
	public void verifyContactUs() {
		String emailID = brandStoryHomePage.getMailID();
		Assert.assertTrue("BrandStory is not loaded properly", emailID.trim().equalsIgnoreCase("info@brandstory.in"));

	}
	
	@Step
	public void navigateToWebSite() {
		brandStoryHomePage.navigateToWebsite();
	}
	
	@Step
	public void selectAPIProject(String Project) {
		brandStoryHomePage.selectProject(Project);

	}
	
	@Step
	public void verifyTitle(String Title) {
		String pageTitle = brandStoryHomePage.waitUntilMyDetailsAppear();
		Assert.assertTrue("BrandStory is not loaded properly", pageTitle.trim().contains(Title));

	}

}
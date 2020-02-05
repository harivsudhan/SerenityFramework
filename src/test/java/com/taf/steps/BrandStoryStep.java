package com.taf.steps;

import org.junit.Assert;
import com.taf.pages.BrandStoryHomePage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BrandStoryStep {
	BrandStoryHomePage brandStoryHomePage;

	@Given("^I navigate to BrandStory Page$")
	public void i_navigate_to_BrandStory_Page() {
		brandStoryHomePage.waitUntilBrandStoryLoads();
	}

	@Then("^I should be able to get the page loaded$")
	public void i_should_be_able_to_get_the_page_loaded() {
		String emailID = brandStoryHomePage.getMailID();
		Assert.assertTrue("BrandStory is not loaded properly", emailID.trim().equalsIgnoreCase("info@brandstory.in"));
	}

	@Given("^User Navigates to Development Website$")
	public void user_Navigates_to_Development_Website() {
		brandStoryHomePage.navigateToWebsite();
	}

	@When("^User selects the \"([^\"]*)\" project$")
	public void user_selects_the_project(String project) {
		brandStoryHomePage.selectProject(project);
	}

	@Then("^User verify the \"([^\"]*)\" display of the project navigated$")
	public void user_verify_the_display_of_the_project_navigated(String Title) {
		String pageTitle = brandStoryHomePage.waitUntilMyDetailsAppear();
		Assert.assertTrue("BrandStory is not loaded properly", pageTitle.trim().contains(Title));
	}

}
package com.taf.steps;

import com.taf.actions.BrandStoryHomeActions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class BrandStoryStep {
	@Steps
	BrandStoryHomeActions brandStoryHomeActions;

	@Given("^I navigate to BrandStory Page$")
	public void i_navigate_to_BrandStory_Page() {
		brandStoryHomeActions.openBrandStoryPage();
	}
	
	@Then("^I should be able to get the page loaded$")
	public void i_should_be_able_to_get_the_page_loaded() {
		brandStoryHomeActions.verifyContactUs();
	}

	@Given("^User Navigates to Development Website$")
	public void user_Navigates_to_Development_Website() {
		brandStoryHomeActions.openBrandStoryPage();
	    brandStoryHomeActions.navigateToWebSite();
	}

	@When("^User selects the \"([^\"]*)\" project$")
	public void user_selects_the_project(String project) {
	    brandStoryHomeActions.selectAPIProject(project);
	}

	@Then("^User verify the \"([^\"]*)\" display of the project navigated$")
	public void user_verify_the_display_of_the_project_navigated(String Title) {
	    brandStoryHomeActions.verifyTitle(Title);
	    
	}

}
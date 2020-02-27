package com.taf.steps;

import java.util.List;

import org.junit.Assert;

import com.taf.pages.BMHAccountSelectionPage;
import com.taf.pages.BMHCookiePage;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.WebElementFacade;

public class BMHAccountSelectionStep {
	BMHCookiePage bmhCookiePage;
	BMHAccountSelectionPage bmhAccountSelectionPage;
	private String[] accountType;

	@Given("^I launch the \"([^\"]*)\"$")
	public void i_launch_the(String cookieUrl) {
		bmhCookiePage.loadCookies(cookieUrl);
	}

	@Then("^I should be logged in to BMRC application$")
	public void i_should_be_logged_in_to_BMRC_application() {
		String pageHeader = bmhAccountSelectionPage.loadBMHApplication();
		Assert.assertTrue("BMH application is not loaded properly", pageHeader.trim().contains("Rekeningselectie"));
	}

	@Given("^I search for \"([^\"]*)\" in the Account Selection Screen$")
	public void i_search_for_in_the_Account_Selection_Screen(String accountNumber) {
		bmhAccountSelectionPage.searchAccountNumber(accountNumber);

	}

	@When("^the accountNumber in the Account Overview table is clicked$")
	public void the_in_the_Account_Overview_table_is_clicked() {
		bmhAccountSelectionPage.selectAccountNumberFromTable();
	}

	@Then("^I should verify the \"([^\"]*)\" in the Account Details popUp window$")
	public void i_should_verify_the_in_the_Account_Details_popUp_window(String accountNumber) {
		String AccountNumber = bmhAccountSelectionPage.getAccountNumberFromPopUpWindow();
		System.out.println("Expected - " + accountNumber + " actual " + AccountNumber);
		Assert.assertTrue("Account number is not displayed correctly", AccountNumber.trim().contains(accountNumber));
	}

	@Then("^I expand and verify the below Account Information Blocks in the popUp window$")
	public void i_expand_and_verify_the_below_Account_Information_Blocks_in_the_popUp_window(DataTable dt) {
		List<String> list = dt.asList(String.class);
		for (String option : list) {
			bmhAccountSelectionPage.expandVerifyAccountInfo(option);
		}
	}

	@Then("^I close the Account details popUp window$")
	public void i_close_the_Account_details_popUp_window() {
		bmhAccountSelectionPage.closePopUpWindow();
	}

	@When("^the Account Number in the Account Overview table is selected$")
	public void the_in_the_Account_Overview_table_is_selected() {
		bmhAccountSelectionPage.modifyAccountNumberFromTable();

	}

	@Then("^I should verify the \"([^\"]*)\" in the Account settings screen$")
	public void i_should_verify_the_in_the_Account_settings_screen(String accountNumber) {
		String AccountNumber = bmhAccountSelectionPage.getAccountNumberFromAccountSettingsScreen();
		System.out.println("Expected - " + accountNumber + " actual " + AccountNumber);
		Serenity.takeScreenshot();
		Assert.assertTrue("Account number is not displayed correctly", AccountNumber.trim().contains(accountNumber));
	}

	@Then("^I modify random data for the below combobox$")
	public void i_modify_random_data_for_the_below_combobox(DataTable dt) {
		List<String> list = dt.asList(String.class);
		for (String option : list) {
			try {
				bmhAccountSelectionPage.modifyComboBoxAccountNumberData(option);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@Then("^I modify the random data for the below radio button$")
	public void i_modify_the_random_data_for_the_below_radio_button(DataTable dt) {
		List<String> list = dt.asList(String.class);
		for (String option : list) {
			try {
				bmhAccountSelectionPage.modifyRadioButtonAccountNumberData(option);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@When("^I click complete button$")
	public void i_click_button() {
		bmhAccountSelectionPage.clickComplete();

	}

	@Then("^I verify modified data for the below combobox$")
	public void i_verify_modified_data_for_the_below_combobox(DataTable dt) {
		bmhAccountSelectionPage.expandAccountPanel();
		List<String> list = dt.asList(String.class);
		for (String option : list) {
			bmhAccountSelectionPage.expandVerifyAccountGeneralInfoPanel(option);
		}
	}

	@Then("^I verify modified data for the below radio button$")
	public void i_verify_modified_data_for_the_below_radio_button(DataTable dt) {
		List<String> list = dt.asList(String.class);
		for (String option : list) {
			bmhAccountSelectionPage.expandVerifyAccountGeneralInfoPanel(option);
		}
	}
	
	@Then("^I should verify the \"([^\"]*)\" in the Convert screen$")
	public void i_should_verify_the_in_the_Convert_screen(String accountNumber) {
		String AccountNumber = bmhAccountSelectionPage.getAccountNumberFromAccountConvertScreen();
		System.out.println("Expected - " + accountNumber + " actual " + AccountNumber);
		Serenity.takeScreenshot();
		Assert.assertTrue("Account number is not displayed correctly", AccountNumber.trim().contains(accountNumber));
	    
	}


	@And("^I select random data for Account Type and click convert$")
	public void i_select_random_data_for_and_click_convert() {
	    accountType = bmhAccountSelectionPage.selectAccountType().split("-");
	    bmhAccountSelectionPage.clickAccountTypeConvertButton();
	}
	
	@Then("^I should verify the Account Type in the Account settings screen$")
	public void i_should_verify_the_Account_Type_in_the_Account_settings_screen() {
		String AccountType = bmhAccountSelectionPage.getAccountTypeFromAccountSettingsScreen();
		System.out.println("Expected - " + accountType[1] + " actual " + AccountType);
		Serenity.takeScreenshot();
		Assert.assertTrue("Account Type is not displayed correctly", AccountType.trim().contains(accountType[1]));
	}
	
	@Then("^I should verify the Account Type in the Account Details popUp window$")
	public void i_should_verify_the_AccountType_in_the_Account_Details_popUp_window() {
		String AccountType = bmhAccountSelectionPage.getAccountTypeFromPopUpWindow();
		System.out.println("Expected - " + accountType + " actual " + AccountType);
		Assert.assertTrue("Account Type is not displayed correctly", AccountType.trim().contains(accountType[1]));
	}


}
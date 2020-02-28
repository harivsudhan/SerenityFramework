package com.taf.pages;

import java.util.LinkedHashMap;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.taf.utils.BasePageObject;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http://ast01lsrv4091.linux.rabobank.nl/bmrc-lb/ivoportal/bmrc-lb/bmrc-lb/lb/ver=2.0/rparam=destination=login")
public class BMHAccountSelectionPage extends BasePageObject {

	@FindBy(xpath = "//*[@class='pagetitle']")
	WebElementFacade accountSelectionHeader;

	@FindBy(id = "accountNumber")
	WebElementFacade accountNumberTextField;

	@FindBy(xpath = "//*[@id='resulttable']/table")
	WebElementFacade resultTable;

	@FindBy(xpath = "//*[@id='resulttable']/table//tr[1]/td[2]")
	WebElementFacade accountNumber;

	@FindBy(xpath = "//*[@id='resulttable']/table//tr[1]/td[2]")
	WebElementFacade accountNumberDetails;

	@FindBy(id = "configAccountSlidingDiv")
	WebElementFacade accountPanel;

	@FindBy(id = "configAccountInfoSlidingDiv")
	WebElementFacade accountInfoPanel;

	@FindBy(id = "configAccountCreditSlidingDiv")
	WebElementFacade accountCreditPanel;

	@FindBy(id = "configAccountRpkSlidingDiv")
	WebElementFacade accountRpkPanel;

	@FindBy(name = "chooseAccountNumber")
	WebElementFacade chooseAccountNumber;

	@FindBy(id = "modify")
	WebElementFacade modifyButton;

	@FindBy(id = "modifyAccountType")
	WebElementFacade convertButton;

	@FindBy(id = "pa_header")
	WebElementFacade accountNumberHeaderText;

	@FindBy(id = "configure.account.account.number")
	WebElementFacade modifyAccountNumberText;

	@FindBy(id = "change.account.type.number")
	WebElementFacade convertAccountNumberText;

	@FindBy(id = "keyButton_view.abbAgreementIndicator")
	WebElementFacade abbAgreementIndicator;

	@FindBy(id = "ra_dd_value_view.abbAgreementIndicator")
	WebElementFacade abbAgreementIndicatorSelectedValue;

	private By abbAgreementIndicatorList = By.xpath("//div[@id='abb_commercial']//div[contains(@class, 'data-row')]");

	@FindBy(id = "keyButton_view.abbTransactionIndicator")
	WebElementFacade abbTransactionIndicator;

	@FindBy(id = "ra_dd_value_view.abbTransactionIndicator")
	WebElementFacade abbTransactionIndicatorSelectedValue;

	private By abbTransactionIndicatorList = By
			.xpath("//div[@id='abb_operational']//div[contains(@class, 'data-row')]");

	@FindBy(id = "keyButton_view.administrativeLocation")
	WebElementFacade administrativeLocation;

	@FindBy(id = "ra_dd_value_view.administrativeLocation")
	WebElementFacade administrativeLocationSelectedValue;

	private By administrativeLocationList = By
			.xpath("//div[@id='adminstrative_code']//div[contains(@class, 'data-row')]");

	@FindBy(id = "keyButton_view.affiliateInstitution")
	WebElementFacade affiliateInstitution;

	@FindBy(id = "ra_dd_value_view.affiliateInstitution")
	WebElementFacade affiliateInstitutionSelectedValue;

	private By affiliateInstitutionList = By
			.xpath("//div[@id='searchbox_affiliateInstitution']//div[contains(@class, 'data-row')]");

	@FindBy(id = "keyButton_view.tarifgroup")
	WebElementFacade rateGroupButton;

	private By rateGroupList = By.xpath("//div[@id='abb_commercial']//div[contains(@class, 'data-row')]");
	
	@FindBy(id = "keyButton_view.transTypeDesc")
	WebElementFacade transactionCodeButton;

	private By transactionCodeList = By.xpath("//div[@id='search_transactioncode']//div[contains(@class, 'data-row')]");

	@FindBy(id = "accountStatementFrequency")
	WebElementFacade statementFrequencyComboBox;

	@FindBy(id = "blockDirectDebit_J")
	WebElementFacade blockDirectDebit_Yes;

	@FindBy(id = "blockDirectDebit_N")
	WebElementFacade blockDirectDebit_No;

	@FindBy(id = "blockDirectDebit_J_label")
	WebElementFacade blockDirectDebit_YesLabel;

	@FindBy(id = "blockDirectDebit_N_label")
	WebElementFacade blockDirectDebit_NoLabel;

	@FindBy(id = "awOffsetAccountRequired_J")
	WebElementFacade awOffsetAccountRequired_Yes;

	@FindBy(id = "awOffsetAccountRequired_N")
	WebElementFacade awOffsetAccountRequired_No;

	@FindBy(id = "awOffsetAccountRequired_J_label")
	WebElementFacade awOffsetAccountRequired_YesLabel;

	@FindBy(id = "awOffsetAccountRequired_N_label")
	WebElementFacade awOffsetAccountRequired_NoLabel;

	@FindBy(id = "finalizeButton")
	WebElementFacade completeButton;

	@FindBy(id = "accountType")
	WebElementFacade accountTypeDropDown;

	@FindBy(id = "modifyAccountType2")
	WebElementFacade accountTypeConvertButton;

	@FindBy(xpath = "//*[@id='discontinue']/following::*[@id='counteramount']")
	WebElementFacade counteramountButton;

	@FindBy(id = "configure.account.abbcodecommercial")
	WebElementFacade abbcodecommercialText;

	@FindBy(id = "configure.account.abbcodeoperations")
	WebElementFacade abbcodeoperationsText;

	@FindBy(id = "configure.account.administrativelocation")
	WebElementFacade administrativelocationText;

	@FindBy(id = "configure.account.affiliateInstitution")
	WebElementFacade affiliateInstitutionText;

	@FindBy(id = "configure.account.accountStatementFrequency")
	WebElementFacade accountStatementFrequencyText;

	@FindBy(id = "configure.account.blockdirectdebit")
	WebElementFacade blockdirectdebitText;

	@FindBy(id = "configure.account.awOffsetAccountRequired")
	WebElementFacade awOffsetAccountRequiredText;

	@FindBy(id = "configure.account.account.type")
	WebElementFacade accountTypeText;

	@FindBy(id = "change.ascription.accountType")
	WebElementFacade accountTypePopUpScreenText;
	
	@FindBy(id = "counteramount.search.button")
	WebElementFacade counterSearchButton;

	@FindBy(id = "button.close")
	WebElementFacade popUpWindowCloseButon;
	
	@FindBy(name = "counteramount.clear.button")
	WebElementFacade counterClearButton;
	
	@FindBy(id = "settlementPeriod")
	WebElementFacade settlementPeriodDropDown;
	
	@FindBy(id = "startdate")
	WebElementFacade startdateTextField;
	
	@FindBy(id = "next.button")
	WebElementFacade nextButton;
	
	@FindBy(id = "counteramount.download.csv.button")
	WebElementFacade downloadCSVButton;
	
	private By counteramountTable = By.xpath("//*[@id='counter-amnt']//tr");
	
	private By counteramountTableFirstRowDate = By.xpath("(//*[@id='counter-amnt']//td[@class = 'firstcol'])[1]");

	private LinkedHashMap<String, String> modifiedData;

	private List<WebElement> dropdownListElements;

	private List<String> dropdownList;

	private String SelectedValue;

	public BMHAccountSelectionPage() {
		modifiedData = new LinkedHashMap<String, String>();
	}

	public String loadBMHApplication() {
		this.open();
		waitForCondition().until(ExpectedConditions.visibilityOf(accountSelectionHeader));
		return accountSelectionHeader.getText();
	}

	public void searchAccountNumber(String accountNumber) {
		accountNumberTextField.waitUntilVisible().click();
		clearSendKeysEnter(accountNumberTextField, accountNumber);
	}

	public void selectAccountNumberFromTable() {
		accountNumber.waitUntilClickable().click();
	}

	public void clickComplete() {
		completeButton.waitUntilEnabled().click();
	}
	
	public void clickCounterClearButton() {
		counterClearButton.waitUntilEnabled().click();
	}

	public void modifyAccountNumberFromTable() {
		chooseAccountNumber.waitUntilClickable().click();
	}

	public void clickAccountTypeConvertButton() {
		accountTypeConvertButton.waitUntilClickable().click();
	}

	public String getAccountNumberFromPopUpWindow() {
		return accountNumberDetails.waitUntilPresent().getText().replaceAll("\\s", "");
	}

	public String getAccountTypeFromPopUpWindow() {
		return accountTypePopUpScreenText.waitUntilPresent().getText().trim();
	}

	public String getAccountNumberFromAccountSettingsScreen() {
		modifyButton.waitUntilEnabled().click();
		return modifyAccountNumberText.waitUntilPresent().getText().replaceAll("\\s", "");
	}

	public String getAccountTypeFromAccountSettingsScreen() {
		return accountTypeText.waitUntilPresent().getText().trim();
	}

	public String getAccountNumberFromAccountConvertScreen() {
		convertButton.waitUntilEnabled().click();
		return convertAccountNumberText.waitUntilPresent().getText().replaceAll("\\s", "");
	}
	
	public void clickCounterSearchButton() {
		counterSearchButton.waitUntilClickable().click();
	}

	public String getAccountNumberFromCounterAmountScreen() {
		String accountNumberHeadertext = null;
		try {
			counteramountButton.waitUntilEnabled().click();
			accountNumberHeadertext = accountNumberHeaderText.waitUntilPresent().getText().replaceAll("\\s", "");
			return accountNumberHeadertext;
		} catch (Exception e) {
			Assert.fail("Unable to get AccountNumber From CounterAmount Screen " + e.getMessage());
		}
		return accountNumberHeadertext;
	}
	
	public int getTotalCounterAmountTableRows() {
		List<WebElement> tableElements = waitForCondition().until(ExpectedConditions.presenceOfAllElementsLocatedBy(counteramountTable));
		return tableElements.size();
	}

	public void expandAccountPanel() {
		accountPanel.waitUntilEnabled().click();
	}

	public void closePopUpWindow() {
		popUpWindowCloseButon.waitUntilEnabled().click();
	}
	
	public void clickNextButton() {
		nextButton.waitUntilEnabled().click();
	}
	
	public void clickDownloadCSVButton() {
		downloadCSVButton.waitUntilEnabled().click();
	}

	public String expandVerifyAccountInfo(String accountInfoPanels) {

		switch (accountInfoPanels) {

		case "General":
			accountPanel.waitUntilEnabled().click();
			Serenity.takeScreenshot();
			accountPanel.waitUntilEnabled().click();
			break;
		case "Information products":
			accountInfoPanel.waitUntilEnabled().click();
			Serenity.takeScreenshot();
			accountInfoPanel.waitUntilEnabled().click();
			break;
		case "Credit":
			accountCreditPanel.waitUntilEnabled().click();
			Serenity.takeScreenshot();
			accountCreditPanel.waitUntilEnabled().click();
			break;
		case "RPK":
			accountRpkPanel.waitUntilEnabled().click();
			Serenity.takeScreenshot();
			accountRpkPanel.waitUntilEnabled().click();
			break;

		}
		return accountInfoPanels;
	}

	private void selectRandomComboBoxValue(WebElementFacade selectedElementValue, WebElementFacade comboBox, By locator,
			String comboBoxName) {
		String SelectedValue = selectedElementValue.getAttribute("value");
		System.out.println("The selected value is " + SelectedValue);

		comboBox.waitUntilEnabled().click();
		dropdownListElements = waitForCondition().until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));

		for (WebElement option : dropdownListElements) {
			String elementText = option.findElement(By.tagName("span")).getText().trim();
			System.out.println("The element text is " + elementText);
			if (!elementText.contains(SelectedValue) && !elementText.contentEquals("")) {
				option.click();
				modifiedData.put(comboBoxName, elementText);
				System.out.println(modifiedData);
				break;
			}
		}

	}
	
	private void selectRandomComboBoxValueCounterScreen(WebElementFacade comboBox, By locator, String comboBoxName) {

		comboBox.waitUntilEnabled().click();
		dropdownListElements = waitForCondition().until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));

		for (WebElement option : dropdownListElements) {
			String elementText = option.findElement(By.tagName("span")).getText().trim();
			System.out.println("The element text is " + elementText);
			if (!elementText.contentEquals("")) {
				option.click();
				modifiedData.put(comboBoxName, elementText);
				System.out.println(modifiedData);
				break;
			}
		}

	}


	public void modifyComboBoxAccountNumberData(String comboBox) throws InterruptedException {

		switch (comboBox) {

		case "ABB code commercial":
			selectRandomComboBoxValue(abbAgreementIndicatorSelectedValue, abbAgreementIndicator,
					abbAgreementIndicatorList, comboBox);
			break;
		case "ABB code operational":
			selectRandomComboBoxValue(abbTransactionIndicatorSelectedValue, abbTransactionIndicator,
					abbTransactionIndicatorList, comboBox);
			break;
		case "Administrative location code":
			selectRandomComboBoxValue(administrativeLocationSelectedValue, administrativeLocation,
					administrativeLocationList, comboBox);
			break;
		case "Affiliated institution code":
			selectRandomComboBoxValue(affiliateInstitutionSelectedValue, affiliateInstitution, affiliateInstitutionList,
					comboBox);
			break;
		case "Frequency of account statements":
			String SelectedValue = statementFrequencyComboBox.waitUntilEnabled().getSelectedVisibleTextValue().trim();
			System.out.println("The selected value is " + SelectedValue);
			dropdownList = statementFrequencyComboBox.getSelectOptions();

			for (String option : dropdownList) {
				String elementText = option.trim();
				System.out.println("The element text is " + elementText);
				if (!SelectedValue.contentEquals(elementText)) {
					statementFrequencyComboBox.selectByVisibleText(elementText);
					SelectedValue = statementFrequencyComboBox.waitUntilEnabled().getSelectedVisibleTextValue().trim();
					break;
				}
			}
			modifiedData.put(comboBox, SelectedValue);
			System.out.println(modifiedData);

			break;
		}
	}

	public void modifyComboBoxCounterAmountsData(String comboBox) throws InterruptedException {

		switch (comboBox) {

		case "Rate group":
			selectRandomComboBoxValueCounterScreen(rateGroupButton, rateGroupList, comboBox);
			break;
		case "Transaction code on RA":
			selectRandomComboBoxValueCounterScreen(transactionCodeButton, transactionCodeList, comboBox);
			break;
		case "Note period":
			dropdownList = settlementPeriodDropDown.waitUntilEnabled().getSelectOptions();
			selectFromComboBox(dropdownList, settlementPeriodDropDown);
			break;
		case "Starting date":
			String dateText = waitForCondition().until(ExpectedConditions.visibilityOfElementLocated(counteramountTableFirstRowDate)).getText().trim();
			clearSendKeysEnter(startdateTextField, dateText);
			break;
		}
	}

	public void modifyRadioButtonAccountNumberData(String radioButton) throws InterruptedException {

		switch (radioButton) {

		case "Debt block":
			if (blockDirectDebit_Yes.waitUntilVisible().isSelected()) {
				blockDirectDebit_No.waitUntilEnabled().click();
				modifiedData.put(radioButton, blockDirectDebit_NoLabel.getText().trim());
			} else {
				blockDirectDebit_Yes.waitUntilEnabled().click();
				modifiedData.put(radioButton, blockDirectDebit_YesLabel.getText().trim());
			}
			break;
		case "AW contra account desired":
			if (awOffsetAccountRequired_Yes.waitUntilVisible().isSelected()) {
				awOffsetAccountRequired_No.waitUntilEnabled().click();
				modifiedData.put(radioButton, awOffsetAccountRequired_NoLabel.getText().trim());
			} else {
				awOffsetAccountRequired_Yes.waitUntilEnabled().click();
				modifiedData.put(radioButton, awOffsetAccountRequired_YesLabel.getText().trim());
			}
			break;
		}
		System.out.println(modifiedData);
	}

	private void verifyGeneralInforText(WebElementFacade element, String option) {
		String actualText = waitForCondition().until(ExpectedConditions.visibilityOf(element)).getText().trim();
		String expectedText = modifiedData.get(option).trim();
		System.out.println("Actual is " + actualText + " expected text is " + expectedText);
		Assert.assertTrue("The modified data for " + option + " is wrongly displayed",
				actualText.endsWith(expectedText));
	}

	public void expandVerifyAccountGeneralInfoPanel(String option) {
		switch (option) {

		case "ABB code commercial":
			verifyGeneralInforText(abbcodecommercialText, option);
			break;
		case "ABB code operational":
			verifyGeneralInforText(abbcodeoperationsText, option);
			break;
		case "Administrative location code":
			verifyGeneralInforText(administrativelocationText, option);
			break;
		case "Affiliated institution code":
			verifyGeneralInforText(affiliateInstitutionText, option);
			break;
		case "Frequency of account statements":
			verifyGeneralInforText(accountStatementFrequencyText, option);
			break;
		case "Debt block":
			verifyGeneralInforText(blockdirectdebitText, option);
			break;
		case "AW contra account desired":
			verifyGeneralInforText(awOffsetAccountRequiredText, option);
			break;

		}

	}

	public String selectAccountType() {
		dropdownList = accountTypeDropDown.waitUntilEnabled().getSelectOptions();
		return selectFromComboBox(dropdownList, accountTypeDropDown);
	}
	
	private String selectFromComboBox(List<String> dropdownList, WebElementFacade elementDropDown) {
		for (String option : dropdownList) {
			String elementText = option.trim();
			System.out.println("The element text is " + elementText);
			if (!elementText.contentEquals("")) {
				elementDropDown.selectByVisibleText(elementText);
				SelectedValue = elementDropDown.waitUntilEnabled().getSelectedVisibleTextValue().trim();
				break;
			}
		}
		return SelectedValue;
	}

}

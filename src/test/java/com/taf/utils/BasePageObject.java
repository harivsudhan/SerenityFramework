package com.taf.utils;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class BasePageObject extends PageObject {
	private JavascriptExecutor javascriptExecutor = null;
	private Actions actions;
	private static final String CLICK_COMMAND = "arguments[0].click();";
	private static final String SET_INPUT_COMMAND = "arguments[0].value='%s';";
	private static final String JS_DISPLAY_COMMAND = "arguments[0].style.display='block';";

	public void maximizeWindow() {
		getDriver().manage().window().maximize();
	}

	public void waitForClickableOf(final By byElementCriteria) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 20);
        wait.until(ExpectedConditions.elementToBeClickable(byElementCriteria));
    }

	public String getCurrentURL() {
		return getDriver().getCurrentUrl();
	}

	public void scrolltoElementJS(WebElementFacade element) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) getDriver();
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	public void moveToElement(WebElementFacade element) {
		actions = new Actions(getDriver());
		actions.moveToElement(element).build().perform();
	}
	
	public void scrollDown(int height) {
		getJavascriptExecutorFacade().executeScript("window.scrollBy(0,"+ height + ")");
	}

	public void clickElementJS(WebElementFacade element) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) getDriver();
		jsExecutor.executeScript(CLICK_COMMAND, element);
	}

	public void clearSendKeys(WebElementFacade element, String send_text) {
		element.waitUntilEnabled().type(send_text);
	}

	public void clearSendKeysEnter(WebElementFacade element, String send_text) {
		element.waitUntilEnabled().typeAndEnter(send_text);
	}

	public void setImplicitWait() {
		getDriver().manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
	}

	public void waitForElementToBeVisible(WebElementFacade element) {
		waitFor(ExpectedConditions.elementToBeClickable(element));
	}

	public void waitForElementToBeClickable(WebElementFacade locator) {
		waitFor(ExpectedConditions.elementToBeClickable(locator));
	}

	public void navigateback() {
		getDriver().navigate().back();
	}

	public String getLinkAttribute(WebElementFacade element) {
		return element.waitUntilVisible().getAttribute("href");
	}

	public List<String> getLinksFromPage(List<WebElementFacade> we) {
		List<String> link_atttibute = null;
		try {
			for (int i = 0; i < we.size(); i++) {
				link_atttibute.add(we.get(i).getAttribute("href"));
				System.out.println(link_atttibute);
			}
		} catch (Exception e) {
			link_atttibute.add(e.getMessage());
		}
		return link_atttibute;
	}

	public Boolean verifyPresenceOfTextInPage(List<String> expectedString, String actualString) {
		Boolean allTextPresent = true;
		try {
			for (String string_ : expectedString) {
				if (actualString.trim().toLowerCase().contains(string_.trim().toLowerCase())) {
					continue;
				} else {
					allTextPresent = false;
					break;
				}
			}
		} catch (Exception e) {
			allTextPresent = false;
		}
		return allTextPresent;
	}

	public Boolean verifylinksInPage(List<String> expectedString, List<WebElementFacade> all_links) {
		Boolean allTextPresent = true;
		try {
			for (String string_ : expectedString) {
				if (!all_links.contains(string_))
					allTextPresent = false;
				break;
			}
		} catch (Exception e) {
			allTextPresent = false;
		}
		return allTextPresent;
	}

	public void waitforNonAngular(WebElementFacade element, long counter) {
		waitForElementToBeClickable(element);
		waitABit(counter);
	}

	public void WaitForPagetoLoad() throws InterruptedException {
		for (int i = 0; i <= 100; i++) {
			waitForWithRefresh();
			waitABit(300);
			checkPageIsReady();
		}
	}

	public void checkPageIsReady() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		for (int i = 0; i < 100; i++) {
			if (js.executeScript("return document.readyState").toString().equals("complete")) {
				break;
			}
		}
	}

	public static void sleep(long inMillis) {
		try {
			Thread.sleep(inMillis);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}

	/**
	 * returns list of webElements.
	 * 
	 * @param locator
	 * @return List<WebElement>
	 */
	public List<WebElementFacade> getElements(final By by) {
		return findAll(by);

	}

	/**
	 * this method checks if the element is present on page.
	 * 
	 * @param locator
	 * @return boolean
	 */
	public boolean isElementOnPage(final By by) {
		return containsElements(by);
	}

	/**
	 * returns true, if element is enabled.
	 * 
	 * @param locator
	 * @return boolean
	 */
	public boolean isEnabled(final By by) {
		return find(by).waitUntilVisible().isEnabled();
	}

	/**
	 * returns true, if element is displayed.
	 * 
	 * @param locator
	 * @return boolean
	 */
	public boolean isDisplayed(final WebElementFacade element) {
		return element.waitUntilVisible().isDisplayed();
	}

	/**
	 * returns true, if element is selected.
	 * 
	 * @param locator
	 * @return boolean
	 */
	public boolean isSelected(final By by) {
		return find(by).waitUntilVisible().isSelected();
	}

	/**
	 * returns the number of instances of the element.
	 * 
	 * @param locator
	 * @return size
	 */
	public int getElementsSize(final By locator) {
		return getElementsSize(locator);
	}

	/**
	 * This method sets input value using javascript Executor. Also provides the
	 * feature of clean before setting the value.
	 * 
	 * @param locator
	 * @param value
	 * @param clearInput
	 */
	public void setInputValueJS(final WebElementFacade element, final String value, final boolean clearInput) {
		if (clearInput) {
			element.clear();
		}
		javascriptExecutor = (JavascriptExecutor) getDriver();
		javascriptExecutor.executeScript(String.format(SET_INPUT_COMMAND, value), element);
	}

	/**
	 * This method sets input value using javascript Executor.
	 * 
	 * @param locator
	 * @param value
	 * @param clearInput
	 */
	public void setInputValueJS(final WebElementFacade element, final String value) {
		element.clear();
		javascriptExecutor = (JavascriptExecutor) getDriver();
		javascriptExecutor.executeScript(String.format(SET_INPUT_COMMAND, value), element);
	}

	/**
	 * This method clears the input field value.
	 * 
	 * @param element
	 */
	public void clearElement(final WebElementFacade element) {
		element.waitUntilEnabled().clear();
	}

	/**
	 * This method clicks the element.
	 * 
	 * @param element
	 */
	public void clickElement(final WebElementFacade element) {
		element.waitUntilEnabled().click();
	}

	/**
	 * This method returns the text.
	 * 
	 * @param locator
	 * @return String
	 */
	public String getText(final WebElementFacade element) {
		return element.waitUntilVisible().getText();
	}

	/**
	 * This method returns the value of mentioned attribute.
	 * 
	 * @param locator
	 * @param attribute
	 * @return String
	 */
	public String getAttribute(final WebElementFacade element, final String attribute) {
		return element.waitUntilPresent().getAttribute(attribute);
	}

	/**
	 * This method returns the css value of mentioned field.
	 * 
	 * @param locator
	 * @param attribute
	 * @return String
	 */
	public String getCssValue(final WebElementFacade element, final String attribute) {
		return element.waitUntilPresent().getCssValue(attribute);
	}

	/**
	 * This method first makes the element visible and then perform click action
	 * using javascript.
	 * 
	 * @param locator
	 */
	public void makeElementVisibleAndClick(final WebElementFacade element) {
		javascriptExecutor = (JavascriptExecutor) getDriver();
		javascriptExecutor.executeScript(JS_DISPLAY_COMMAND, element);
		javascriptExecutor.executeScript(CLICK_COMMAND, element);
	}

	/**
	 * This method shifts the focus away from the current element.
	 * 
	 * @param locator
	 */
	public void shiftFocusAway(final WebElementFacade element) {
		element.waitUntilEnabled().sendKeys(Keys.TAB);
	}

	public String getPageSource() {
		return getDriver().getPageSource();
	}

	/**
	 * This method uploads the file to the location mentioned in the filePath.
	 * 
	 * @param by
	 * @param filePath
	 */
	public void uploadFile(final WebElementFacade element, String filePath) {
		upload(filePath);
		/*
		 * File file = new File(filePath); if
		 * (WebDriver.class.isAssignableFrom(getDriver().getClass())) {
		 * Clear_SendKeys(element, file.getAbsolutePath()); } else if
		 * (RemoteWebDriver.class.isAssignableFrom(((WrapsDriver)
		 * getDriver()).getWrappedDriver().getClass())) { ((RemoteWebDriver)
		 * ((WrapsDriver) getDriver()).getWrappedDriver()).setFileDetector(new
		 * LocalFileDetector()); Clear_SendKeys(element, file.getAbsolutePath()); }
		 */
	}

	public void highlightElement(final WebElementFacade element) {
		for (int i = 0; i < 5; i++) {
			javascriptExecutor = (JavascriptExecutor) getDriver();
			javascriptExecutor.executeScript("arguments[0].setAttribute('style',arguments[1]);", element,
					"color: green; border: 5px solid blue;");
			sleep(100);
			javascriptExecutor.executeScript("arguments[0].setAttribute('style',arguments[1]);", element, "");
		}
	}

	public boolean isAlertPresent() {
		Alert alert = getAlert();
		if (alert != null) {
			return true;
		} else {
			return false;
		}
	}

	public void acceptAlertBox() {
		Alert alert = getAlert();
		if (alert != null) {
			alert.accept();
		} else {
			System.out.println("Alert box is not present!!!");
		}
	}

	public String getAlertBoxText() {
		Alert alert = getAlert();
		if (alert != null) {
			return alert.getText();
		} else {
			System.out.println("Alert box is not present!!!");
			return null;
		}
	}

	public void setValueInAlertBox(String valueToSet) {
		Alert alert = getAlert();
		if (alert != null) {
			alert.sendKeys(valueToSet);
		} else {
			System.out.println("Alert box is not present!!!");
		}
	}

	public void waitForElementToDisappear(final By by, int timeoutDuration) {
		waitForRenderedElementsToDisappear(by);
	}

	public void selectFromDropdownByVisibleText(final WebElementFacade element, String text) {
		element.waitUntilVisible().selectByVisibleText(text);
	}

	public void selectFromDropdownByIndex(final WebElementFacade element, int index) {
		element.waitUntilVisible().selectByIndex(index);
	}

	public void selectFromDropdownByValue(final WebElementFacade element, String value) {
		element.waitUntilVisible().selectByVisibleText(value);
	}

	public void SwitchToFrame(WebElementFacade element) {
		WebDriverWait wait = new WebDriverWait(getDriver(), 20);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
	}

	public void switchToDefaultContent() {
		getDriver().switchTo().defaultContent();
	}

}

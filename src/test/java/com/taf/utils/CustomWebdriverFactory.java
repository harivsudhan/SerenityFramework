package com.taf.utils;

import java.util.Collections;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import net.thucydides.core.webdriver.DriverSource;

public class CustomWebdriverFactory implements DriverSource {

	@Override
	public WebDriver newDriver() {
		try {
			System.setProperty("webdriver.chrome.driver", "libs//chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--incognito");
			options.addArguments("--disable-infobars");
			options.setExperimentalOption("useAutomationExtension", false);
			options.setExperimentalOption("excludeSwitches", 
			        Collections.singletonList("enable-automation"));
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			options.merge(capabilities);
			return new ChromeDriver(options);
		} catch (Exception e) {
			System.out.println("Unable to launch Chrome Browser " + e.getStackTrace());
			throw new Error(e);
		}
	}

	@Override
	public boolean takesScreenshots() {
		return true;
	}
}

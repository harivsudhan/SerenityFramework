package com.taf.utils;

import java.io.File;
import java.util.Collections;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import net.thucydides.core.webdriver.DriverSource;

public class CustomWebdriverFactory implements DriverSource {

	@Override
	public WebDriver newDriver() {
		try {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + File.separator + "libs" + File.separator + "chromedriver.exe");

			HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
			chromePrefs.put("profile.default_content_settings.popups", 0);
			chromePrefs.put("download.default_directory",
					System.getProperty("user.dir") + File.separator + "downloadFiles");

			ChromeOptions options = new ChromeOptions();
			HashMap<String, Object> chromeOptionsMap = new HashMap<String, Object>();

			options.setExperimentalOption("prefs", chromePrefs);
			options.addArguments("--test-type");
			options.addArguments("--incognito");
			options.addArguments("--disable-infobars");
			options.setExperimentalOption("useAutomationExtension", false);
			options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));

			DesiredCapabilities cap = DesiredCapabilities.chrome();
			cap.setCapability(ChromeOptions.CAPABILITY, chromeOptionsMap);
			cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			cap.setCapability(ChromeOptions.CAPABILITY, options);
			options.merge(cap);

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

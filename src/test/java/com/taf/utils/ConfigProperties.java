package com.taf.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigProperties {
	private static ConfigProperties config;
	private Properties props;

	public static ConfigProperties getInstance() {
		if (config == null) {
			config = new ConfigProperties();
			config.init();
		}
		return config;
	}

	private ConfigProperties() {
	}

	public void init() {
		props = new Properties();
		try {
			InputStream configFile_Input = new FileInputStream(new File(".").getCanonicalPath() + "/config.properties");
			props.load(configFile_Input);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getProperty(String propName) {
		return this.props.getProperty(propName);
	}
	
	public String getShopCartUsername() {
		return this.getProperty("ShopCartUserName");
	}
	
	public String getShopCartPassowrd( ) {
		return this.getProperty("ShopCartPassword");
	}
}

package com.qa.opencart.driverfactory;

import java.util.Properties;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class optionsManager {
	
	private Properties prop;
	private ChromeOptions co;
	private FirefoxOptions fo;
	
	public optionsManager(Properties prop)
	{
		this.prop=prop;
	}
	
	public ChromeOptions getChromeOptions() {
		co = new ChromeOptions();
		return co;
	}
	
	public FirefoxOptions getFirefoxOptions() {
		fo = new FirefoxOptions();
		return fo;
	}

}

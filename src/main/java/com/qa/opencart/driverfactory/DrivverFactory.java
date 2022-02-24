package com.qa.opencart.driverfactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DrivverFactory {
	
	public WebDriver driver;
	public Properties prop;
	
	public static String highlightt;
	public static ThreadLocal<WebDriver> tldriver=new ThreadLocal<WebDriver>();
	
	public optionsManager opmanager;
	
	
	public WebDriver init_driver(Properties prop)
	{
		String browser=prop.getProperty("browser").trim();
		System.out.println("Browser name is :"+browser);
		
		highlightt=prop.getProperty("highlight").trim();
		
		opmanager=new optionsManager(prop);
		
	
		
		if(browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			//driver = new ChromeDriver();
			tldriver.set(new ChromeDriver(opmanager.getChromeOptions()));
			
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			tldriver.set(new FirefoxDriver(opmanager.getFirefoxOptions()));
		}
		else
		{
			System.out.println("Please pass the right browser name : " + browser);
		}
		
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		getDriver().get("https://demo.opencart.com/index.php?route=account/login");
		
		return getDriver();		
		/*
		 * Driver Factory class method is responsible to initialize  the driver 
		 * and return the driver when called.
		 */
		
	}
	
	public static WebDriver getDriver()
	{
		return tldriver.get();
	}
	
	public Properties init_prop()
	{
		prop=new Properties();
		try {
			FileInputStream ip=new FileInputStream("./src/test/resources/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return prop;
		
	}
	
	public String getScreenshot() {
		File srcFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/screenshot/" + System.currentTimeMillis() + ".png";
		File destination = new File(path);
		try {
			FileUtils.copyFile(srcFile, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}

}

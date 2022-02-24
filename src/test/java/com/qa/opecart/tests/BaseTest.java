package com.qa.opecart.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.opencart.Pages.AccountPageLandingReference;
import com.qa.opencart.Pages.LoginPage;
import com.qa.opencart.Pages.ResultPage;
import com.qa.opencart.driverfactory.DrivverFactory;

public class BaseTest {
	
	DrivverFactory driverFactoryObjectreference;
	LoginPage loginPageReference;
	AccountPageLandingReference  AccountPageReference;
	ResultPage ResultPageReference;
	Properties prop;
	
	public WebDriver driver;
	
	@BeforeTest
	public void beforeTest() 
	{
		driverFactoryObjectreference=new DrivverFactory();
		prop=driverFactoryObjectreference.init_prop();
		driver=driverFactoryObjectreference.init_driver(prop);
		loginPageReference=new LoginPage(driver);
		
	}
	
	@AfterTest
	public void afterTest()
	{
		driver.quit();
	}

}

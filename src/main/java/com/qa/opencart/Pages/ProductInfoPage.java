package com.qa.opencart.Pages;

import org.openqa.selenium.WebDriver;

import com.qa.opencart.Utility.ElementUtil;

public class ProductInfoPage {

	public WebDriver driver;

	ElementUtil elementUtilityreference;
	
	public ProductInfoPage(WebDriver driver)
	{
		this.driver=driver;
		elementUtilityreference=new ElementUtil(driver);
		
		

	}

}

package com.qa.opencart.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.Utility.ElementUtil;

public class AccountPageLandingReference {
	
	public WebDriver driver;
	
	ElementUtil elementUtilityreference;
	
	private By search = By.name("search");
	private By searchIcon = By.cssSelector("div#search button");
	
	public AccountPageLandingReference(WebDriver driver)
	{
		this.driver=driver;
		
		elementUtilityreference=new ElementUtil(driver);
	}
	
	public String AccountPageTitle()
	{
		return elementUtilityreference.doGetPageTitleContains("My",10);
	}
	
	public ResultPage SearchPagelanding(String productName)
	{
		elementUtilityreference.doSendKeys(search, productName);
		
		elementUtilityreference.doClick(searchIcon);
		
		return new ResultPage(driver);
	}
	
	

}

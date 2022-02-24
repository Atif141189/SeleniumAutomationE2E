package com.qa.opencart.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.Utility.ElementUtil;

public class LoginPage {
	
	/*
	 * Every PAGE class we have to maintain Locater
	 * 
	 * But we need driver to be passed for page actions/page method.
	 */
	//4. Maintaining the Element Utility class object reference.
	
	ElementUtil elementUtilityreference;
	
	
	// 1. private By locator
		private By emailId = By.id("input-email");
		private By password = By.id("input-password");
		private By loginBtn = By.xpath("//input[@value='Login']");
		private By forgotPwdLink = By.linkText("Forgotten Password");
		private By registerLink = By.linkText("Register");
		
	//2. Maintaining a driver as global class variable
		
	    private WebDriver driver;
	    
	 //3. Login Page constructor defined.
	    public LoginPage(WebDriver driver)
	    {
	    	this.driver=driver; 
	    	// We have to create the object somewhere to call this login page constructor.
	    	//Create the object of element util class by passing the login page driver
	    	//Element util constructor will be called.
	    	
	    	elementUtilityreference=new ElementUtil(driver);
	    }
	    
	    //5. Page actions of Login Page by calling the method of Utility class.
	    
	    public String LoginPageTitle()
	    {
	    	return elementUtilityreference.doGetPageTitleContains("Account",10);
	    }
	    
	    public AccountPageLandingReference doLogin()
	    {
	    	
	    	elementUtilityreference.doSendKeys(emailId, "naveenanimation20@gmail.com");
	    	
	    	elementUtilityreference.doSendKeys(password, "Selenium12345");
	    	
	    	elementUtilityreference.doClick(loginBtn);
	    	
	    	return new AccountPageLandingReference(driver);
	    	
	    }

}

package com.qa.opencart.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.qa.opencart.Utility.ElementUtil;

public class ResultPage {
	
	private WebDriver driver;
	
	ElementUtil elementUtilityreference;
	
	
	private By productResults = By.cssSelector("div.caption a");
	
	public ResultPage(WebDriver driver)
	{
		this.driver=driver;
		elementUtilityreference=new ElementUtil(driver);
		
	}
	
	public String ResultPageTitle()
	{
		return elementUtilityreference.doGetPageTitleContains("Search",10);	
		
	}	
	
	public ProductInfoPage selectProduct(String mainProductName) {
		System.out.println("main product name : " + mainProductName);
		List<WebElement> searchList = 
				elementUtilityreference.waitForElementsVisible(productResults, 10);
		
		for(WebElement e : searchList) {
			String text = e.getText();
				if(text .equals(mainProductName)) {
					e.click();
					break;
				}
		}
		return new ProductInfoPage(driver);

}
}

package com.qa.opecart.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ResultPageTest extends BaseTest{
	
	@BeforeClass
	public void beforeclassResult()
	{
		AccountPageReference=loginPageReference.doLogin();
	}
	@Test
	public void ResultPageTitleTest()
	{
		ResultPageReference=AccountPageReference.SearchPagelanding("Mac");
		
		Assert.assertTrue(ResultPageReference.ResultPageTitle().contains("Search"));
	}
	
	

}

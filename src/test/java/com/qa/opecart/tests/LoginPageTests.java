package com.qa.opecart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTests extends BaseTest{
	
	@Test
	public void loginPageTitleTest()
	{
		Assert.assertTrue(loginPageReference.LoginPageTitle().contains("dddd"));
	}
	

}

package com.qa.opecart.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AccountPageTest extends BaseTest{
	
	@BeforeClass
	public void beforeClass()
	{
		AccountPageReference=loginPageReference.doLogin();
		
	}
	@Test
	public void AccountPageTitleTest()
	{
		String AccountTtitleactual=AccountPageReference.AccountPageTitle();
		
		Assert.assertEquals(AccountTtitleactual,"My Account");
	}
	

}

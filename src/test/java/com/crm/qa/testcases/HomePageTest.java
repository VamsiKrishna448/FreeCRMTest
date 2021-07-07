package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.utility.TestUtil;

public class HomePageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	
	public HomePageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		testUtil=new TestUtil();
		loginPage=new LoginPage();
		homePage=loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void homePageTitleTest()
	{
		String homePageTitle=homePage.verifyHomePageLink();
		Assert.assertEquals(homePageTitle,"CRMPRO","PAGE TITLE WAS NOT MATCHED");
	}
	
	@Test(priority=2)
	public void VerifyUserNameTest()
	{
		testUtil.switchToFrame();
		boolean veriftUserName =homePage.verifyCorrectUserName();
		Assert.assertTrue(veriftUserName);
		//or Assert.assertTrue(homePage.verifyCorrectUserName());
	}
	
	@Test(priority=3)
	public void verifyContactsLinkTest()
	{
		testUtil.switchToFrame();
		contactsPage=homePage.clickOnContactsLink();
	}
	
	/*@Test(priority=1)
	public void verifyNewDealsLink()
	{
		testUtil.switchToFrame();
		homePage.createNewDeal();
	}*/
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}

package com.crm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.utility.TestUtil;

public class DealsPagesTest extends TestBase {

	HomePage homePage;
	TestUtil testUtil;
	LoginPage loginPage;
	//ContactsPage contactsPage;
	DealsPage dealsPage;
	
	
	public DealsPagesTest()
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
		//testUtil.switchToFrame();
		//contactsPage=homePage.clickOnContactsLink();
		homePage=new HomePage();
		dealsPage=new DealsPage();
	}
	
	@Test(priority=1)
	public void validateCreateNewDeal()
	{
		testUtil.switchToFrame();
		homePage.createNewDeal();
		dealsPage.createNewContact("Savings Account","1000", "CG","LED");
		
		
	}
	@AfterMethod
	public void tearDown() 
	{
		
		driver.quit();
	}
	
	
}

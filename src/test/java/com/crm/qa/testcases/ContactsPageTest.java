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

public class ContactsPageTest extends TestBase {
TestUtil testUtil;	
LoginPage loginPage;
HomePage homePage;
ContactsPage contactsPage;
	
	public ContactsPageTest()
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
		contactsPage=new ContactsPage();
		//contactsPage=homePage.clickOnContactsLink();
	}
	
	@Test(priority=1)
	public void verifyContactsPageLabel()
	{
		boolean contactsLabel=contactsPage.verifyContactsLabel();
		Assert.assertTrue(contactsLabel,"contacts label missing on the page");
	}
	
	@Test(priority=2)
	public void validateCreateNewContact()
	{
		testUtil.switchToFrame();
		homePage.clickOnNewContactsLink();
		contactsPage.createNewContact("Mr.", "Vamsi", "Krsihna", "CG");
	}
	
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	

}

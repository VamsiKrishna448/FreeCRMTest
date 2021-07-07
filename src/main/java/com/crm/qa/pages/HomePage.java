package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(xpath="//td[contains(text(),'User: Demo User')]")
	WebElement userNameLabel;	
	
	@FindBy(xpath="//a[@title='Contacts']")
	WebElement contactsLink ;
	
	/*@FindBy(xpath="//a[contains(text(),New Contact)]")
	WebElement newContactsLink;*/
	
	@FindBy(xpath="//a[@title='New Contact']")
	WebElement newContactsLink;
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement dealsLink ;
	
	@FindBy(xpath="//a[contains(text(),'New Deal')]")
	WebElement newDealsLink ;

	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	WebElement tasksLink ;
	
	public HomePage()
	{
		PageFactory.initElements(driver,this);
		
	}
	
	public String verifyHomePageLink()
	{
		return driver.getTitle();
		
	}
	
	public boolean verifyCorrectUserName()
	{
		
		return userNameLabel.isDisplayed();
	}
	
	public ContactsPage clickOnContactsLink()
	{
		contactsLink.click();
		return new ContactsPage();
	}
	
	public DealsPage clickOnDealsLink()
	{
		dealsLink.click();
		return new DealsPage();
	}
	
	public TasksPage clickOnTasksLink()
	{
		tasksLink.click();
		return new TasksPage();
	}
	
	public void clickOnNewContactsLink()
	{
		Actions action=new Actions(driver);
		action.moveToElement(contactsLink).build().perform();
		newContactsLink.click();
		
	}
	
	public void createNewDeal()
	{
		Actions action=new Actions(driver);
		action.moveToElement(dealsLink).build().perform();
		newDealsLink.click();
		
	}
	
	
}
	
 
	
	
	
	


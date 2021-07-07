package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase{
	
	
	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement contactsLabel;
	
	/*@FindBy(name="title")
	WebElement titleDrpDown;
	@FindBy(xpath="//select[@name='title']")
	WebElement titleDrpDown;
	
	@FindBy(name="first_name")
	WebElement firstName;
	
	
	@FindBy(id="surname")
	WebElement lastName;
	
	@FindBy(name="client_lookup")
	WebElement company;*/
	
	@FindBy(xpath="//input[@id='first_name']")
	WebElement firstName;
	
	@FindBy(xpath="//input[@id='surname']")
	WebElement lastName;
	
	@FindBy(xpath="//input[@name='client_lookup']")
	WebElement company;
	
	
	
	
	@FindBy(xpath="//input[@type='submit' and @value='Save' and @class='button']")
	WebElement saveBtn;
	
	public ContactsPage()
	{
		PageFactory.initElements(driver,this);
		
	}
	
	
	public boolean verifyContactsLabel()
	{
		return contactsLabel.isDisplayed();
		
	}
	
	public void createNewContact(String title,String ftname,String ltname,String comp)
	{
		Select select=new Select(driver.findElement(By.xpath("//select[@name='title']")));
		select.selectByVisibleText(title);
		firstName.sendKeys(ftname);
		lastName.sendKeys(ltname);
		company.sendKeys(comp);
		saveBtn.click();
	}
	

}

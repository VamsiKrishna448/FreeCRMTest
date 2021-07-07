package com.crm.qa.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	
	//PageFactory or ObjectRepository
	
	@FindBy(name="username")
	WebElement name;

	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginBtn;
	
	@FindBy(xpath="//a[contains(text(),'Sign Up']")
	WebElement signUpBtn;
	
	@FindBy(xpath="//img[contains(@class,'img-responsive')]")
	WebElement crmLogo;
	
	//Initializing element from PF using pageFactory.initiElements() method
	//Initializing the page objects:
	public LoginPage()
	{
		PageFactory.initElements(driver,this);
		//all above variables name,password etc initialate with driver and this is current class object
		//instead of this we can write LoginPage.class
	}
	
	//Actions:
	
	public String validateLoginPageTitle()
	{
		return driver.getTitle();
		
	}
	public boolean validateCrmLogo()
	{
		return crmLogo.isDisplayed();
		
	}
	
	public HomePage login(String un,String pwd)
	{
		name.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		//After click loginButton u have enter or return into HomePage
		
		return new HomePage();
	}
	
}

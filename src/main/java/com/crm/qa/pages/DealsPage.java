package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class DealsPage extends TestBase {
	
	@FindBy(xpath="//select[@name='product_id']")
	WebElement selectProduct;
	
	@FindBy(name="title")
	WebElement title;
	
	@FindBy(name="title")
	WebElement amount;
	
	@FindBy(name="title")
	WebElement company;
	
	@FindBy(xpath="//input[@type='submit' and @name='addmore']")
	WebElement saveBtn;
	
	
	public void createNewContact(String titleName,String amt,String comp,String productType)
	{
		title.sendKeys(titleName);
		amount.sendKeys(amt);
		company.sendKeys(comp);
		Select select=new Select(selectProduct);
		select.selectByVisibleText(productType);
		
		saveBtn.click();
	}

}

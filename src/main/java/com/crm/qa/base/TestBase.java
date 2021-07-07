package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.crm.qa.utility.TestUtil;

public class TestBase {
	
	
	//public static WebDriver driver;
	public static Properties prop;
	public static WebDriver driver;
	
	public TestBase()
	{
		try{
		prop = new Properties();
		FileInputStream ip=new FileInputStream("C:\\Users\\vmalla\\workspace\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
		prop.load(ip);
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
	}
		
		public static void initialization(){
			
		String browserName =prop.getProperty("browser");
		System.out.println(browserName);
			if(browserName.equals("chrome"))
			{
			  	
				System.setProperty("webdriver.chrome.driver", "C:\\Java_01\\chromedriver_win32\\chromedriver.exe");
				driver=new ChromeDriver();
			}
			else if(browserName.equals("IE"))
			{
				 driver=new InternetExplorerDriver();
				System.setProperty("webdriver.IE.driver", "");
			}
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT,TimeUnit.MINUTES);
			driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICITY_WAIT, TimeUnit.SECONDS);
			driver.get(prop.getProperty("url"));
			
		}
		
		
	
	


	
	
	
	

}

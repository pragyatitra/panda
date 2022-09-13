package com.autopanda.qa.base;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.autopanda.qa.utility.UtilityClass;

public class BaseClass {

	public static WebDriver driver;
	public static Properties prop;
	public static String properties_path="C:\\Users\\win10\\eclipse-workspace\\AutomationPanda\\src\\main\\java\\com\\qa\\autopanda\\configuration\\config.properties";
	public static BufferedReader reader;
	
	public BaseClass()
	{
		try
		{
			reader= new BufferedReader(new FileReader(properties_path));
			prop= new Properties();
			prop.load(reader);
			
		}
		catch(FileNotFoundException f)
		{
			f.printStackTrace();
		}
		catch(IOException i)
		{
			i.printStackTrace();
		}
	}
	public void initialization() 
	{
		String browserName=prop.getProperty("browser");
		if(browserName.equals("chrome"))
		{
			
			System.setProperty("wedriver.chrome.driver","C:\\Users\\win10\\eclipse-workspace\\SeleniumCroma\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.setPageLoadStrategy(PageLoadStrategy.NONE);
			driver = new ChromeDriver(options);

		}
//		else if(browserName.equals("firefox"))
//		{
//			System.setProperty("webdriver.gecko.driver","path");
//			driver= new FirefoxDriver();
//		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(UtilityClass.pageLoadTimeOut));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(UtilityClass.implicitliWait));
		driver.get("https://automationpanda.com/");
		try {
		Thread.sleep(10000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		

	}
}

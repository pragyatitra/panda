package com.autopanda.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.autopanda.qa.base.BaseClass;

public class HomePage extends BaseClass {

	@FindBy(xpath="//h1[contains(text(),'Automation Panda')]")
	WebElement heading;
	
	@FindBy(xpath="//a[contains(text(),'About')]")
	WebElement about;
	
	@FindBy(xpath="//a[contains(text(),'Contact')]")
	WebElement contact;
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String verifyTitle()
	{
		String actualTitle=driver.getTitle();
		return actualTitle;
	}
	public String verifyHeading()
	{
		String actualHeading=heading.getText().toString();
		return actualHeading;
	}
	public AboutPage verifyAboutPage()
	{
		about.click();
		return new AboutPage();
	}
	
	public ContactPage verifyContactPage()
	{
		contact.click();
		return new ContactPage();
	}
}

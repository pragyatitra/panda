package com.autopanda.qa.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.autopanda.qa.base.BaseClass;
import com.autopanda.qa.pages.ContactPage;
import com.autopanda.qa.pages.HomePage;

public class HomePageTest extends BaseClass{

	HomePage homePage;
	ContactPage contactPage;
	
	public HomePageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		homePage = new HomePage();
	}
	
	@Test
	public void verifyTitleTest()
	{
		String expectedTitle="Automation Panda | A blog for software development and testing";
		Assert.assertEquals(homePage.verifyTitle(),expectedTitle );
	}
	@Test
	public void verifyHeadingTest()
	{
		String expectedHeading="AUTOMATION PANDA";
		Assert.assertEquals(homePage.verifyHeading(),expectedHeading );
	}
	
	@Test
	public void verifyContactPageTest()
    {
		String expectedContactPageTitle="Automation Panda | A blog for software development and testing";
		contactPage=homePage.verifyContactPage();
		String contactPageActualTitle=driver.getTitle();
		Assert.assertEquals(expectedContactPageTitle, contactPageActualTitle);
    }
}

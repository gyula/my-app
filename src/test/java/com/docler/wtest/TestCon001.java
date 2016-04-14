package com.docler.wtest;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestCon001 {
	
	WebDriver driver;
	
	@Before
	public void setup(){
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@Test
	public void CON001() {
		HomePage home = new HomePage(driver);
		FormPage form = new FormPage(driver);
		ErrorPage error = new ErrorPage(driver);
		
		home.openPage();
		Assert.assertTrue("Home page title is not proper!", home.checkTitle());
		Assert.assertTrue("Logo not found on home page", home.isLogoExists());
		form.openPage();
		Assert.assertTrue("Form page title is not proper!", form.checkTitle());
		Assert.assertTrue("Logo not found form page", form.isLogoExists());
		form.typeName("Sophia");
		Assert.assertTrue("Hello page title is not proper!", form.checkTitle());
		Assert.assertTrue("Error Logo not found", form.isLogoExists());
		error.openPage();
		Assert.assertTrue("Error page title is not proper!", error.checkTitle());
		Assert.assertTrue("Logo not found on error page", error.isLogoExists());
	}
	
	@After
	public void Close(){
		driver.close();
	}

}

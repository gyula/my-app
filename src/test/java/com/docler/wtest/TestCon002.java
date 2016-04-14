package com.docler.wtest;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestCon002 {
	WebDriver driver;
	
	@Before
	public void setup(){
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@Test
	public void CON002() {
		HomePage home = new HomePage(driver);
		
		home.openPage();
		Assert.assertTrue("Home page heading is not matching to the expected one.", home.isHeading());
		Assert.assertTrue("Home page paragraph is not matching to the expected one.", home.isParagraph());
		
	}
	
	@After
	public void Close(){
		driver.close();
	}

}

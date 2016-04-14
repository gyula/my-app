package com.docler.wtest;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestCon003 {

	WebDriver driver;
	
	@Before
	public void setup(){
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@Test
	public void CON003() {

		FormPage form = new FormPage(driver);
		
		form.openPage();
		Assert.assertTrue("Input field not found!", form.isInputfieldExists());
		Assert.assertTrue("Submit button not found!", form.isSubmitbuttonExists());
	}
	
	@After
	public void Close(){
		driver.close();
	}


}

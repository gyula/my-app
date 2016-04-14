package com.docler.wtest;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.docler.wtest.FormPage;
import com.docler.wtest.HomePage;

public class TestNav002 {
	WebDriver driver;
	
	@Before
	public void setup(){
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@Test
	public void Nav002(){
		HomePage home = new HomePage(driver);
		FormPage form = new FormPage(driver);
		form.openPage();
		form.clickLogo();
		Assert.assertTrue("Error - Logo is not clickable!", home.isURLActive());
		
	}
	
	@After
	public void Close(){
		driver.close();
	}

}

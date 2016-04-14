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


public class TestNav004 {
	
	WebDriver driver;

	@Before
	public void setup(){
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@Test
	public void NAV004() {
		HomePage home = new HomePage(driver);
		FormPage form = new FormPage(driver);
		home.openPage();
		Assert.assertTrue("Home Page not active", home.isHomeActive());
		home.clickNavForm();
		Assert.assertTrue("Form Page not active", form.isFormActive());
	}
	
	@After
	public void Close(){
		driver.close();
	}

}

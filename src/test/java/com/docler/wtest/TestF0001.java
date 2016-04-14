package com.docler.wtest;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestF0001 {

	WebDriver driver;
	
	@Before
	public void setup(){
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@Test
	public void F003() {

		FormPage form = new FormPage(driver);
		
		form.openPage();
		form.typeName("John");
		Assert.assertTrue("Out put value not corrct!", form.checkName("John"));
		form.openPage();
		form.typeName("Sophia");
		Assert.assertTrue("Out put value not corrct!", form.checkName("Sophia"));
		form.openPage();
		form.typeName("Charlie");
		Assert.assertTrue("Out put value not corrct!", form.checkName("Charlie"));
		form.openPage();
		form.typeName("Emily");
		Assert.assertTrue("Out put value not corrct!", form.checkName("Emily"));
	}
	
	@After
	public void Close(){
		driver.close();
	}
}

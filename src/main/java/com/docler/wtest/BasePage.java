package com.docler.wtest;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
	//* Abstract class for the common elements /
	private WebDriver driver;
	
	@FindBy( id = "form" )
	private WebElement btnForm;
	
	@FindBy( id = "home" )
	private WebElement btnHome;
	
	@FindBy( id = "error" )
	private WebElement btnError;
	
	@FindBy( id = "dh_logo" )
	private WebElement logo;
	
	public void clickNavForm(){
		btnForm.click();
	}
	
	public void clickNavHome(){
		btnHome.click();
	}
	
	public void clickNavError(){
		btnHome.click();
	}
	
	public void clickLogo(){
		if(isLogoExists()){
			logo.click();
		}
	}
	
	@SuppressWarnings("finally")
	public Boolean isLogoExists(){
		//* Checks that if the logo is on the page or not./
		Boolean res = false;
		try{
			logo.isDisplayed();
			res = true;
		}catch(NoSuchElementException e){
			System.out.println(e.getMessage());
		} finally {
			return res;
		}
	}

}

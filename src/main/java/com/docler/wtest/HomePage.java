package com.docler.wtest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage{
	private WebDriver driver;
	
	@FindBy(tagName ="h1")
	private WebElement textWelcome;
	
	@FindBy(tagName ="p")
	private WebElement textP;
	
	@FindBys({
		@FindBy(className = "active"),
		@FindBy(id = "home")
	})
	private WebElement activeHome;
	
	//URL
	private static String PAGE_URL="http://uitest.duodecadits.com";
	
	public HomePage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void openPage(){
		
		driver.get(PAGE_URL);
	}

	public Boolean isHomeActive(){
		//* Return true, if the home page button is active. /
		if( activeHome != null){
			
			return true;
		} else {
			
			return false;
		}
	}
	
	private Boolean isVisible(String visible, WebElement element){
		//* Compares the given expected string and the given element's text attribute
		//*	if they are identical return with true/
		if(element.getText().equals(visible)){
			
			return true;
		} else {
			
			return false;
		}
	}
	
	public Boolean isHeading(){
		
		String visible = "Welcome to the Docler Holding QA Department";
		
		if(isVisible(visible, textWelcome)){
			
			return true;
		} else {
			
			return false;
		}
	}
	
	public Boolean isParagraph(){
		
		String visible = "This site is dedicated to perform some exercises and demonstrate automated web testing.";
		
		if(isVisible(visible, textP)){
			
			return true;
		} else {
			
			return false;
		}
	}
	
	public Boolean isURLActive(){
		//* Returns true if the home page is currently opened page  /
		if(PAGE_URL.equals(driver.getCurrentUrl())){
			
			return true;
		} else {
			
			return false;
		}
	}
	
	public Boolean checkTitle(){
		
		String expectedTitle = "UI Testing Site";
		if( driver.getTitle().equals(expectedTitle)){
			
			return true;
		} else {
			
			return false;
		}
	}

}

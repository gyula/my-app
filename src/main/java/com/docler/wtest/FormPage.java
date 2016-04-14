package com.docler.wtest;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class FormPage extends BasePage{
private WebDriver driver;
	
	@FindBy( id = "hello-text")
	private WebElement name;
	
	@FindBys({
		@FindBy(className = "active"),
		@FindBy(id = "form")
	})
	private WebElement activeForm;
	
	@FindBy(id = "hello-input")
	private WebElement inputField;
	
	@FindBy( id = "hello-submit" )
	private WebElement btnSubmit;
	
	static final String PAGE_URL="http://uitest.duodecadits.com/form.html";
	
	public FormPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void openPage(){
		
		driver.get(PAGE_URL);
	}
	
	public Boolean isFormActive(){
		//* Return true, if the form button is active. /
		if( activeForm != null){
			
			return true;
		} else {
			
			return false;
		}
	}
	
	public Boolean isURLActive(){
		//* Returns true if the form page is currently opened page  /
		if(PAGE_URL.equals(driver.getCurrentUrl())){
			
			return true;
		} else {
			
			return false;
		}
	}
	
	public void typeName(String inputName){
		//* Types the name into the input field/
		inputField.sendKeys(inputName);
		btnSubmit.click();
	}
	
	public Boolean checkName(String Name){
		//* Compares the name against the pattern, return true of they are matching /
		String NamePattern = String.format("Hello %s!", Name);
		if(NamePattern.equals(name.getText())){
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
	
	@SuppressWarnings("finally")
	public Boolean isInputfieldExists(){
		
		Boolean res = false;
		try{
			inputField.isDisplayed();
			res = true;
		}catch(NoSuchElementException e){
			System.out.println(e.getMessage());
		} finally {
			return res;
		}
	}
	
	@SuppressWarnings("finally")
	public Boolean isSubmitbuttonExists(){
		
		Boolean res = false;
		try{
			btnSubmit.isDisplayed();
			res = true;
		}catch(NoSuchElementException e){
			System.out.println(e.getMessage());
		} finally {
			return res;
		}
	}

}

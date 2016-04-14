package com.docler.wtest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ErrorPage extends BasePage {
	private WebDriver driver;
	private static String PAGE_URL="http://uitest.duodecadits.com/error";
	
	public ErrorPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void openPage(){
		
		driver.get(PAGE_URL);
	}

	public Boolean isURLActive(){
		//* Returns true if error page is currently opened page  /
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

package org.pojo;

import org.classbase.Baseclass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FliploginPojo extends Baseclass {

	public FliploginPojo()   {
		PageFactory.initElements(driver, this);
		
	}
		@FindBy(id="email")
		private WebElement email;
		
		@FindBy(xpath="//input[@aria-label='Password']" )
		private WebElement password;
		
		@FindBy(name = "login")
		private WebElement loginbtn;

		public WebElement getEmail() {
			return email;
		}

		public WebElement getPassword() {
			return password;
		}

		public WebElement getLoginbtn() {
			return loginbtn;
		}
		
		
		
	}
	
	


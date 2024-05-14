package org.pojo;

import org.classbase.Baseclass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SiginPOJO extends Baseclass {

	public SiginPOJO() {
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath="//a[text()='Create new account']")
	private WebElement createnewAcc;
	
	@FindBy(xpath ="(//input[@type='text'])[2]")
			private WebElement firstNametextbox;
	
	@FindBy(name= "lastname")
	private WebElement secondnametextbox; 
	
	@FindBy(name = "reg_email__")
	private WebElement mobileorEmailTextBox;
	
	@FindBy(name = "reg_passwd__")
	private WebElement newpassword;

	public WebElement getCreatenewAcc() {
		return createnewAcc;
	}

	public WebElement getFirstNametextbox() {
		return firstNametextbox;
	}

	public WebElement getSecondnametextbox() {
		return secondnametextbox;
	}

	public WebElement getMobileorEmailTextBox() {
		return mobileorEmailTextBox;
	}

	public WebElement getNewpassword() {
		return newpassword;
	}
	
	
	
	
	
	
	
}


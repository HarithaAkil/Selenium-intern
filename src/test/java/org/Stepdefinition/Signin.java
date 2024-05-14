package org.Stepdefinition;

import java.util.List;

import org.classbase.Baseclass;
import org.pojo.SiginPOJO;
import io.cucumber.datatable.*;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Signin extends Baseclass{
	SiginPOJO s;
	@Given("To launch the browser and maximize the window")
	public void to_launch_the_browser_and_maximize_the_window() {
		launchBrowse();
		WindowMaximize();
	   
	}

	@When("To launch the url")
	public void to_launch_the_url() {
		launchUrl("https://en-gb.facebook.com/");
	   
	}

	@When("To cick the create new account")
	public void to_cick_the_create_new_account() {
		s = new SiginPOJO();
		clickBtn(s.getCreatenewAcc());
	}

	@When("To pass first name in frist Text box")
	public void to_pass_first_name_in_frist_Text_box(DataTable d) throws InterruptedException {
		Thread.sleep(3000);
		List<String> l = d.asList();
		s = new SiginPOJO();
		passText(l.get(3),s.getFirstNametextbox());
	}

	@When("To pass second name  second Text box")
	public void to_pass_second_name_second_Text_box() {
		s = new SiginPOJO();
		passText("sri",s.getSecondnametextbox());
	}

	@When("to pass mobilenum or email in email textbox")
	public void to_pass_mobilenum_or_email_in_email_textbox(DataTable d) {
		List<List<String>> le = d.asLists();
		s = new SiginPOJO();
		passText(le.get(1).get(2),s.getMobileorEmailTextBox());
	}

	@When("to create new password using new password text")
	public void to_create_new_password_using_new_password_text() {
		s = new SiginPOJO();
		passText("haritha",s.getNewpassword());
	}

	@Then("To close the chrome browser")
	public void to_close_the_chrome_browser() {
		//closeEntireBrowser();
	    
	}


}

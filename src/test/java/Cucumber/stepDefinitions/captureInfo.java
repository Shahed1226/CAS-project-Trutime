package Cucumber.stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import Cucumber.factory.BaseClass;
import Cucumber.pageObjects.*;
public class captureInfo extends BaseClass {
	WebDriver driver;
	Homepage hp;
	userInfo user;

	
	@Given("the user is on the be.cognizant page")
	public void the_user_is_on_the_be_cognizant_page_site() {
	  hp = new Homepage(BaseClass.getDriver());
	  hp.getHome();
	}

	@When("the user clicks the profile icon at the top corner of the page")
	public void the_user_clicks_the_profile_icon_at_the_top_corner_of_the_page() throws InterruptedException {
		Thread.sleep(10000);
		user = new userInfo(BaseClass.getDriver());
		user.clickInfoIcon();
		System.out.println("Clicked on Profile icon");
	}

	@When("check the informations displayed or not")
	public void check_the_informations_displayed_or_not() {
		user = new userInfo(BaseClass.getDriver());
		user.getUname();
		user.getemail();
	
		Assert.assertTrue(user.getUname().isDisplayed(),"username is displayed");
		Assert.assertTrue(user.getemail().isDisplayed(),"email is displayed");
	}
	
	
	@Then("his\\/her name and email is captured")
	public void his_her_name_and_email_is_captured() throws InterruptedException {
		
		user = new userInfo(BaseClass.getDriver());
		WebElement name = user.getUname();
		WebElement email= user.getemail();
		
		String printname=name.getText();
		String printemail = email.getText();
		
		System.out.println("Captured username is: " +printname);
		System.out.println("Captured email is: " +printemail);
			Thread.sleep(3000);	

		}
	
}

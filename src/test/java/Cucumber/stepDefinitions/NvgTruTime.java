package Cucumber.stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import Cucumber.factory.BaseClass;
import Cucumber.pageObjects.*;

public class NvgTruTime extends BaseClass  {
	WebDriver driver;
	NavigatingToOneC nvg1C;
	NavigatingToTruTime nvgTT;
	Homepage hp;
	SoftAssert Sa=new SoftAssert();
	
	@Given("In the be.cognizant page validating OneCognizant app is visbile or not")
	public void in_the_be_cognizant_page_validating_one_cognizant_app_is_visbile_or_not() {
	  hp = new Homepage(BaseClass.getDriver());
	  hp.getHome();
	}
	
	@When("clicking the Onecognizant app")
	public void clicking_the_onecognizant_app() throws InterruptedException {
		
		nvg1C = new NavigatingToOneC(BaseClass.getDriver());	
		Thread.sleep(15000);
		JavascriptExecutor js = (JavascriptExecutor) BaseClass.getDriver();
		js.executeScript("arguments[0].scrollIntoView();",nvg1C.scroll());	  
		
		  nvg1C.appOneC();
		  
	}

	@When("switching to next window")
	public void switching_to_next_window() {
		 Set<String> windleStrings=BaseClass.getDriver().getWindowHandles();
	     List<String>winIdList=new ArrayList<String>(windleStrings);
	     BaseClass.getDriver().switchTo().window(winIdList.get(1));
	}

	@When("click on the search icon")
	public void click_on_the_search_icon() throws InterruptedException {
	   nvgTT = new NavigatingToTruTime(BaseClass.getDriver());
	   Thread.sleep(5000);
	   nvgTT.clickSearch();
	}

	@Then("type Trutime and click search")
	public void type_trutime_and_click_search() {
		 nvgTT = new NavigatingToTruTime(BaseClass.getDriver());
		 
		 nvgTT.setSearch();
	}

	@Then("select trutime from the search")
	public void select_trutime_from_the_search() throws InterruptedException {
	  Thread.sleep(3000);
	  nvgTT = new NavigatingToTruTime(BaseClass.getDriver());
	  nvgTT.clickTru();
	}

}

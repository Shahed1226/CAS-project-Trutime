package Cucumber.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Cucumber.factory.BaseClass;

public class Homepage extends BasePage {

	public Homepage(WebDriver driver) {
		super(driver);// TODO Auto-generated constructor stub
	}

	private static String homeURL;
	
	
	
	public void setHome() {
		homeURL = driver.getCurrentUrl();
		if(homeURL.contains("Home")) {
			System.out.println("Homepage is displayed.");
		}
	}
	
	public String getHome() {
		return homeURL;
	}

	
	
}
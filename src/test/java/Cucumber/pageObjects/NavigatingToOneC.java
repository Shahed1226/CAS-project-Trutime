package Cucumber.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import Cucumber.factory.*;


public class NavigatingToOneC extends BasePage{

	public NavigatingToOneC(WebDriver driver) {
		super(driver);
		}
	
	@FindBy(xpath="//*[@id='QuicklinksItemTitle']")
	WebElement scroll;
	
	@FindBy(xpath="//div[@title='OneCognizant']")
	WebElement appTitle;
	
	public void appOneC() {
		appTitle.click();
	}

	public WebElement scroll() {
		return scroll;
	}
}

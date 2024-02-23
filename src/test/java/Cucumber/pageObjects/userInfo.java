package Cucumber.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class userInfo extends BasePage{
	public userInfo(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="(//div[@class='ohcfXYh6LUBy5DS5kNUjRQ=='])[1]")
	WebElement infoIcon;
	
	
	@FindBy(xpath="//div[@id='mectrl_currentAccount_primary']")
	WebElement userName;
	
	@FindBy(xpath="//div[@id='mectrl_currentAccount_secondary']")
	WebElement email;
	
	public void clickInfoIcon() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// cl=driver.findElement(By.xpath("(//div[@class='ohcfXYh6LUBy5DS5kNUjRQ=='])[1]"));
		js.executeScript("arguments[0].click();",infoIcon);
		//infoIcon.click();
	}
	
	public WebElement getUname() {
		return userName;
	}
	
	public WebElement getemail() {
		return email;
	}
}

package Cucumber.pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Cucumber.factory.*;

public class NavigatingToTruTime extends BasePage {

	public NavigatingToTruTime(WebDriver driver) {
		super(driver);
		
	}

	@FindBy(xpath="//li[@class='searchTopBar']")
	WebElement searchIcon;
	
	@FindBy(xpath="//input[@id='oneCSearchTop']")
	WebElement txtSearch;
	
	@FindBy(xpath="(//div[@class='appsResultText'])[1]")
	WebElement clickTru;
	
	
	public void clickSearch() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//WebElement cl=driver.findElement(By.xpath("(//div[@class='ohcfXYh6LUBy5DS5kNUjRQ=='])[1]"));
		js.executeScript("arguments[0].click();",searchIcon);
		//searchIcon.click();
		
	}
	
	public void setSearch() {
		txtSearch.sendKeys("Tru Time");
	}
	
	public void clickTru() {
		clickTru.click();
	}
}

package Cucumber.pageObjects;

import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Cucumber.factory.*;
public class DateValidation extends BasePage {
	public static String sysDate = "";
	public static List<String> sysWeek = new ArrayList<String>();
	public static int weekSize= 7;
	
	
	public DateValidation(WebDriver driver) {
		super(driver);
		
	}

	
	@FindBy(xpath="\"//*[@id='mCSB_2_container']/div[3]/div[\"+i+\"]/div[1]\"")
	WebElement date;
	
	@FindBy(xpath="//div[contains(@ng-if,'item.Date==activeDate')]")
	WebElement activeDate;
	
	@FindBy(xpath="//span[contains(@class,'topupavailablefromDate ng-binding')]")
	WebElement highlighted;
	
	@FindBy(xpath="//span[@class='ui-datepicker-month']")
	WebElement sysMonth;
	
	@FindBy(xpath="//span[@class='ui-datepicker-year']")
	WebElement sysYear;
	
	@FindBy(xpath="//*[@class='legend-labels']/li")
	List<WebElement> legends;
	
	public WebElement siteDates() {
		return date;
	}
	
	public WebElement activeDate() {
		return activeDate;
	}
	
	public WebElement highlighted() {
		return highlighted;
	}
	
	public WebElement sysMonth() {
		return sysMonth;
	}
	
	public WebElement sysYear() {
		return sysYear;
	}
	
	public List<WebElement> legends() {
		return legends;
	}
}

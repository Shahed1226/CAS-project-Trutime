package Cucumber.stepDefinitions;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Cucumber.factory.BaseClass;
import Cucumber.pageObjects.BasePage;
import Cucumber.pageObjects.DateValidation;
import Cucumber.pageObjects.Homepage;
import Cucumber.pageObjects.NavigatingToOneC;
import Cucumber.pageObjects.NavigatingToTruTime;
import Cucumber.utilities.excel;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ValiDating extends BaseClass  {
	
	public static String sysDate = "";
	public static List<String> sysWeek = new ArrayList<String>();
	public static int weekSize= 7;
	List<String> SystemDates=new ArrayList<String>();
	List<String> Legend=new ArrayList<String>();
	public static List<String> SystemTime=new ArrayList<String>();	
	public static List<String> TruTime=new ArrayList<String>();
	
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("EEE, dd MMM"); 
	LocalDate currentDate = LocalDate.now(); //For getting the current date 
	LocalDate firstDayOfWeek = currentDate.with(DayOfWeek.MONDAY).minusDays(1);
	LocalDateTime currentDateTime = LocalDateTime.now();
	LocalDateTime lastDay = currentDateTime.minusDays(15);
	String cur_lastDay=dtf.format(lastDay);
	
	Homepage hp;
	DateValidation dvd;
	NavigatingToOneC nvg1C;
	NavigatingToTruTime nvgTT;
	excel e = new excel();
	
	@Given("Navigating to trutime")
	public void Navigating_to_trutime() throws InterruptedException {
		hp = new Homepage(BaseClass.getDriver());
		nvg1C = new NavigatingToOneC(BaseClass.getDriver());
		nvgTT = new NavigatingToTruTime(BaseClass.getDriver());
		hp.getHome();
		Thread.sleep(3000);
		
//		JavascriptExecutor js = (JavascriptExecutor) BaseClass.getDriver();
//		js.executeScript("arguments[0].scrollIntoView();",nvg1C.scroll());		  
//	
//		 nvg1C.appOneC();
		 Set<String> windleStrings=BaseClass.getDriver().getWindowHandles();
	     List<String>winIdList=new ArrayList<String>(windleStrings);
	     BaseClass.getDriver().switchTo().window(winIdList.get(1));
	     nvgTT.clickSearch();
	     nvgTT.setSearch();
	     nvgTT.clickTru();
	}
	
	@Given("extract dates of week and days")
	public void extract_dates_of_week_and_days() throws InterruptedException {//date formatter for setting the format of the date
			Thread.sleep(3000);
				
				System.out.print("The Current date is: ");
				System.out.println(dtf.format(currentDate));//for printing the date according to the given format
				sysDate = dtf.format(currentDate);
								
				for (int i=0; i<7; i++) {
					LocalDate currentDay = firstDayOfWeek.plusDays(i);
					sysWeek.add(currentDay.format(dtf));
					System.out.println(sysWeek.get(i));
					
				}
				System.out.println("<------------------------------------------------->");
				
			
	}

	@Given("check those dates with system date and validate it")
	public void And_check_those_dates_with_system_date_and_validate_it() {
		  
		BaseClass.getDriver().switchTo().frame(BaseClass.getDriver().findElement(By.id("appFrame")));
		System.out.println("<---------Below are the Dates Displayed On TruTime--------->");
			
			   for(int i = 2; i <=8; i++) 
					{
				    	String date = BaseClass.getDriver().findElement(By.xpath("//*[@id='mCSB_2_container']/div[3]/div["+i+"]/div[1]")).getText();
						System.out.println(date);
					
					}	
			
				SystemDates.addAll(sysWeek);
			System.out.println("-------------------------------------------------");
	}
	
	@When("checking the date format to see if the current date is highlighted or not")
	public void checking_the_date_format_to_see_if_the_current_date_is_highlighted_or_not() {
		
		dvd =new DateValidation(BaseClass.getDriver());
		Boolean tru_Date_High= dvd.activeDate().isDisplayed();
		  System.out.println("The highlighted date is: "+dvd.activeDate().getText());
		  Assert.assertTrue(tru_Date_High==true,"It is not highlighted. Validation done.");//runs if failed
		  
		  System.out.println("Today's date is Highlighted,Validation done.");//runs if passed
		  
		  System.out.println("<------------------------------------------------->");
	  	}

	@Then("Validate backdated topup date is visible or not")
	public void validate_backdated_topup_date_is_visible_or_not() {
		
		String topupavailablefromDate = BaseClass.getDriver().findElement(By.xpath("//span[@class='topupavailablefromDate ng-binding']")).getText();
		System.out.println("expected backdate--" +cur_lastDay);
		System.out.println("backdated date--" +topupavailablefromDate);
		if(cur_lastDay.equals(topupavailablefromDate))
		{
			System.out.println("Backdate validation passed");
		}
		else
		{
			System.out.println("Backdate validation failed");
		}
		System.out.println("<------------------------------------------------->");
	}

	@Then("Current month and year should match with System calendar")
	public void current_month_and_year_should_match_with_system_calendar() {
		 Date date = new Date();
		 SimpleDateFormat month1 = new SimpleDateFormat("MMMM");
		 SimpleDateFormat year = new SimpleDateFormat("YYYY");
		 String currentMonth = month1.format(date);
	     String currentYear=year.format(date)  ; 


		   System.out.println("The current year is: "+currentYear);
		   System.out.println("The current month is: "+currentMonth);
		   
		   String truMonth = dvd.sysMonth().getText();
		   String truYear = dvd.sysYear().getText();
		   
		   Assert.assertEquals(currentMonth, truMonth, "Validation Done, TruTime Month doesn't matches CurrentMonth");
		   Assert.assertEquals(currentYear, truYear, "Validation Done, TruTime Year doesn't matches CurrentYear");
		   
		   System.out.println("Validation Done, Trutime Month and Year Matches Current Month and Year");
		   System.out.println("<------------------------------------------------->");
	}

	@Then("Print all legends")
	public void print_all_legends() throws IOException {
		List<WebElement> Tags = dvd.legends();
		System.out.println("*******List of Legends********* ");
	    for(int i =0;i<Tags.size();i++) 
	    {
	    	String legends=Tags.get(i).getText();
	    	System.out.println(legends);
	    	Legend.add(legends);
	   
	    }
	    System.out.println("******************Project Console Ends******************");
	 	e.exceldata(SystemDates,Legend);
	}

}

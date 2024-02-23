package Cucumber.stepDefinitions;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import Cucumber.factory.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import Cucumber.factory.*;

public class Hooks {
	 public static WebDriver driver;
	 public static Properties p;
	 
	 
	@BeforeAll
   public static void setup() throws IOException, InterruptedException
   {
   Thread.sleep(2000);
		driver=BaseClass.initilizeBrowser();
   	p=BaseClass.getProperties();
   	Thread.sleep(15000);
   	driver.get(p.getProperty("appURL"));
   	Thread.sleep(10000);
   	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
   	driver.manage().window().maximize();
   	Thread.sleep(25000);

	}
	
	@AfterStep
    public static void addScreenshot(Scenario scenario) {
    	// this is for cucumber junit report
        	TakesScreenshot ts=(TakesScreenshot) driver;
        	byte[] screenshot=ts.getScreenshotAs(OutputType.BYTES);
        	scenario.attach(screenshot, "image/png",scenario.getName());
    }

   @AfterAll
   public static void tearDown() {
      driver.quit();
   }
   
   
   
   
}
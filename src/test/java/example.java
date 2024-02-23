import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import Cucumber.factory.BaseClass;

public class example {
WebDriver driver;

public void scroll() throws InterruptedException {
	driver= new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.get("https://be.cognizant.com/");
	Thread.sleep(10000);
	
	WebElement plusone=driver.findElement(By.xpath("//*[@id='QuicklinksItemTitle']"));
	JavascriptExecutor js=(JavascriptExecutor) driver;
	js.executeScript("arguments[0].scrollIntoView();", plusone);
	WebElement element =driver.findElement(By.xpath("//*[@id='vpc_WebPart.QuickLinksWebPart.internal.89c5ffca-2ffb-4052-a723-e99c8c9a14ef']/div/div/div/div[2]/div/div/div/div/div/div/div/div[1]/div[1]/div/div/div/a/div"));
	//*[@id="QuicklinksItemTitle"]
	if(element!=null)
		System.out.println("OneCognizant is Present");
	else
		System.out.println("OneCognizant is Absent");
	Thread.sleep(1000);
	element.click();
}
	public static void main(String[] args) throws InterruptedException {
		example ex = new example();
		ex.scroll();

	}

}

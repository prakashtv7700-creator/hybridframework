package uitests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestIsEnabled {
WebDriver driver;
	
	
	@BeforeClass
	public void launchBrowser() {
		
		driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/dynamic_controls");
	}
	
	@Test
	public void TestIsEnabled() {
	WebElement inputbox =	driver.findElement(By.xpath("//form[@id='input-example']/child::input"));
	boolean inputboxstatus = inputbox.isEnabled();
	 
	 if(inputboxstatus==false) {
		 WebElement enablebutton =	driver.findElement(By.xpath("//form[@id='input-example']/child::button"));
		 enablebutton.click();
		 WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 mywait.until(ExpectedConditions.elementToBeClickable(inputbox)).sendKeys("Now input box enabled");
		System.out.println(inputbox.getAttribute("value"));
	 }
	 
	}
	
	@AfterClass
	public void CloseBrowser() {
		driver.quit();
	}
}

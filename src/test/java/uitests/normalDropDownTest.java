package uitests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class normalDropDownTest {
	 WebDriver driver;
	 @Test
	 public void normaldropdown() {
	    driver=new ChromeDriver();
		driver.get("https://www.spicejet.com/");
		WebElement normaldpdwn = driver.findElement(By.xpath("//div[contains(text(),'INR')]"));
		
		WebDriverWait mywait = new WebDriverWait(driver,Duration.ofSeconds(10));
		mywait.until(ExpectedConditions.elementToBeClickable(normaldpdwn));
		normaldpdwn.click();
		
		 List<WebElement> alldpdwn = driver.findElements(By.xpath("//div[contains(@class,'css-1dbjc4n r-14lw9ot r-z2wwpe r-1rjd0u6')]"));
	     for(WebElement aldd :alldpdwn) {
	    	String allcurrency= aldd.getText();
	    	System.out.println(allcurrency);
	    	 if(allcurrency.contains("USD")) {
	    		 aldd.click();
	    	 }
	     }
	     
	     driver.close();
	 }
	 
}

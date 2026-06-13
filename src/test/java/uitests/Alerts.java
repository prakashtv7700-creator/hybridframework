package uitests;

import java.awt.Desktop.Action;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Alerts {
WebDriver driver;
	
	@Test
	public void switchToalrts() {
		driver=new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		WebElement JSAlert = driver.findElement(By.xpath("//button[contains(normalize-space(),'Click for JS Alert')]"));
		JSAlert.click();
		Alert alt= driver.switchTo().alert();
		alt.accept();
		driver.quit();
	}
}

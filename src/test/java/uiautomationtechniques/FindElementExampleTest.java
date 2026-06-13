package uiautomationtechniques;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FindElementExampleTest {
	public WebDriver driver;
	
    @Test
	public void numberoflinks() {
		 driver = new ChromeDriver();
		driver.get("http://ajayautomates.com/");
		List<WebElement> links = driver.findElements(By.tagName("a"));
        links.get(0).getText();
		
		for(int i=0; i<links.size(); i++) {
			String Linktext =links.get(i).getText();
			System.out.println(Linktext);
		}
		
		driver.quit();
		
	}
}

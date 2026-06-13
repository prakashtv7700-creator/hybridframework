package uitests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class DropDowns {
WebDriver driver;
	
	@Test
	public void dropdownvalidation() throws InterruptedException {
		driver=new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/dropdown");
		WebElement dropdownselect = driver.findElement(By.id("dropdown"));
		Select dropdown= new Select(dropdownselect);
		//select dropdown based on value
		//dropdown.selectByValue("2");
		
		//select dropdown based on visible text
		//dropdown.selectByVisibleText("Option 2");
				
		//select dropdown based on index position
		dropdown.selectByIndex(2);
		
		Thread.sleep(3000);
		driver.quit();
	}
}

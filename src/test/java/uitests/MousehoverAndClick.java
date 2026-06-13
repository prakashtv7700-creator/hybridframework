package uitests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class MousehoverAndClick {
WebDriver driver;
	@Test
	public void dropdownvalidation() throws InterruptedException {
		driver=new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/hovers");
		WebElement figure1	= driver.findElement(By.xpath("//div[contains(@class,'figure')]"));
		WebElement profile1 = driver.findElement(By.xpath("//a[contains(text(),'View profile')]"));
		
		Actions action = new Actions(driver);
		action.moveToElement(figure1).perform();
		profile1.click();
	    driver.close();
		
}
}
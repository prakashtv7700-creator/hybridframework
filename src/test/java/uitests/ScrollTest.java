package uitests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ScrollTest {
WebDriver driver;
	
	@Test
	public void scrollintoviewTest() throws InterruptedException {	
		driver=new ChromeDriver();
		driver.get("https://www.selenium.dev/documentation/webdriver/");
		driver.manage().window().maximize();
		WebElement linkname= driver.findElement(By.xpath("//a[text()='Web elements']"));
		JavascriptExecutor jse= (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,500)");
		Thread.sleep(5000);
		linkname.click();
		Thread.sleep(5000);
		driver.quit();
}

}

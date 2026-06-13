package uitests;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UploadfileTest {
	public class uploadfileTest {
		
		WebDriver driver;
			
			@Test
			public void mousehoverusingactions() throws InterruptedException {	
				driver=new ChromeDriver();
				driver.get("https://the-internet.herokuapp.com/upload");
				
				WebElement filepath = driver.findElement(By.xpath("//input[@id='file-upload']"));
				WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
				mywait.until(ExpectedConditions.elementToBeClickable(filepath));
				
				
				File uploadfile = new File(System.getProperty("user.dir") + "/UploadFiles/FileUpload.png");
				filepath.sendKeys(uploadfile.getAbsolutePath());
				
				
				WebElement clickuploadbtn = driver.findElement(By.id("file-submit"));
				clickuploadbtn.click();	
				
				
				//Use assertions to verify success message
				WebElement successmsg= driver.findElement(By.tagName("h3"));
				Assert.assertEquals(successmsg.getText(), "File Uploaded!");
				driver.quit();
				
		}}
}

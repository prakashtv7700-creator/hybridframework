package base;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

import pageobjects.DashBoardPage;
import pageobjects.LoginPage;
@Listeners(listeners.TestListener.class)
public class BaseTest {
	
	public WebDriver driver;
	public LoginPage page;
	public DashBoardPage Dashtest;
	public static Logger log = LogManager.getLogger(BaseTest.class);

	@BeforeClass
	public void launchBrowser() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notification");
		options.addArguments("--start-maximized");
		driver = new ChromeDriver(options);
		driver.get("https://www.saucedemo.com/");
		page=new LoginPage(driver);
		Dashtest = new DashBoardPage(driver);
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	
	public String captureScreenshot(String testName) {
    	String path = System.getProperty("user.dir")+ "/screenshots/" + testName + ".png";
    	try {
    	File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);	
    	File dest = new File(path);
    	FileUtils.copyFile(src, dest);
    	}catch (IOException e)
    	{
    		e.printStackTrace();
    	}
    	return path;
    } 
	
	@AfterClass
	public void CloseBrowser() {
		driver.quit();
	}
}

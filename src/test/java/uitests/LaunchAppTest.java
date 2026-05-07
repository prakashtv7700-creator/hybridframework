package uitests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LaunchAppTest {
	
	WebDriver driver;
	
	
	@BeforeClass
	public void launchBrowser() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notification");
		options.addArguments("--start-maximized");
		driver = new ChromeDriver(options);
		driver.get("https://www.saucedemo.com/");
	}
	
	@Test(priority=0,enabled=true)
	public void validateUI() {
		String actualtitle= driver.getTitle();
		String expectedtitle = "Swag Labs";
		Assert.assertEquals(actualtitle, expectedtitle);
		Assert.assertTrue(driver.findElement(By.xpath("//input[@id='user-name']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//input[@id='password']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//input[@id='login-button']")).isDisplayed());
	}
	
	
	@Test(priority=1,enabled=true)
	public void invalidLoginTest() {
		driver.navigate().refresh();
		WebElement username = driver.findElement(By.id("user-name"));
		username.sendKeys("UserName");
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("Pwd");
		WebElement login = driver.findElement(By.id("login-button"));
		login.click();
		String errortext= driver.findElement(By.cssSelector("h3")).getText();
		Assert.assertTrue(errortext.contains("Username and password do not match"));
	}
	
	@Test(priority=2,enabled=true)
	public void emptyCredentialsTest() {
		driver.navigate().refresh();
		WebElement login = driver.findElement(By.id("login-button"));
		login.click();
		String errortext= driver.findElement(By.cssSelector("h3")).getText();
		Assert.assertTrue(errortext.contains("Username is required"));
	}
	
	@Test(priority=3,enabled=true)
	public void lockedUserTest() {
		driver.navigate().refresh();
		WebElement username = driver.findElement(By.id("user-name"));
		username.sendKeys("locked_out_user");
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("secret_sauce");
		WebElement login = driver.findElement(By.id("login-button"));
		login.click();
		String errortext= driver.findElement(By.cssSelector("h3")).getText();
		Assert.assertTrue(errortext.contains("this user has been locked out"));
	}
	
	@Test(priority=4,enabled=true)
	public void login() {
		//launch browser
		driver.navigate().refresh();
		WebElement username = driver.findElement(By.id("user-name"));
		username.sendKeys("standard_user");
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("secret_sauce");
		WebElement login = driver.findElement(By.id("login-button"));
		login.click();
		
		String CurrentURL = driver.getCurrentUrl();
		Assert.assertTrue(CurrentURL.contains("inventory"));
	}
	
	@Test(priority=5,enabled=true)
	public void logiout() {
		driver.findElement(By.id("react-burger-menu-btn")).click();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logout_sidebar_link"))).click();
		String CurrentURL = driver.getCurrentUrl();
		Assert.assertTrue(CurrentURL.contains("saucedemo"));
	}
	@AfterClass
	public void CloseBrowser() {
		driver.quit();
	}
	
	
		
		//enter url
		//click enter
	

}

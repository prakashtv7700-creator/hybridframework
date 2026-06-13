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

import base.BaseTest;
import pageobjects.LoginPage;
import utilities.ExcelUtils;


public class LaunchAppTest extends BaseTest {

	@Test(priority=0,enabled=true)
	public void validateUI() {
		String actualtitle= driver.getTitle();
		String expectedtitle = "Swag Labs";
		Assert.assertEquals(actualtitle, expectedtitle);
		Assert.assertTrue(page.isusernamedisplayed());
		Assert.assertTrue(page.ispassworddisplayed());
		Assert.assertTrue(page.islogindisplayed());
		log.info("UI validated");
	}
	
	
	@Test(priority=1,enabled=true)
	public void invalidLoginTest() {
		driver.navigate().refresh();
		String username =
                ExcelUtils.getTestData("InvalidLogin", "Username");
        String password =
                ExcelUtils.getTestData("InvalidLogin", "Password");
        String expectedError =
                ExcelUtils.getTestData("InvalidLogin", "ExpectedResult");
        page.logintoapplication("InvalidLogin", "ExpectedResult");
		String errortext= page.geterrrotext();
		Assert.assertTrue(errortext.contains("Username and password do not match"));
		log.info("invalid test success");
		
	}
	
	@Test(priority=2,enabled=true)
	public void emptyCredentialsTest() {
		driver.navigate().refresh();
		page.clicklogin();
		String errortext= page.geterrrotext();
		Assert.assertTrue(errortext.contains("Username is required"));
		log.info("empty cred test success");
	}
	
	@Test(priority=3,enabled=true)
	public void lockedUserTest() {
		driver.navigate().refresh();
		page.logintoapplication("locked_out_user", "secret_sauce");
		String errortext= page.geterrrotext();
		Assert.assertTrue(errortext.contains("this user has been locked out"));
		log.info("lockeduser test success");
	}
	
	@Test(priority=4,enabled=true)
	public void login() {
		//launch browser
		driver.navigate().refresh();
		page.logintoapplication("standard_user", "secret_sauce");
		String CurrentURL = driver.getCurrentUrl();
		Assert.assertTrue(CurrentURL.contains("inventory"));
		log.info("login test success");
	}
	
	@Test(priority=5,enabled=true)
	public void logout() {
		page.logoutapplication();
		String CurrentURL = driver.getCurrentUrl();
		Assert.assertTrue(CurrentURL.contains("saucedemo"));
		log.info("logout test success");
	}

	
	
		
		//enter url
		//click enter
	

}

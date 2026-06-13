package pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
	WebDriver driver;
	
	By Username = By.id("user-name");
	By Password = By.id("password");
	By Login = By.id("login-button");
	By ErrorText = By.cssSelector("h3");
	By MenuButton = By.id("react-burger-menu-btn");
	By Logout =By.id("logout_sidebar_link");
	
	public LoginPage(WebDriver driver){
		this.driver=driver;
	}

	public void enterusername(String username) {
	driver.findElement(Username).sendKeys(username);
	}
	
	public void enterpassword(String password) {
		driver.findElement(Password).sendKeys(password);
	}
	
    public void clicklogin() {
    	driver.findElement(Login).click();
	}
    
    public void clickmenubutton() {
    	driver.findElement(MenuButton).click();
    }
    
    public void clicklogout() {
    	driver.findElement(Logout).click();
    }
    
    public String geterrrotext() {
    	return driver.findElement(ErrorText).getText();
	}
    public boolean isusernamedisplayed() {
		return driver.findElement(Username).isDisplayed();
		
	}
    
    public boolean ispassworddisplayed() {
		 return driver.findElement(Password).isDisplayed();
		
   	}
    
    public boolean islogindisplayed() {
		 return driver.findElement(Login).isDisplayed();
		
   	}
    
    public void logintoapplication(String username, String Password) {
    	enterusername(username);
    	enterpassword(Password);
    	clicklogin();
    }
    
    public void logoutapplication() {
    	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("react-burger-menu-btn"))).click();
		WebDriverWait mywait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logout_sidebar_link"))).click();
    }
}

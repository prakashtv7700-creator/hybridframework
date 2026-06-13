package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashBoardPage {
	
	WebDriver driver;
	By Username = By.id("user-name");
	By Password = By.id("password");
	By Login = By.id("login-button");
	By PageTitle = By.xpath("//div[contains(text(),'Swag Labs')]");
	By Filer = By.xpath("//select[@data-test='product-sort-container']");
	
	
	
	public DashBoardPage(WebDriver driver) {
	this.driver=driver;
	}
	
    public void logintoapplication(String username, String password) {
		 driver.findElement(Username).sendKeys(username);
		 driver.findElement(Password).sendKeys(password);
		 driver.findElement(Login).click();
	    	
	    }
	
	public void getfilter() {
		driver.findElement(Filer).click();
	}

}

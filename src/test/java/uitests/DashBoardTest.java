package uitests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import base.BaseTest;
import pageobjects.DashBoardPage;
import pageobjects.LoginPage;

public class DashBoardTest extends BaseTest{
	
	DashBoardPage Dashtest;
	
	
	@Test
	public void validateFilter() throws InterruptedException {
		Dashtest = new DashBoardPage(driver);
		Dashtest.logintoapplication("standard_user", "secret_sauce");
		Thread.sleep(5000);
		Dashtest.getfilter();
		
	}

}

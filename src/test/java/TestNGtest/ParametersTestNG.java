package TestNGtest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParametersTestNG {
	WebDriver driver;
	@Parameters({"browser","envi"})
	@Test
	public void loginTest(String browser, String envi) {
		if(browser.equalsIgnoreCase("chrome")) {
		driver= new ChromeDriver();
		} else if(browser.equalsIgnoreCase("edge")) {
			driver= new EdgeDriver();
		}
		
		String url ="";
		if(envi.equalsIgnoreCase("qa")) {
			url="http://www.ajayautomates.com/";
		}
		else if(envi.equalsIgnoreCase("prod")) {
			url="https://prod.ajayautomates.com/";
		}
		
		driver.get(url);
		driver.close();
	}

}

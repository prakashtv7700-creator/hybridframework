package uitests;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Brokenlinks {
	
	WebDriver driver;
	@BeforeClass
	public void browsersetup()
	{
		    driver = new ChromeDriver();
		    driver.manage().window().maximize();
		    driver.get("https://www.google.com/");
	}
	
	@Test (priority=0,enabled=true)
	public void verifybrokenlinks() throws MalformedURLException, IOException {	
		List<WebElement> mylist = driver.findElements(By.tagName("a"));
		
		for(int i=0; i<mylist.size();i++) {
			String url = mylist.get(i).getAttribute("href");
			
			if(url==null||url.isEmpty()||url.startsWith("JavaScript")) {
				continue;
			}
			try {
			HttpURLConnection connection = (HttpURLConnection)new URL(url).openConnection();
			connection.setReadTimeout(5000);
			connection.connect();
			int responsestatus= connection.getResponseCode();
			
			if(responsestatus>=400) {
				System.out.println("BrokenLink");
			}else {
				System.out.println("ValidLink");
			}
			}catch(Exception e) {
				System.out.println("Exception for url "+url);
			}
		}
	    
	}
	@AfterClass
	public void teardown()
	{
		driver.quit();
	}	
}

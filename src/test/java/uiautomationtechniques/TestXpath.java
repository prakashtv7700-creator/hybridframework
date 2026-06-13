package uiautomationtechniques;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestXpath {
	@Test
	public void tests() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/search?q=Automation+Testing&sca_esv=02e68678eb2dc54b&source=hp&ei=FDgFaqfxFt6gnesPwMi-mQg&iflsig=AFdpzrgAAAAAagVGJMxeIdKn8I1kctllAY07dZKho1oe&ved=0ahUKEwiny9OX4reUAxVeUGcHHUCkL4MQ4dUDCB4&uact=5&oq=Automation+Testing&gs_lp=Egdnd3Mtd2l6IhJBdXRvbWF0aW9uIFRlc3RpbmdIQFAAWD5wAHgAkAEAmAEAoAEAqgEAuAEDyAEA-AEBmAIAoAIAmAMAkgcAoAcAsgcAuAcAwgcAyAcAgAgB&sclient=gws-wiz&sei=FTgFaq77FP6QnesPjaiqoAo");
		//driver.findElement(By.id("APjFqb")).sendKeys("Automation Testing", Keys.ENTER);
		driver.findElement(By.xpath("//h3[contains(text(),'Test automation')")).click();
	}

}

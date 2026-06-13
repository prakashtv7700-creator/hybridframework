package uitests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class MultiDropDowns {
   WebDriver driver;
    @Test
	public void multiselectdropdown() {
    	driver=new ChromeDriver();
		driver.get("https://syntaxprojects.com/basic-select-dropdown-demo.php");
		WebElement multiselectdropdown = driver.findElement(By.id("multi-select"));
		Select select = new Select(multiselectdropdown);
		if(select.isMultiple()) {
			select.selectByVisibleText("Florida");
			select.selectByVisibleText("Texas");
			select.selectByVisibleText("California");
			System.out.println("Selected values are:");
			List<WebElement> selectedoptions = select.getAllSelectedOptions();
			for(WebElement slop:selectedoptions) {
				System.out.println(slop.getText());
			}
		}
		
		else {
			System.out.println("This is not multi selected dropdown");
		}
		
		driver.close();
	}
}

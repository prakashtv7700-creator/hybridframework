package TestNGtest;

import org.testng.annotations.Test;

public class DependsOnMethodTest {
	@Test
	public void login() {
		
	}
	
	@Test(dependsOnMethods = "login")
	public void dashboard() {
		
	}

}

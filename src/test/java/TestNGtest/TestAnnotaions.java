package TestNGtest;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestAnnotaions {
	@BeforeTest
    public void beforeTest() {
        System.out.println("This method runs before <TEST> tag starts (BeforeTest)");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("This method runs before the first method in the class (BeforeClass)");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("This method runs before each @Test method (BeforeMethod)");
    }

    @Test (priority=2)
    public void testCase1() {
        System.out.println("Executing Test Case 1");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("This Method runs after each @Test method (AfterMethod)");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("This Method runs after all test methods in class are executed (AfterClass)");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("This Method runs after <TEST> tag completes (AfterTest)");
    }
	

}

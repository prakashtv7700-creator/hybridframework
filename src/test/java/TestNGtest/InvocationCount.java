package TestNGtest;

import org.testng.annotations.Test;

public class InvocationCount {
@Test(invocationCount=10)
public void logintest() {
	System.out.println("I will be executed 10 times");
}
}

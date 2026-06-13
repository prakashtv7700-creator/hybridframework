package TestNGtest;

import org.testng.annotations.Test;

public class groupingTest {
@Test(enabled=true,groups="smoke")
public void login1() {
	System.out.println("I am smoke group");
}

@Test(enabled=true,groups="regression")
public void login2() {
	System.out.println("I am regression group");
}

@Test(enabled=true,groups={"regression","smoke"})
public void login3() {
	System.out.println("I am smoke and regression group");
}
}

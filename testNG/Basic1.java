package testNG;

import org.testng.annotations.Test;

public class Basic1 {
	
	@Test (priority = 2)
	
	public void methodA() {
		System.out.println("Hello Team");
	}
	
	@Test (priority = 1)
	public void methodB() {
		System.out.println("Bye Team");
	}
	

}



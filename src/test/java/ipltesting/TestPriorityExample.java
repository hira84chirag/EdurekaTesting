package ipltesting;

import org.testng.annotations.Test;

public class TestPriorityExample {
	
	@Test(priority=1)	
	public void a1() {
		
		 System.out.println("Running A1 method");	
	}
	@Test(priority=2)
	public void a2() {
		
		 System.out.println("Running A2 method");	
	}
	@Test(priority=1)
	public void a4() {
		
		 System.out.println("Running A3 method");	
	}
	@Test(priority=2)
	public void a3() {
		
		 System.out.println("Running A4 method");	
	}
}

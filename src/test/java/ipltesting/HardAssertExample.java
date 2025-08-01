package ipltesting;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class HardAssertExample {
	@Test
	public void tc1() {
		int a=6;
		assertTrue(a>=5,"Value of a is not greater than or equall to 5");
		Reporter.log("a = " + a);
		System.out.println("From tc1="+ a);

		 
	}
	@Test
	public void tc2() 
	{
		try {
	//	 int a=4; assertTrue(a>5); 
		}catch(Exception e) {
			e.getStackTrace();
		System.out.println("From tc2");
		}
	}
	
}

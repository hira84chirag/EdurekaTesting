package ipltesting;

import static org.testng.Assert.assertTrue;

import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

// Avoid soft assert as much as possible,because the flow is going to break
// it does not sometimes follow the tractability matrix  base implementation
// 1:1 test case implementation does not make sense with soft assert


public class SoftAssertExample {
	SoftAssert sa;
	@Test
	public void tc1() {
		SoftAssert sa=new SoftAssert();
		int a=48;
		sa.assertTrue(a>=5,"Value of a is not greater than or equall to 5");
		Reporter.log("a = " + a);
		System.out.println("From tc="+ a);
		sa.assertAll();
		 
	}
	@Test
	public void tc2() 
	{		
		int a=5; assertTrue(a>5);
		System.out.println("From tc2");
		sa.assertAll();
	}
	
}

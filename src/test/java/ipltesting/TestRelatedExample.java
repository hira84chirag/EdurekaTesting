package ipltesting;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestRelatedExample {
	
	@Test(description="Login Valid username and password for testing")
	public void ValidUsernameandPassword() {
		
		 System.out.println("Running method in the automation");	
	}
	@Test(description="Login Valid username for testing")
	public void ValidUsernameandPassword1() {
		
		 System.out.println("Login Valid username for testing");	
	}
	@Test(description="Login Valid password for testing")
	public void ValidUsernameandPassword2() {
		
		 System.out.println("Login Valid password for testing");	
	}

}

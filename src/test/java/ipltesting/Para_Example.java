package ipltesting;

import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Para_Example {
	
	
	@Parameters({"Username","Password"})
	@Test
	public void validLogin(String uname,String Password) {		
		Reporter.log("Username ="+  uname);
		Reporter.log("Passowrd =" + Password); 		
	}

	@Parameters({"Username1","Password1"})
	@Test
	public void InvalidLogin(String uname,String Password) {		
		Reporter.log("Username ="+  uname);
		Reporter.log("Passowrd =" + Password); 		
	}
	
}

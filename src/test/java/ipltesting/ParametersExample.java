package ipltesting;

import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParametersExample {
  
	@Parameters({"Username","Password"})
	@Test
	public void ValidusrnameValidPasswordTest(String username,String password) {
	  Reporter.log("Username=" + username);
	  Reporter.log("Password=" + username);
	  
	}
}

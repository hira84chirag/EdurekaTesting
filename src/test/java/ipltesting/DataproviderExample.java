package ipltesting;

import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataproviderExample {

	@Test(dataProvider = "dp")
    public void validLogin(String uname,String password) {		
		Reporter.log("Username ="+  uname);
		Reporter.log("Passowrd =" + password); 		
	}
  

  @DataProvider
  public String[][] dp() { 
    return new String[][] {
      new String[] { "Software Testing", "Method Testing" },
      new String[] { "Testing software", "testing Method" },
      new String[] { "Testing software123", "testing Method123" },
    };
  }
  
}

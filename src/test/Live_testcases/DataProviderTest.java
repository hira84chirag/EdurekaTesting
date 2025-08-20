package Live_testcases;

import org.testng.annotations.Test;

import javax.xml.stream.XMLReporter;

import org.testng.Reporter;
import org.testng.annotations.DataProvider;

public class DataProviderTest {
  @Test (dataProvider = "dp")
  
  public void validLogin(String uname,String Password) {		
		Reporter.log("Username ="+  uname);
		Reporter.log("Passowrd =" + Password); 		
		
	}

  @DataProvider  
  public String[][] dp() {
    return new String[][] {
      new String[] { "1", "chnirag" },
      new String[] { "2", "patel" },
    };
  }
}

package Live_testcases;

import org.testng.annotations.Test;
import pom.Obj_RediffValidation;


public class RediffValidation extends BaseBrowser {
	
	
	@Test
	public void Redfflogin() {
		// Open  browser and pass url
		BaseBrowser br=new BaseBrowser();	
		br.beforetest("chrome","https://mail.rediff.com/cgi-bin/login.cgi");
		
		// Create object from object Repository 
		Obj_RediffValidation obj=new Obj_RediffValidation(driver);
		
		// Enter user name
		obj.enteruname("chiragpatel@infosystechnologies.com");
		// Enter password
		obj.enterpwd("SoftwareTestingHead");	
		// Get value by FindBy Method.	
		obj.getvalue();
		
		// Click sign in button.
		obj.clicksignbtn();
		
		driver.quit();
	}

}

package test;
import java.time.Duration;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import Utilities.CommonFunctions;
import pom.Obj_Facebook;
public class Test_facebook extends SetupBrowser{	
//	String path="//input[@aria-label='Email address or phone number']";
//	String path1 = ("//input[@autocomplete='username webauthn']"); // update path
	
	@Test 
	public void facebook_locator()
	{				
		Obj_Facebook obj=new Obj_Facebook(driver);
		obj.openFacebook();
		obj.enterEmail("from Username changes");
		obj.clickCreateNewAccount();
		obj.enterEmail("from Royal id");
	}

}

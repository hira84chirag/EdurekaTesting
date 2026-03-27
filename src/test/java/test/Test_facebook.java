package test;
import java.time.Duration;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import Utilities.CommonFunctions;
import pom.Obj_Facebook;
public class Test_facebook extends SetupBrowser{
	
	String path="//input[@aria-label='Email address or phone number']";
	String path1 = ("//input[@autocomplete='username webauthn']"); // update path
	
	@Test 
	public void facebook_locator()
	{
		
		driver.get("https://www.facebook.com"); 	
		Obj_Facebook aobj=new Obj_Facebook(driver);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(260));
		driver.findElement(By.name("email")).sendKeys("from Username changes");
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(300));
		aobj.clickCreateNewAccount();
		driver.navigate().back();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(300));
	 	driver.findElement(By.name("email")).sendKeys("from Royal id");			
	}

}

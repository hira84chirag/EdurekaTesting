package ipltesting;
import java.time.Duration;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import Util.CommonFunctions;
import pom.Obj_Facebook;
public class Test_facebook extends SetupBrowser{
	private	String path="//input[@aria-label='Email address or phone number']";

	@Test
	public void openFacebook() {
		Test_facebook obj =new Test_facebook();
		obj.browserOpen("Firefox", "http://www.facebook.com");
		Obj_Facebook aobj=new Obj_Facebook(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));
		aobj.clickCreateNewAccount();
		driver.quit();
	}

	@Test 
	public void locator()
	{
		Test_facebook obj =new Test_facebook();	
		obj.browserOpen("Firefox", "https://www.facebook.com"); 	
		driver.findElement(By.xpath(path)).sendKeys("from Royal id");		
		CommonFunctions.waitImplicit(driver, 30);
		driver.findElement(By.linkText("Create new account")).click();	
		CommonFunctions.waitImplicit(driver, 1000);		
		driver.quit();
	}


}

package Live_testcases;
import org.testng.annotations.Test;
import pom.Obj_Edureka;
import ipltesting.SetupBrowser;


public class EdurekaLogin extends SetupBrowser{
	@Test
	//public static void main(String[] args) throws InterruptedException
	public void Edureka() throws InterruptedException{
		// TODO Auto-generated method stub
			
		EdurekaLogin obj=new EdurekaLogin();	
		obj.browserOpen("chrome","https://www.edureka.co/signin");		
		driver.manage().window().maximize();
	//	Click Log in button on Homepage
		Obj_Edureka Eduobj=new Obj_Edureka(driver);
		Eduobj.clickHomepageLogin();
		Thread.sleep(100);		
		Eduobj.clickLoginbtn();
		// get email message from web elements	
		Eduobj.getLoginValue();
		
		driver.quit();
	}

}

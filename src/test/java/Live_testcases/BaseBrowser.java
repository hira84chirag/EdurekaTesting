package Live_testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import Util.SetupBrowser;

public class BaseBrowser {
	SetupBrowser common;
	//String  browser="chrome";
	//String url="http://wwww.facebook.com";
	public static WebDriver  driver;
	
	// String browser,String url
	
//	@BeforeTest
//	@Parameters({"browser","url"})
	public void beforetest(String browser,String url) {
		
		//open browser and url
		common =new SetupBrowser();		
		common.openBrowser(browser, url); 
		driver=common.getDriver();
	}
	
	//@AfterTest	
	public void quiteBrowser() {
		//Quite the browser
		common.QuitBrowser();
	
	}
}

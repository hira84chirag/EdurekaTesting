package Live_testcases;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import com.beust.jcommander.Parameter;
import Util.SetupBrowser;

public class BaseBrowser {
	// Calling browser from common method.
	SetupBrowser common;
	//String  browser="chrome";
	//String url="http://wwww.facebook.com";
	public static WebDriver  driver;
	
	@BeforeTest
//	@Parameter({"browser","urlfb"})
	public void beforetest(String browser,String url) {	
		//open browser and url
		common =new SetupBrowser();		
		common.openBrowser(browser, url); 
		driver=common.getDriver();
	}
	
	@AfterTest	
	public void quiteBrowser() {
		//Quite the browser
		common.QuitBrowser();
	
	}
}

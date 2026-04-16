package pom;
import java.time.Duration;
import org.testng.Reporter;
import Utilities.CommonFunctions;
import test.BaseTest;
	
public class BrowserCommand_page extends BaseTest {
	public BrowserCommand_page() throws Exception {
		super();
	}
	String path="//span[contains(text(),'Next')]";	
	public void navigatetourl(String url) {
		driver.get(pro1.getProperty(url));
		driver.manage().window().maximize();
		System.out.println("Navigating to "+ url);
	}
public void Google_Url() {
		navigatetourl("googlesignin");
		// adding this code later
		navigatetourl("googleurl");	
		//CommonFunctions.waitForElementToClick(driver, path);
		CommonFunctions.partiallinktext(driver, "Sign in");			
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(700));		
		CommonFunctions.waitForElementToClick(driver, path);
	}
//code done
public void f() {
		String youtube="https://www.youtube.com/results?search_query=Trending";
		navigatetourl("youtube");
		CommonFunctions.waitforelement(driver, "endpoint");
		Reporter.log("Navigating to youtube page");
		//back button
		Reporter.log("Navigating back to youtube page");
		driver.navigate().back();
	
		//forward
		Reporter.log("Navigating forward to youtube page");
		driver.navigate().forward();
		CommonFunctions.waitforelement(driver, "endpoint");
		// refresh
		Reporter.log("Navigating to refresh youtube page");
		driver.navigate().refresh();
	}
	// code optimizatin is pedning
	public void googleNavigate() throws InterruptedException {
		String photo;
		navigatetourl("googleurl");	
		//Thread.sleep is used only for demo purpose
		Thread.sleep(1000);
		CommonFunctions.waitThread(1000);
		navigatetourl("youtubevideo");
		CommonFunctions.waitImplicit(driver, 500);
		photo=CommonFunctions.Snap(driver, "trending_");
		
		//back
		System.out.println("Navigating back to youtube page");
		CommonFunctions.waitThread(1000);
		driver.navigate().back();
    	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));
		CommonFunctions.waitImplicit(driver, 500);
		photo=CommonFunctions.Snap(driver, "trending_");
		//forward
		System.out.println("Navigating forward to youtube page");
		CommonFunctions.waitThread(1000);
		driver.navigate().forward();

		CommonFunctions.waitImplicit(driver, 500);;
		photo=CommonFunctions.Snap(driver, "trending_");

		System.out.println("Refresh the youtube page");
		CommonFunctions.waitThread(1000);
		driver.navigate().refresh();

	}
}

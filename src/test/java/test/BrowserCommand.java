package test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Test;
import Utilities.CommonFunctions;

public class BrowserCommand extends BaseTest {

	String url="", path="";
//	String google=prop.getProperty("googleurl");
	@Test(priority =1)
	public void Google_Browsercommand() {
		
		// TODO Auto-generated method stub
		String gle="https://www.gmail.com";
		try {			
			driver.get(gle);
			url=driver.getCurrentUrl();
			Reporter.log("Current URL=" + url);
			
			url=driver.getTitle();
			Reporter.log("Title of the browser=" + url);
			
			url=driver.getPageSource();
			Reporter.log("Page source testing of site=" + url);
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	// Browser command forward, Refresh,back and 
	@Test(priority =2)
	public void Youtube_Navigation() throws InterruptedException {
		
		String youtube="https://www.youtube.com/results?search_query=Trending";
		driver.get(prop.getProperty("googleurl"));
		driver.manage().window().maximize();
		Thread.sleep(100);
		Reporter.log("Navigating to youtube page");
		driver.navigate().to(youtube);
		Thread.sleep(100);
		//back button
		Reporter.log("Navigating back to youtube page");
		driver.navigate().back();
		Thread.sleep(100);
		//forward
		Reporter.log("Navigating forward to youtube page");
		driver.navigate().forward();
		Thread.sleep(100);
		// refresh
		Reporter.log("Navigating to refresh youtube page");
		driver.navigate().refresh();
	
	}
	
	@Test(priority =3)
	public void GoogleSignClick() {		
		driver.get(prop.getProperty("googleurl"));	
		path="//span[contains(text(),'Next')]";	
		driver.findElement(By.partialLinkText("Sign in")).click();		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7000));
		driver.findElement(By.xpath(path)).click(); 
	
		
	}
	@Test(priority = 4)
	public void Google_navDemo() throws InterruptedException {
		String photo;

		driver.get(prop.getProperty("googleurl"));
		//Thread.sleep is used only for demo purpose
		System.out.println("Navigating to youtube page");
		Thread.sleep(1000);
		CommonFunctions.waitThread(1000);
		driver.manage().window().maximize();
		driver.navigate().to("https://www.youtube.com/results?search_query=trending+comedy+videos");
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

// url="https://accounts.google.com/v3/signin/identifier?continue=https%3A%2F%2Fwww.google.com%2F%3Fptid%3D19027681%26ptt%3D8%26fpts%3D0&ec=futura_hpp_co_si_001_p&ifkv=Ab5oB3oOBeSSzLvI7I2SyFp2UzdeOjSkkgOhxK81XkJRBGclPnUdrutr4e004ANC3Zvgvkcn-naF&flowName=GlifWebSignIn&flowEntry=ServiceLogin&dsh=S-1155940431%3A1723453620082723&ddm=0";
//	driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();		

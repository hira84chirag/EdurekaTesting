package ipltesting;

import java.time.Duration;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Test;

import Util.CommonFunctions;

public class BrowserCommand extends SetupBrowser {

	String url="", path="";
	
	@Test(priority =1)
	public void Browsercommand() {
		// TODO Auto-generated method stub
		String gle="https://www.gmail.com";
		try {			
			BrowserCommand bc=new BrowserCommand();
			bc.browserOpen("chrome","");
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
		driver.quit();
		
	}
	// Browser command forward, Refresh,back and 
	@Test(priority =2)
	public void Navigation() throws InterruptedException {
		String google="https://www.google.com";
		String youtube="https://www.youtube.com/results?search_query=Trending";
		BrowserCommand bc=new BrowserCommand();
		bc.browserOpen("chrome","");
		driver.get(google);
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
		driver.quit();
	}
	
	@Test(priority =3)
	public void GoogleSignClick() {		
		BrowserCommand bc=new BrowserCommand();	
		bc.browserOpen("chrome","https://www.google.com/");						
		path="//span[contains(text(),'Next')]";	
		driver.findElement(By.partialLinkText("Sign in")).click();		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7000));
		driver.findElement(By.xpath(path)).click(); 
		driver.quit();
		
	}
	@Test(priority = 4)
	public void navDemo() throws InterruptedException {
		String photo;

		BrowserCommand obj=new BrowserCommand();
		obj.browserOpen("chrome", "https://www.google.com");		
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
		driver.quit();
	}
}

// url="https://accounts.google.com/v3/signin/identifier?continue=https%3A%2F%2Fwww.google.com%2F%3Fptid%3D19027681%26ptt%3D8%26fpts%3D0&ec=futura_hpp_co_si_001_p&ifkv=Ab5oB3oOBeSSzLvI7I2SyFp2UzdeOjSkkgOhxK81XkJRBGclPnUdrutr4e004ANC3Zvgvkcn-naF&flowName=GlifWebSignIn&flowEntry=ServiceLogin&dsh=S-1155940431%3A1723453620082723&ddm=0";
//	driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();		

package ipltesting;
import java.util.ArrayList;
import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class WindowManagementExample extends BaseTest{
	@Test	
	public void WindowHandlesdemo() throws InterruptedException  {
		
		WindowManagementExample obj = new WindowManagementExample();
		obj.setupBrowser("chrome", "https://www.facebook.com");
		
		//Thread.sleep is used for demo purpose only
		
		Reporter.log("page title:  " + driver.getTitle());
		Reporter.log("current window id - " + driver.getWindowHandle());
		Reporter.log("total window id's " + driver.getWindowHandles() );
		
		//clicking on the insta link
		driver.findElement(By.partialLinkText("Instagram")).click();
		Reporter.log("\n********************* After opening the insta page ********************************");
		Reporter.log("page title: " + driver.getTitle());
		Reporter.log("current window id - " + driver.getWindowHandle());
		Reporter.log("total window id's " + driver.getWindowHandles() );
				
		//tab shifting code
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		Reporter.log("\n********************* After switching to the insta page ********************************");
		Reporter.log("page title: " + driver.getTitle());
		Reporter.log("current window id - " + driver.getWindowHandle());
		Reporter.log("total window id's " + driver.getWindowHandles() );
			
		//closing the insta page
		//driver.close();
		driver.switchTo().window(tabs.get(0));
		Thread.sleep(3000);
		driver.switchTo().window(tabs.get(1));
		Reporter.log("\n********************* After switching to the fb page ********************************");
		Reporter.log("page title: " + driver.getTitle());
		Reporter.log("current window id - " + driver.getWindowHandle());
		Reporter.log("total window id's " + driver.getWindowHandles() );
		
		//quitting the browser
		Thread.sleep(5000);
		driver.quit();
//		System.out.println("page title: " + driver.getTitle()); //error
		
	}
}

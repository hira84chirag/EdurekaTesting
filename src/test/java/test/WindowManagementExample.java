package test;
import java.time.Duration;
import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class WindowManagementExample extends BaseTest{
	public WindowManagementExample() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	@Test	
	public void facebook_WindowHandlesdemo() throws InterruptedException  {
		
		driver.get(pro1.getProperty("fburl"));
		//Thread.sleep is used for demo purpose only
		
		Reporter.log("page title:  " + driver.getTitle());
		Reporter.log("current window id - " + driver.getWindowHandle());
		Reporter.log("total window id's " + driver.getWindowHandles() );
		
		//tab shifting code
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://www.instagram.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));	
		driver.switchTo().window(tabs.get(0));
		
		//clicking on the insta link
		driver.findElement(By.partialLinkText("Instagram")).click();
		Reporter.log("\n********************* After opening the insta page ********************************");
		Reporter.log("page title: " + driver.getTitle());
		Reporter.log("current window id - " + driver.getWindowHandle());
		Reporter.log("total window id's " + driver.getWindowHandles() );
				
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(500));			// driver.switchTo().window(tabs.get(1));

		Reporter.log("\n********************* After switching to the insta page ********************************");
		Reporter.log("page title: " + driver.getTitle());
		Reporter.log("current window id - " + driver.getWindowHandle());
		Reporter.log("total window id's " + driver.getWindowHandles() );
			
		//closing the insta page
		//driver.close();
		driver.switchTo().window(tabs.get(0));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));
		//	driver.switchTo().window(tabs.get(1));
		Reporter.log("\n********************* After switching to the fb page ********************************");
		Reporter.log("page title: " + driver.getTitle());
		Reporter.log("current window id - " + driver.getWindowHandle());
		Reporter.log("total window id's " + driver.getWindowHandles() );
		
		//quitting the browser
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(500));

		System.out.println("page title: " + driver.getTitle()); //error
		
	}
}

package ipltesting;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import Util.CommonFunctions;
import Util.GenericFun;
import pom.Obj_Rollsroyce;

public class Rollsroyce extends SetupBrowser{
	String url="https://www.rolls-royce.com";
	
	@Test
	public void mediaNavigation() throws IOException, InterruptedException {
		// TODO Auto-generated method stub
	
		String eleStr= "//li[@id='nav-investors-level1' and @class='level1 haschildren']";
		
		Rollsroyce obj=new Rollsroyce();
		obj.browserOpen("chrome",url );		
		driver.manage().window().maximize();
		// Click Accept All button
		Obj_Rollsroyce clk= new Obj_Rollsroyce(driver);
		clk.clickAcceptAll();  // CommonFunctions.Clickbutton(driver,acceptAll);
				
		Actions action = new Actions(driver);
		WebElement ele=driver.findElement(By.xpath(eleStr));
		action.moveToElement(ele).perform();
	
		CommonFunctions.waitImplicit(driver, 300);
		// Click presentation menu button
		clk.clickreportpresent();
//		CommonFunctions.waitForElement(driver, reportpresent);

		// Scroll by Pixels
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500)"); // Scroll down by 1000 pixels      
		CommonFunctions.waitImplicit(driver, 200);
  //      js.executeScript("window.scrollBy(200, 800)");
		
		// Click Year of Media
        clk.clickyear2022();
        Thread.sleep(200);
  //      clk.clickreportpresent();
        GenericFun.ScrollingPageSize(driver, 996);   //		CommonFunctions.Clickbutton(driver, year2022);		
//		CommonFunctions.waitForElement(driver, Presentele);
				
		// Take Screenshot of the page.
        CommonFunctions.Snap(driver, "Rollsroyce");		
		driver.quit();			
	}
}

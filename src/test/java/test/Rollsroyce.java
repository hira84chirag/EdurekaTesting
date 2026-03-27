package test;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import Utilities.CommonFunctions;
import pom.Obj_Rollsroyce;

public class Rollsroyce extends SetupBrowser{
	String url="https://www.rolls-royce.com";

	@Test
	public void Rolls_royce_mediaNavigation() throws Exception {
		// TODO Auto-generated method stub
	
		String eleInvestor= "//li[@id='nav-investors-level1' and @class='level1 haschildren']";
		driver.get(url );		
		driver.manage().window().maximize();
		// Click Accept All button
		Obj_Rollsroyce clk= new Obj_Rollsroyce(driver);
		clk.clickAcceptAll();  // CommonFunctions.Clickbutton(driver,acceptAll);
		CommonFunctions.waitImplicit(driver, 500);		
		
		Actions action = new Actions(driver);		
		WebElement eleInv=driver.findElement(By.xpath(eleInvestor));
		action.moveToElement(eleInv).perform();
		// Click presentation menu button
		clk.clickreportpresent();
		CommonFunctions.waitImplicit(driver, 200);
		// Scroll by Pixels
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500)"); // Scroll down by 1000 pixels      
		CommonFunctions.waitImplicit(driver, 200);
  //      js.executeScript("window.scrollBy(200, 800)");
		  Thread.sleep(200);
		// Click Year of Media
        clk.clickyear2022();
      
  //      clk.clickreportpresent();
        CommonFunctions.ScrollingPageSize(driver, 996);   //		CommonFunctions.Clickbutton(driver, year2022);		
//		CommonFunctions.waitForElement(driver, Presentele);
				
		// Take Screenshot of the page.
        CommonFunctions.Snap(driver, "Rollsroyce");		
			
	}
}
